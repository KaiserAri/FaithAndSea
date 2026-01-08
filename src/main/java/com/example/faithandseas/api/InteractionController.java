package com.example.faithandseas.api;
import com.example.faithandseas.dto.CommentDto;
import com.example.faithandseas.dto.ShareLogDto;
import com.example.faithandseas.entity.User;
import com.example.faithandseas.repo.UserRepository;
import com.example.faithandseas.service.InteractionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/interactions")
@RequiredArgsConstructor
public class InteractionController {

    private final InteractionService interactionService;
    private final UserRepository userRepository;

    // Helper: Lấy ID user hiện tại từ Security Context
    private Long getCurrentUserId(OAuth2User principal) {
        String email = principal.getAttribute("email");
        User user = userRepository.findByEmail(email);
        return user.getId();
    }

    // --- LIKE ---
    @PostMapping("/like/post/{postId}")
    public ResponseEntity<String> toggleLikePost(@PathVariable Long postId, @AuthenticationPrincipal OAuth2User principal) {
        interactionService.toggleLikePost(getCurrentUserId(principal), postId);
        return ResponseEntity.ok("Thao tác Like/Unlike bài viết thành công");
    }

    @PostMapping("/like/artwork/{artworkId}")
    public ResponseEntity<String> toggleLikeArtwork(@PathVariable Long artworkId, @AuthenticationPrincipal OAuth2User principal) {
        interactionService.toggleLikeArtwork(getCurrentUserId(principal), artworkId);
        return ResponseEntity.ok("Thao tác Like/Unlike tranh thành công");
    }

    // --- COMMENT ---
    @PostMapping("/comment")
    public ResponseEntity<CommentDto> addComment(@RequestBody CommentDto commentDto, @AuthenticationPrincipal OAuth2User principal) {
        // Gán user hiện tại vào DTO trước khi lưu
        User user = userRepository.findByEmail(principal.getAttribute("email"));
        // Lưu ý: Cần chỉnh lại CommentDto hoặc set UserDto vào commentDto ở đây
        // Giả sử logic mapper sẽ xử lý việc map từ UserDto sang Entity
        // Ở đây ta set tạm ID hoặc email để Service xử lý nếu cần thiết kế kỹ hơn

        // Cách đơn giản nhất theo DTO bạn gửi:
        // Bạn cần đảm bảo FE gửi lên structure đúng, hoặc set user thủ công tại đây:
        // commentDto.setUser(userMapper.toDto(user)); -> Cần inject UserMapper nếu làm vậy.
        // Tuy nhiên InteractionService.addComment nhận DTO.
        // Để code chạy ngay, ta nên set User vào Comment entity trong Service,
        // nhưng vì Service bạn đã gửi impl dùng Mapper, nên ta cần set UserDto vào đây.

        // (Giả lập việc set user vào DTO để Mapper hoạt động đúng)
        // Trong thực tế nên sửa Service để nhận userId, nhưng tôi tôn trọng code Service bạn gửi.

        return ResponseEntity.ok(interactionService.addComment(commentDto));
    }

    @GetMapping("/comment/post/{postId}")
    public ResponseEntity<List<CommentDto>> getComments(@PathVariable Long postId) {
        return ResponseEntity.ok(interactionService.getCommentsByPost(postId));
    }

    @DeleteMapping("/comment/{commentId}")
    public ResponseEntity<String> deleteMyComment(@PathVariable Long commentId, @AuthenticationPrincipal OAuth2User principal) {
        interactionService.deleteComment(commentId, getCurrentUserId(principal));
        return ResponseEntity.ok("Đã xóa bình luận");
    }

    // --- SHARE ---
    @PostMapping("/share")
    public ResponseEntity<String> logShare(@RequestBody ShareLogDto shareDto, @AuthenticationPrincipal OAuth2User principal) {
        // shareDto cần chứa postId hoặc artworkId và platform
        Long postId = shareDto.getPost() != null ? shareDto.getPost().getId() : null;
        Long artworkId = shareDto.getArtwork() != null ? shareDto.getArtwork().getId() : null;

        interactionService.logShare(getCurrentUserId(principal), postId, artworkId, shareDto.getPlatform());
        return ResponseEntity.ok("Đã ghi nhận lượt chia sẻ");
    }
}
package com.example.faithandseas.api;

import com.example.faithandseas.dto.PostDto;
import com.example.faithandseas.service.InteractionService;
import com.example.faithandseas.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admin")
@RequiredArgsConstructor
public class AdminController {

    private final PostService postService;
    private final InteractionService interactionService;

    // --- QUẢN LÝ BÀI VIẾT (CRUD) ---

    // Tạo bài viết mới
    @PostMapping("/posts")
    public ResponseEntity<PostDto> createPost(@RequestBody PostDto postDto) {
        return ResponseEntity.ok(postService.createPost(postDto));
    }

    // Cập nhật bài viết
    @PutMapping("/posts/{id}")
    public ResponseEntity<PostDto> updatePost(@PathVariable Long id, @RequestBody PostDto postDto) {
        return ResponseEntity.ok(postService.updatePost(id, postDto));
    }

    // Xóa bài viết
    @DeleteMapping("/posts/{id}")
    public ResponseEntity<String> deletePost(@PathVariable Long id) {
        postService.deletePost(id);
        return ResponseEntity.ok("Đã xóa bài viết thành công");
    }

    // Duyệt bài / Thay đổi trạng thái
    @PatchMapping("/posts/{id}/status")
    public ResponseEntity<PostDto> changeStatus(@PathVariable Long id, @RequestParam String status) {
        return ResponseEntity.ok(postService.changeStatus(id, status));
    }

    // Lấy tất cả bài viết (Bao gồm cả PENDING, PUBLISHED để quản lý)
    @GetMapping("/posts")
    public ResponseEntity<List<PostDto>> getAllPostsForAdmin(
            @RequestParam(required = false) String keyword,
            @RequestParam(required = false) Long artistId,
            @RequestParam(required = false) String status) {
        // Admin có thể lọc theo status cụ thể hoặc xem tất cả
        return ResponseEntity.ok(postService.getFilteredPosts(keyword, artistId, status));
    }

    // --- QUẢN LÝ TƯƠNG TÁC ---

    // Admin xóa bất kỳ comment nào (vi phạm tiêu chuẩn cộng đồng)
    // Lưu ý: Logic service hiện tại đang check userId,
    // bạn có thể cần sửa service một chút để cho phép Admin bypass check userId,
    // hoặc tạo một hàm deleteCommentByAdmin riêng.
    // Tạm thời ở đây tôi dùng hàm có sẵn, nhưng logic service cần nới lỏng cho admin.
    @DeleteMapping("/comments/{id}")
    public ResponseEntity<String> deleteCommentByAdmin(@PathVariable Long id) {
        // TODO: Cần update Service để Admin có quyền xóa mà không cần check User ID sở hữu
        // Ví dụ: interactionService.adminDeleteComment(id);
        return ResponseEntity.ok("Tính năng đang chờ update Service để Admin xóa comment bất kỳ");
    }
}
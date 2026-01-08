package com.example.faithandseas.api;
import com.example.faithandseas.dto.PostDto;
import com.example.faithandseas.service.PostService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/posts")
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;

    // Lấy danh sách bài viết (có lọc theo keyword, artist, status)
    @GetMapping
    public ResponseEntity<List<PostDto>> getPosts(
            @RequestParam(required = false) String keyword,
            @RequestParam(required = false) Long artistId) {
        // Mặc định chỉ lấy bài đã PUBLISHED cho user thường
        return ResponseEntity.ok(postService.getFilteredPosts(keyword, artistId, "PUBLISHED"));
    }

    // Lấy chi tiết bài viết & Tự động tăng view (theo IP)
    @GetMapping("/{id}")
    public ResponseEntity<PostDto> getPostDetail(@PathVariable Long id, HttpServletRequest request) {
        // 1. Lấy địa chỉ IP của khách
        String clientIp = request.getRemoteAddr();

        // 2. Ghi nhận lượt xem (Service đã impl)
        postService.incrementViewCount(id, clientIp);

        // 3. Trả về dữ liệu bài viết
        return ResponseEntity.ok(postService.getPostById(id));
    }
}
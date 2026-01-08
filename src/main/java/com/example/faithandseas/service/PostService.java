package com.example.faithandseas.service;


import com.example.faithandseas.dto.PostDto;
import java.util.List;

public interface PostService {
    // Cho Người dùng

    List<PostDto> getFilteredPosts(String keyword, Long artistId, String status);
    // Xem chi tiết một bài viết/tác phẩm
    PostDto getPostById(Long id);

    // Ghi nhận lượt xem (gọi mỗi khi khách click vào xem tranh)
    void incrementViewCount(Long postId, String ipAddress);
    // Cho Admin (Duyệt, Xóa, Sửa)
    PostDto createPost(PostDto postDto);
    PostDto updatePost(Long id, PostDto postDto);
    void deletePost(Long id);
    PostDto changeStatus(Long id, String status); // Duyệt bài: PENDING -> PUBLISHED
}

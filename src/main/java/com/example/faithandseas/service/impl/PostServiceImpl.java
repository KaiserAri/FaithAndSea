package com.example.faithandseas.service.impl;

import com.example.faithandseas.dto.PostDto;
import com.example.faithandseas.entity.Post;
import com.example.faithandseas.entity.ViewLog;
import com.example.faithandseas.mapper.PostMapper;
import com.example.faithandseas.repo.PostRepository;
import com.example.faithandseas.repo.ViewLogRepository;
import com.example.faithandseas.service.PostService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostService {
    private final ViewLogRepository viewLogRepository;
    private final PostRepository postRepository;
    private final PostMapper postMapper;

    // 1. Lấy danh sách có lọc (Không cần Transactional vì chỉ đọc)
    @Override
    public List<PostDto> getFilteredPosts(String keyword, Long artistId, String status) {
        return postRepository.filterAdvanced(keyword, artistId, status)
                .stream()
                .map(postMapper::toDto)
                .collect(Collectors.toList());
    }

    // 2. Lấy chi tiết bài viết (Không cần Transactional)
    @Override
    public PostDto getPostById(Long id) {
        Post post = postRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Không tìm thấy bài viết: " + id));
        return postMapper.toDto(post);
    }

    // 3. Tạo bài viết mới (CẦN Transactional)
    @Override
    @Transactional
    public PostDto createPost(PostDto postDto) {
        Post post = postMapper.toEntity(postDto);
        post.setStatus("PENDING"); // Mặc định chờ duyệt
        return postMapper.toDto(postRepository.save(post));
    }

    // 4. Cập nhật bài viết (CẦN Transactional)
    @Override
    @Transactional
    public PostDto updatePost(Long id, PostDto postDto) {
        Post existingPost = postRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Không tìm thấy bài viết để cập nhật"));

        existingPost.setTitle(postDto.getTitle());
        existingPost.setContent(postDto.getContent());
        existingPost.setThumbnailUrl(postDto.getThumbnailUrl());

        return postMapper.toDto(postRepository.save(existingPost));
    }

    // 5. Xóa bài viết (CẦN Transactional)
    @Override
    @Transactional
    public void deletePost(Long id) {
        if (!postRepository.existsById(id)) {
            throw new RuntimeException("Bài viết không tồn tại để xóa");
        }
        postRepository.deleteById(id);
    }

    // 6. Duyệt bài viết / Đổi trạng thái (CẦN Transactional)
    @Override
    @Transactional
    public PostDto changeStatus(Long id, String status) {
        Post post = postRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Không tìm thấy bài viết để đổi trạng thái"));
        post.setStatus(status);
        return postMapper.toDto(postRepository.save(post));
    }

    // 7. Ghi log lượt xem (CẦN Transactional)
    @Override
    @Transactional
    public void incrementViewCount(Long postId, String ipAddress) {
        Post post = postRepository.findById(postId)
                .orElseThrow(() -> new RuntimeException("Bài viết không tồn tại để ghi log"));

        ViewLog viewLog = ViewLog.builder()
                .post(post)
                .ipAddress(ipAddress)
                .build();

        viewLogRepository.save(viewLog);
    }
}
package com.example.faithandseas.service.impl;

import com.example.faithandseas.dto.CommentDto;
import com.example.faithandseas.entity.*;
import com.example.faithandseas.mapper.CommentMapper;
import com.example.faithandseas.repo.CommentRepository;
import com.example.faithandseas.repo.LikeRepository;
import com.example.faithandseas.repo.ShareLogRepository;
import com.example.faithandseas.service.InteractionService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class InteractionServiceImpl implements InteractionService {

    private final LikeRepository likeRepository;
    private final CommentRepository commentRepository;
    private final ShareLogRepository shareLogRepository;
    private final CommentMapper commentMapper;

    @Override
    @Transactional
    public void toggleLikePost(Long userId, Long postId) {
        if (likeRepository.existsByUserIdAndPostId(userId, postId)) {
            likeRepository.deleteByUserIdAndPostId(userId, postId);
        } else {
            Like like = Like.builder()
                    .user(User.builder().id(userId).build())
                    .post(Post.builder().id(postId).build())
                    .build();
            likeRepository.save(like);
        }
    }



    @Override
    public CommentDto addComment(CommentDto commentDto) {
        Comment comment = commentMapper.toEntity(commentDto);
        Comment savedComment = commentRepository.save(comment);
        return commentMapper.toDto(savedComment);
    }

    @Override
    @Transactional
    public void deleteComment(Long commentId, Long userId) {
        // 1. Tìm comment, nếu không có thì báo lỗi
        Comment comment = commentRepository.findById(commentId)
                .orElseThrow(() -> new RuntimeException("Không tìm thấy bình luận này."));

        // 2. Kiểm tra quyền: Chỉ người tạo bình luận mới được xóa
        // (Lưu ý: Nếu có phân quyền Admin, bạn có thể bổ sung check Role ở đây)
        if (!comment.getUser().getId().equals(userId)) {
            throw new RuntimeException("Bạn không có quyền xóa bình luận của người khác.");
        }

        // 3. Thực hiện xóa
        commentRepository.delete(comment);
    }

    @Override
    @Transactional
    public void toggleLikeArtwork(Long userId, Long artworkId) {
        // Kiểm tra xem user đã like tác phẩm này chưa
        // Bạn cần bổ sung phương thức: existsByUserIdAndArtworkId trong LikeRepository
        if (likeRepository.existsByUserIdAndPostId(userId, artworkId)) {
            // Nếu đã like rồi thì thực hiện Unlike
            likeRepository.deleteByUserIdAndPostId(userId, artworkId);
        } else {
            // Nếu chưa like thì tạo bản ghi Like mới
            Like like = Like.builder()
                    .user(User.builder().id(userId).build())
                    .artwork(Artwork.builder().id(artworkId).build())
                    .build();
            likeRepository.save(like);
        }
    }

    @Override
    public List<CommentDto> getCommentsByPost(Long postId) {
        // Lấy danh sách comment theo bài viết và chuyển sang DTO
        return commentRepository.findByPostId(postId)
                .stream()
                .map(commentMapper::toDto)
                .collect(Collectors.toList());
    }
    @Override
    public void logShare(Long userId, Long postId, Long artworkId, String platform) {
        ShareLog log = ShareLog.builder()
                .user(userId != null ? User.builder().id(userId).build() : null)
                .post(postId != null ? Post.builder().id(postId).build() : null)
                .artwork(artworkId != null ? Artwork.builder().id(artworkId).build() : null)
                .platform(platform)
                .build();
        shareLogRepository.save(log);
    }
}
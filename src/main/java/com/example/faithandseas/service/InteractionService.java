package com.example.faithandseas.service;

import com.example.faithandseas.dto.CommentDto;

import java.util.List;

public interface InteractionService {
    // Chức năng Like
    void toggleLikePost(Long userId, Long postId);
    void toggleLikeArtwork(Long userId, Long artworkId);

    // Chức năng Comment
    CommentDto addComment(CommentDto commentDto);
    List<CommentDto> getCommentsByPost(Long postId);
    void deleteComment(Long commentId, Long userId); // Chỉ người viết hoặc admin mới được xóa

    // Chức năng Share
    void logShare(Long userId, Long postId, Long artworkId, String platform);
}
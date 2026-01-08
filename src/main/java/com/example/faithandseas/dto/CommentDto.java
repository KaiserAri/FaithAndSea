package com.example.faithandseas.dto;

import lombok.*;

import java.time.LocalDateTime;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CommentDto {
    private Long id;
    private UserDto user;
    private PostDto post;
    private ArtworkDto artwork;
    private String content;
    private LocalDateTime createdAt;
}

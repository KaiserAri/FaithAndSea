package com.example.faithandseas.dto;

import lombok.*;

import java.time.LocalDateTime;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LikeDto {
    private Long id;
    private UserDto user;
    private PostDto post;
    private ArtworkDto artwork;
    private LocalDateTime createdAt;
}

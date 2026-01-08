package com.example.faithandseas.dto;

import lombok.*;

import java.time.LocalDateTime;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ArtworkDto {
    private Long id;
    private String title;
    private String description;
    private String imageUrl;
    private ArtistDto artist;
    private LocalDateTime createdAt;
    private Integer viewCount = 0;
}

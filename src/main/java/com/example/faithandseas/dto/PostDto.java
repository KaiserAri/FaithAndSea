package com.example.faithandseas.dto;


import lombok.*;


import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PostDto {
    private Long id;
    private String title;
    private String content;
    private String thumbnailUrl;
    private ArtistDto artist;
    private UserDto creator;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private Integer viewCount = 0;
    private String status = "PUBLISHED";
}

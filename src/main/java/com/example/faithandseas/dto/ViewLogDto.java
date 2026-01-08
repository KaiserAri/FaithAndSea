package com.example.faithandseas.dto;
import lombok.*;
import java.time.LocalDateTime;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ViewLogDto {
    private Long id;
    private PostDto post;
    private ArtworkDto artwork;
    private String ipAddress;

    private LocalDateTime viewedAt;
}

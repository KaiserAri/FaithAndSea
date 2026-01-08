package com.example.faithandseas.dto;

import lombok.*;

import java.time.LocalDateTime;
import java.util.List;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ArtistDto {
    private Long id;
    private String name;
    private String bio;
    private String avatarUrl;
    private LocalDateTime createdAt;
    private List<ArtworkDto> artworks;
}

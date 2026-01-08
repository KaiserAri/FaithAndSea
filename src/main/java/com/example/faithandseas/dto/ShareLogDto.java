package com.example.faithandseas.dto;


import lombok.*;

import java.time.LocalDateTime;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ShareLogDto {
    private Long id;
    private UserDto user;
    private PostDto post;
    private ArtworkDto artwork;
    private String platform;
    private LocalDateTime sharedAt;
}

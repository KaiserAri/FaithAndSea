package com.example.faithandseas.dto;


import lombok.*;

import java.time.LocalDateTime;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AdminLogDto {
    private Long id;
    private UserDto admin;
    private String action;
    private Long targetId;
    private LocalDateTime createdAt;
}

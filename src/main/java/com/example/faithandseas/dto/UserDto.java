package com.example.faithandseas.dto;

import lombok.*;

import java.time.LocalDateTime;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserDto {
    private Long id;
    private String email;
    private String fullName;
    private String avatarUrl;
    private String provider = "GOOGLE";
    private String role = "USER";
    private LocalDateTime createdAt;
}

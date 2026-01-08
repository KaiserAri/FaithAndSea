package com.example.faithandseas.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(auth -> auth
                        // 1. Khách được phép xem danh sách và chi tiết bài viết
                        .requestMatchers(org.springframework.http.HttpMethod.GET, "/api/posts/**").permitAll()

                        // 2. Các đường dẫn hệ thống và đăng nhập
                        .requestMatchers("/", "/login/**", "/oauth2/**").permitAll()

                        // 3. Chỉ Admin mới được vào luồng quản trị
                        .requestMatchers("/api/admin/**").hasRole("ADMIN")

                        // 4. Các thao tác Like, Comment, Đăng bài (POST, PUT, DELETE) phải đăng nhập
                        .anyRequest().authenticated()
                )
                .oauth2Login(oauth2 -> oauth2
                        .loginPage("/login") // Trang login tùy chỉnh nếu có
                        .defaultSuccessUrl("/api/auth/success", true)
                );

        return http.build();
    }
}
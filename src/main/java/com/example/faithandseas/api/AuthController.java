package com.example.faithandseas.api;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @GetMapping("/success")
    public String loginSuccess(@AuthenticationPrincipal OAuth2User principal) {
        // Đây là nơi bạn lấy Email và Tên từ Google
        String email = principal.getAttribute("email");
        String name = principal.getAttribute("name");

        // Bạn có thể gọi UserService.saveOrUpdate(email, name) tại đây
        return "Chào mừng " + name + " đã đăng nhập thành công vào FaithAndSeas!";
    }
}
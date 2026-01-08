package com.example.faithandseas.service.impl;

import com.example.faithandseas.entity.User;
import com.example.faithandseas.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

@Service
public class CustomOAuth2UserService extends DefaultOAuth2UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {
        OAuth2User oAuth2User = super.loadUser(userRequest);
        String email = oAuth2User.getAttribute("email");

        // Logic: Tìm user theo email, nếu ko thấy thì tạo mới
        User user = userRepository.findByEmail(email);
        if (user == null) {
            user = User.builder()
                    .email(email)
                    .fullName(oAuth2User.getAttribute("name"))
                    .avatarUrl(oAuth2User.getAttribute("picture"))
                    .role("USER")
                    .provider("GOOGLE")
                    .build();
            userRepository.save(user);
        }
        return oAuth2User;
    }
}

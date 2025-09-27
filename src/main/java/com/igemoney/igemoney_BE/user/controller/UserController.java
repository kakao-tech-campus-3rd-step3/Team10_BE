package com.igemoney.igemoney_BE.user.controller;


import com.igemoney.igemoney_BE.user.dto.CreateUserRequest;
import com.igemoney.igemoney_BE.user.dto.LoginRequest;
import com.igemoney.igemoney_BE.user.dto.LoginResponse;
import com.igemoney.igemoney_BE.user.service.impl.KakaoServiceImpl;
import com.igemoney.igemoney_BE.user.service.UserService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequiredArgsConstructor
@RequestMapping("/api/user")
@Tag(name = "User", description = "사용자 로그인 관련 API")
public class UserController {

    private final UserService userService;
    private final KakaoServiceImpl kakaoService;

    @PostMapping("/register")
    public LoginResponse register(@RequestBody CreateUserRequest req) {
        return userService.register(req);
    }

    @PostMapping("/login")
    public LoginResponse login(@RequestBody LoginRequest req) {
        return userService.login(req);
    }

}

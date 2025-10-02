package com.igemoney.igemoney_BE.user.controller;


import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/users")
@Tag(name = "User Metadata", description = "유저 정보를 얻는 API")
public class UserStatusController {

}

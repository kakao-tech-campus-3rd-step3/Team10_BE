package com.igemoney.igemoney_BE.user.controller;


import com.igemoney.igemoney_BE.common.annotation.Authenticated;
import com.igemoney.igemoney_BE.user.dto.TodayAttendanceResponse;
import com.igemoney.igemoney_BE.user.service.UserStatusService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/users")
@Tag(name = "User Metadata", description = "유저 정보를 얻는 API")
public class UserStatusController {

    private final UserStatusService userStatusService;


    @Authenticated
    @GetMapping("/me/attendance")
    public TodayAttendanceResponse getTodayAttendance(@RequestAttribute Long userId) {
        return userStatusService.getTodayAttendance(userId);
    }
}

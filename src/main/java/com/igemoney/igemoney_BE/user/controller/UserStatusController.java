package com.igemoney.igemoney_BE.user.controller;


import com.igemoney.igemoney_BE.common.annotation.Authenticated;
import com.igemoney.igemoney_BE.user.dto.GetConsecutiveAttendanceResponse;
import com.igemoney.igemoney_BE.user.dto.GetMyRankingResponse;
import com.igemoney.igemoney_BE.user.dto.GetUserNicknameResponse;
import com.igemoney.igemoney_BE.user.dto.TodayAttendanceResponse;
import com.igemoney.igemoney_BE.user.service.UserStatusService;
import io.swagger.v3.oas.annotations.Operation;
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
    @Operation(summary = "내 금일 출석 여부 조회")
    @GetMapping("/me/attendance")
    public TodayAttendanceResponse getTodayAttendance(@RequestAttribute Long userId) {
        return userStatusService.getTodayAttendance(userId);
    }

    @Authenticated
    @Operation(summary = "내 닉네임 조회")
    @GetMapping("/me/nickname")
    public GetUserNicknameResponse getUserNickname(@RequestAttribute Long userId) {
        return userStatusService.getUserNickName(userId);
    }

    @Authenticated
    @Operation(summary = "내 연속 출석일 조회")
    @GetMapping("/me/consecutive-attendance")
    public GetConsecutiveAttendanceResponse getConsecutiveAttendance(
        @RequestAttribute Long userId) {
        return userStatusService.getConsecutiveAttendance(userId);
    }

    @Authenticated
    @Operation(summary = "내 티어 조회")
    @GetMapping("/me/tier")
    public GetMyRankingResponse getMyRanking(@RequestAttribute Long userId) {
        return userStatusService.getMyRanking(userId);
    }

}

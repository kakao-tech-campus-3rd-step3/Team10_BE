package com.igemoney.igemoney_BE.user.controller;

import com.igemoney.igemoney_BE.common.annotation.Authenticated;
import com.igemoney.igemoney_BE.user.dto.RankingResponseDto;
import com.igemoney.igemoney_BE.user.service.UserRankingService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/user/ranking")
@Tag(name = "User Ranking", description = "유저 랭킹을 조회하는 API")
public class UserRankingController {
    private final UserRankingService userRankingService;

    @Authenticated
    @Operation(summary = "문제 풀이 점수 랭킹 조회(상위 유저 및 현재 유저 주변 순위)")
    @GetMapping("/ratingPoint")
    public RankingResponseDto getRatingPointRanking(@RequestAttribute Long userId) {
        return userRankingService.getRatingPointRanking(userId);
    }

    @Authenticated
    @Operation(summary = "연속 출석일 랭킹 조회(상위 유저 및 현재 유저 주변 순위)")
    @GetMapping("/consecutiveAttendance")
    public RankingResponseDto getConsecutiveAttendanceRanking(@RequestAttribute Long userId) {
        return userRankingService.getConsecutiveAttendanceRanking(userId);
    }
}

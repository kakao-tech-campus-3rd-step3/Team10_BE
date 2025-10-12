package com.igemoney.igemoney_BE.user.controller;

import com.igemoney.igemoney_BE.common.annotation.Authenticated;
import com.igemoney.igemoney_BE.user.dto.RankingResponseDto;
import com.igemoney.igemoney_BE.user.service.UserRankingService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/user/ranking")
public class UserRankingController {
    private final UserRankingService userRankingService;

    @Authenticated
    @GetMapping("/ratingPoint")
    public RankingResponseDto getRatingPointRanking(@RequestAttribute Long userId) {
        return userRankingService.getRatingPointRanking(userId);
    }
}

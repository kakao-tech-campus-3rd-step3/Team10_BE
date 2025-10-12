package com.igemoney.igemoney_BE.user.dto;

import java.util.List;

public record RankingResponseDto(
        UserRankingDto currentUser,                 // 현재 로그인 유저 정보
        List<UserRankingDto> topRankingUsers,       // 상위 3명
        List<UserRankingDto> adjacentUsers          // 현재 유저 기준 앞뒤 2명
){}



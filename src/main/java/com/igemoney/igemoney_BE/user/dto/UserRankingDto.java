package com.igemoney.igemoney_BE.user.dto;

public record UserRankingDto(
        String nickname,
        Integer point,
        Long rank
){}

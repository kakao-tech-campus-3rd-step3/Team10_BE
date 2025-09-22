package com.igemoney.igemoney_BE.user.dto;


import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public record GetKakaoUserInfoResponse(
    Long id,
    KakaoAccount kakaoAccount
) {
    public record KakaoAccount(
        KakaoUserProfile profile
    ) {
        public record KakaoUserProfile(
            String nickname,
            String profileImageUrl
        ) {
        }
    }
}

package com.igemoney.igemoney_BE.user.dto;


import com.fasterxml.jackson.annotation.JsonProperty;

public record GetKakaoUserInfoResponse(
    Long id,
    @JsonProperty("kakao_account")
    KakaoAccount kakaoAccount
) {
    public record KakaoAccount(
        KakaoUserProfile profile
    ) {
        public record KakaoUserProfile(
            String nickname,
            @JsonProperty("profile_image_url")
            String profileImageUrl
        ) {
        }
    }
}

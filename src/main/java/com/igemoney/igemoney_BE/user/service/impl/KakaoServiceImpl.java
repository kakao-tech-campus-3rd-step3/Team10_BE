package com.igemoney.igemoney_BE.user.service.impl;

import com.igemoney.igemoney_BE.user.dto.GetKakaoTokenApiResponse;
import com.igemoney.igemoney_BE.user.dto.GetKakaoUserInfoResponse;
import com.igemoney.igemoney_BE.user.service.OAuthProvider;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;


@Service
public class KakaoServiceImpl implements
    OAuthProvider<GetKakaoTokenApiResponse, GetKakaoUserInfoResponse> {

    @Value("${kakao.client-id}")
    private String clientId;
    @Value("${kakao.redirect-uri}")
    private String redirectUri;


    public GetKakaoTokenApiResponse getProviderAccessToken(String code) {
        RestClient restClient = RestClient.builder()
                .baseUrl("https://kauth.kakao.com/oauth/token")
                .build();

        return restClient.post()
            .uri(uriBuilder -> uriBuilder
                .queryParam("grant_type", "authorization_code")
                .queryParam("client_id", clientId)
                .queryParam("redirectUri", redirectUri)
                .queryParam("code", code)
                .build()
            )
            .header("Content-Type", "application/x-www-form-urlencoded;charset=utf-8")
            .retrieve()
            .body(GetKakaoTokenApiResponse.class);
    }



    public GetKakaoUserInfoResponse getProviderUserInfo(String accessToken) {
        RestClient restClient = RestClient.builder()
            .baseUrl("https://kapi.kakao.com/v2/user/me")
            .build();

        GetKakaoUserInfoResponse response = restClient.post()
            .header("Authorization", "Bearer " + accessToken)
            .header("Content-Type", "application/x-www-form-urlencoded;charset=utf-8")
            .retrieve()
            .body(GetKakaoUserInfoResponse.class);

        return response;
    }

}

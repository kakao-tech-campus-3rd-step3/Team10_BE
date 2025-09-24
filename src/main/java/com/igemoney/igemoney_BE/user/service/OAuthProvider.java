package com.igemoney.igemoney_BE.user.service;

import com.igemoney.igemoney_BE.user.dto.OAuthTokenResponse;
import com.igemoney.igemoney_BE.user.dto.OAuthUserInfoResponse;

public interface OAuthProvider {
    OAuthTokenResponse getProviderAccessToken(String authorizationCode);
    OAuthUserInfoResponse getProviderUserInfo(String accessToken);
}

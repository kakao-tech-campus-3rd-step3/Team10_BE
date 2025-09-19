package com.igemoney.igemoney_BE.user.service;

public interface OAuthProvider<T, I> {
    T getProviderAccessToken(String authorizationCode);
    I getProviderUserInfo(String accessToken);
}

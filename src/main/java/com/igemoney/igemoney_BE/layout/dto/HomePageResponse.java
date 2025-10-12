package com.igemoney.igemoney_BE.layout.dto;

public record HomePageResponse(
    String characterUri,
    String nickname,
    String tierName,
    String testResult
) {

    public static HomePageResponse of(String characterUri, String nickname, String tierName, String testResult) {
        return new HomePageResponse(characterUri, nickname, tierName, testResult);
    }
}

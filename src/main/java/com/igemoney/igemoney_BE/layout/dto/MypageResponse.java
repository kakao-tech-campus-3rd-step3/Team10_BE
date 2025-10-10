package com.igemoney.igemoney_BE.layout.dto;

import lombok.Builder;

@Builder
public record MypageResponse(
    String characterUri,
    String nickname,
    String tierName,
    Integer ratingPoint,
    String testResult,
    String testResultDescription
) {
}

package com.igemoney.igemoney_BE.propensity.dto;

import com.igemoney.igemoney_BE.propensity.InvestmentPropensity;

public record InvestmentPropensityResponseDto(
        InvestmentPropensity propensity,
        String propensityKoreanName,
        Integer totalScore
) {
    public InvestmentPropensityResponseDto (InvestmentPropensity propensity, Integer totalScore) {
        this(
                propensity,
                propensity.getPropensity(),
                totalScore
        );
    }
}

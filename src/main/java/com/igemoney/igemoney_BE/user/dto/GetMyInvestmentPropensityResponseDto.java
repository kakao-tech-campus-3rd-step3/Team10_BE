package com.igemoney.igemoney_BE.user.dto;

import com.igemoney.igemoney_BE.propensity.type.InvestmentPropensity;

public record GetMyInvestmentPropensityResponseDto(
        InvestmentPropensity propensity,
        String propensityKoreanName,
        boolean isTested
) {
    public GetMyInvestmentPropensityResponseDto(InvestmentPropensity propensity) {
        this(
                propensity,
                propensity.getLabel(),
                propensity.isDiagnosed()
        );
    }
}

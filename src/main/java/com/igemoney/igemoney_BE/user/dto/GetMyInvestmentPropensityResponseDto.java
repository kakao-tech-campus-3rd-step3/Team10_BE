package com.igemoney.igemoney_BE.user.dto;

import com.igemoney.igemoney_BE.propensity.type.InvestmentPropensity;

public record GetMyInvestmentPropensityResponseDto(
        InvestmentPropensity propensity,
        String propensityKoreanName
) {}

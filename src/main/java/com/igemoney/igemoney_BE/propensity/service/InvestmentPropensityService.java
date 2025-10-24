package com.igemoney.igemoney_BE.propensity.service;

import com.igemoney.igemoney_BE.propensity.type.InvestmentPropensity;
import com.igemoney.igemoney_BE.propensity.dto.InvestmentPropensityRequestDto;
import com.igemoney.igemoney_BE.propensity.dto.InvestmentPropensityResponseDto;
import com.igemoney.igemoney_BE.user.entity.User;
import com.igemoney.igemoney_BE.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class InvestmentPropensityService {
    private final UserRepository userRepository;

    private static final int DEFENSIVE_MAX = 20;
    private static final int CONSERVATIVE_MAX = 40;
    private static final int BALANCED_MAX = 60;
    private static final int ACTIVE_MAX = 80;

    @Transactional
    public InvestmentPropensityResponseDto diagnoseInvestmentPropensity(Long userId, InvestmentPropensityRequestDto request) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("User not found"));

        InvestmentPropensity propensity = InvestmentPropensity.fromScore(request.totalScore());
        user.updateInvestmentPropensity(propensity);

        return new InvestmentPropensityResponseDto(propensity, request.totalScore());
    }
}

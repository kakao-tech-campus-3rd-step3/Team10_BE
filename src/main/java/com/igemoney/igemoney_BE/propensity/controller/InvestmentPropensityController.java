package com.igemoney.igemoney_BE.propensity.controller;

import com.igemoney.igemoney_BE.common.annotation.Authenticated;
import com.igemoney.igemoney_BE.propensity.dto.InvestmentPropensityRequestDto;
import com.igemoney.igemoney_BE.propensity.dto.InvestmentPropensityResponseDto;
import com.igemoney.igemoney_BE.propensity.service.InvestmentPropensityService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/propensity")
@RequiredArgsConstructor
public class InvestmentPropensityController {

    private final InvestmentPropensityService investmentPropensityService;

    @Authenticated
    @PutMapping("/diagnose")
    public ResponseEntity<InvestmentPropensityResponseDto> diagnoseInvestmentPropensity(
            @RequestBody InvestmentPropensityRequestDto request,
            @RequestAttribute Long userId) {
        InvestmentPropensityResponseDto response = investmentPropensityService.diagnoseInvestmentPropensity(userId, request);
        return ResponseEntity.ok(response);
    }
}

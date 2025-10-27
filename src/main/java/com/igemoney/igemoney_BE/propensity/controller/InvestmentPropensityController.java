package com.igemoney.igemoney_BE.propensity.controller;

import com.igemoney.igemoney_BE.common.annotation.Authenticated;
import com.igemoney.igemoney_BE.propensity.dto.InvestmentPropensityRequestDto;
import com.igemoney.igemoney_BE.propensity.dto.InvestmentPropensityResponseDto;
import com.igemoney.igemoney_BE.propensity.service.InvestmentPropensityService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/propensity")
@RequiredArgsConstructor
@Tag(name = "User Propensity", description = "유저 투자성향을 진단하는 API")
public class InvestmentPropensityController {

    private final InvestmentPropensityService investmentPropensityService;

    @Authenticated
    @Operation(summary = "투자성향 진단 등급 결과 측정")
    @PostMapping("/diagnose")
    public ResponseEntity<InvestmentPropensityResponseDto> diagnoseInvestmentPropensity(
            @RequestBody InvestmentPropensityRequestDto request,
            @RequestAttribute Long userId) {
        InvestmentPropensityResponseDto response = investmentPropensityService.diagnoseInvestmentPropensity(userId, request);
        return ResponseEntity.ok(response);
    }
}

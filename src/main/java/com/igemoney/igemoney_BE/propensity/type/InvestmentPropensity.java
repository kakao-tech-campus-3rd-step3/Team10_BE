package com.igemoney.igemoney_BE.propensity.type;

import lombok.Getter;

import java.util.Arrays;

@Getter
public enum InvestmentPropensity {
    DEFENSIVE("안정형", 0, 20),
    CONSERVATIVE("안정추구형", 21, 40),
    BALANCED("위험중립형", 41, 60),
    ACTIVE("적극투자형", 61, 80),
    AGGRESSIVE("공격투자형", 81, 200),
    UNDIAGNOSED("진단미확정", null, null);

    private final String label;
    private final Integer minScore;
    private final Integer maxScore;

    InvestmentPropensity(String label, Integer minScore, Integer maxScore) {
        this.label = label;
        this.minScore = minScore;
        this.maxScore = maxScore;
    }

    public static InvestmentPropensity fromScore(int score) {
        return Arrays.stream(values())
                .filter(p -> p.minScore != null && p.maxScore != null)
                .filter(p -> score >= p.minScore && score <= p.maxScore)
                .findFirst()
                .orElse(UNDIAGNOSED);
    }

    public boolean isDiagnosed() {
        return this != UNDIAGNOSED;
    }
}

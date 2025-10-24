package com.igemoney.igemoney_BE.propensity.type;

import lombok.Getter;

@Getter
public enum InvestmentPropensity {
    AGGRESSIVE("공격투자형"),
    ACTIVE("적극투자형"),
    BALANCED("위험중립형"),
    CONSERVATIVE("안정추구형"),
    DEFENSIVE("안정형"),
    UNDIAGNOSED("진단미확정");

    private final String description;

    InvestmentPropensity(String description) {
        this.description = description;
    }
}

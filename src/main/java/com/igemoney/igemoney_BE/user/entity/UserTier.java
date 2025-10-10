package com.igemoney.igemoney_BE.user.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum UserTier {
    SEED("기초 자본", 0, 1600),
    GROWTH_INVESTOR("성장주 투자자", 1601, 3200),
    SUPERIOR_INVESTOR("우량주 투자자", 3201, 4800),
    DIVIDEND_COLLECTOR("배당주 수확자", 4801, 5400),
    POWERFUL("세력", 5401, Integer.MAX_VALUE);

    private final String name;
    private final int minRatingPoint;
    private final int maxRatingPoint;

    public static UserTier fromRatingPoint(int ratingPoint) {
        for (UserTier userTier : values()) {
            if (ratingPoint >= userTier.getMinRatingPoint() && ratingPoint <= userTier.getMaxRatingPoint()) {
                return userTier;
            }
        }
        throw new IllegalArgumentException(ratingPoint + "는 잘못된 레이팅 포인트입니다.");
    }
}

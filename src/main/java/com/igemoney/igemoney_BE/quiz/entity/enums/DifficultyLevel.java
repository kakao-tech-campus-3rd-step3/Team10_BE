package com.igemoney.igemoney_BE.quiz.entity.enums;


import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum DifficultyLevel {
    EASY(100),
    MEDIUM(200),
    HARD(300);

    private final int score;

    public static int getScore(DifficultyLevel difficultyLevel) {
        return switch (difficultyLevel) {
            case EASY -> 100;
            case MEDIUM -> 200;
            case HARD -> 300;
        };
    }
}

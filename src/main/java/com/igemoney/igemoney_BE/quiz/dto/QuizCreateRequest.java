package com.igemoney.igemoney_BE.quiz.dto;

import java.math.BigDecimal;

public record QuizCreateRequest(
        String questionTitle,
        String questionType,
        String questionData,
        String difficultyLevel,
        String explanation,
        Integer questionOrder,
        BigDecimal correctRate,
        Long topicId
) {}
package com.igemoney.igemoney_BE.quiz.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record QuizResponse(
        Long quizId,
        String questionTitle,
        String questionType,
        String questionData,
        String difficultyLevel,
        String explanation,
        Integer questionOrder,
        BigDecimal correctRate,

        Long topicId,
        String topicName,

        LocalDateTime createdAt,
        LocalDateTime updatedAt
) {}
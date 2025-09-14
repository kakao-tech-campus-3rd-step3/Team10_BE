package com.igemoney.igemoney_BE.quiz.dto;

import com.igemoney.igemoney_BE.quiz.entity.Quiz;

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
) {
    public static QuizResponse from(Quiz quiz) {
        return new QuizResponse(
                quiz.getId(),
                quiz.getQuestionTitle(),
                quiz.getQuestionType().name(),
                quiz.getQuestionData(),
                quiz.getDifficultyLevel().name(),
                quiz.getExplanation(),
                quiz.getQuestionOrder(),
                quiz.getCorrectRate(),
                quiz.getTopic().getId(),
                quiz.getTopic().getName(),
                quiz.getCreatedAt(),
                quiz.getUpdatedAt()
        );
    }
}

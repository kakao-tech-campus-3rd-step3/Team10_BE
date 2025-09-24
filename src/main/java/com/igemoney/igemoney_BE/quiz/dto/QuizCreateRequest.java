package com.igemoney.igemoney_BE.quiz.dto;

import com.fasterxml.jackson.databind.JsonNode;
import com.igemoney.igemoney_BE.quiz.entity.Quiz;
import com.igemoney.igemoney_BE.topic.entity.QuizTopic;
import com.igemoney.igemoney_BE.quiz.entity.enums.DifficultyLevel;
import com.igemoney.igemoney_BE.quiz.entity.enums.QuestionType;

import java.math.BigDecimal;

public record QuizCreateRequest(
        String questionTitle,
        String questionType,
        JsonNode questionData,
        String difficultyLevel,
        String explanation,
        Integer questionOrder,
        BigDecimal correctRate,
        Long topicId
) {
    public static Quiz toEntity(QuizCreateRequest request, QuizTopic topic) {
        return Quiz.builder()
                .topic(topic)
                .questionTitle(request.questionTitle())
                .questionType(QuestionType.valueOf(request.questionType()))
                .questionData(request.questionData() != null ? request.questionData().toString() : null)
                .difficultyLevel(DifficultyLevel.valueOf(request.difficultyLevel()))
                .explanation(request.explanation())
                .questionOrder(request.questionOrder())
                .build();
    }
}
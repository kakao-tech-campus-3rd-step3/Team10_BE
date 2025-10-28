package com.igemoney.igemoney_BE.quiz.dto;

import com.fasterxml.jackson.databind.JsonNode;
import com.igemoney.igemoney_BE.quiz.entity.Quiz;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record QuizResponse(
        Long quizId,
        String questionTitle,
        String questionType,
        JsonNode questionData,
        String difficultyLevel,
        String explanation,
        Integer questionOrder,
        BigDecimal correctRate,

        Long topicId,
        String topicName,

        boolean isSolved,
        boolean isBookmarked
) {
    public static QuizResponse from(Quiz quiz, boolean isBookmarked, boolean isSolved) {
        com.fasterxml.jackson.databind.ObjectMapper mapper = new com.fasterxml.jackson.databind.ObjectMapper();
        JsonNode jsonNode = null;
        try {
            if (quiz.getQuestionData() != null) {
                jsonNode = mapper.readTree(quiz.getQuestionData()); // String → JsonNode 변환
            }
        } catch (Exception e) {
            throw new RuntimeException("Invalid JSON in DB: " + quiz.getQuestionData(), e);
        }

        return new QuizResponse(
            quiz.getId(),
            quiz.getQuestionTitle(),
            quiz.getQuestionType().name(),
            jsonNode,
            quiz.getDifficultyLevel().name(),
            quiz.getExplanation(),
            quiz.getQuestionOrder(),
            quiz.getCorrectRate(),
            quiz.getTopic().getId(),
            quiz.getTopic().getName(),
            isBookmarked,
            isSolved

        );
    }
}

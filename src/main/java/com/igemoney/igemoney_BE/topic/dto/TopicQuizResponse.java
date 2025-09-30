package com.igemoney.igemoney_BE.topic.dto;

import com.igemoney.igemoney_BE.quiz.entity.enums.DifficultyLevel;

public record TopicQuizResponse(
        Long quizId,
        int questionOrder,
        String questionTitle,
        DifficultyLevel difficultyLevel,
        boolean isSolved,
        boolean isBookMarked
) {}
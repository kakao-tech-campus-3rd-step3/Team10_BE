package com.igemoney.igemoney_BE.quiz.dto;

import com.igemoney.igemoney_BE.quiz.entity.Quiz;
import com.igemoney.igemoney_BE.quiz.entity.UserQuizAttempt;
import com.igemoney.igemoney_BE.quiz.entity.enums.DifficultyLevel;
import com.igemoney.igemoney_BE.quiz.entity.enums.QuestionType;
import com.igemoney.igemoney_BE.quiz.entity.enums.ReviewStep;
import com.igemoney.igemoney_BE.topic.entity.QuizTopic;

import java.math.BigDecimal;

public record ReviewQuizDetail(
        Long quizId,
        Long topicId,
        String questionTitle,
        QuestionType questionType,
        String questionData,
        DifficultyLevel difficultyLevel,
        String explanation,
        BigDecimal correctRate,
        ReviewStep reviewStep
) {
    public static ReviewQuizDetail from(UserQuizAttempt attempt){
        Quiz quiz = attempt.getQuiz();
        QuizTopic topic = quiz.getTopic();
        ReviewStep reviewStep = attempt.getReviewStep();

        return new ReviewQuizDetail(
                quiz.getId(),
                topic.getId(),
                quiz.getQuestionTitle(),
                quiz.getQuestionType(),
                quiz.getQuestionData(),
                quiz.getDifficultyLevel(),
                quiz.getExplanation(),
                quiz.getCorrectRate(),
                reviewStep
        );
    }
}

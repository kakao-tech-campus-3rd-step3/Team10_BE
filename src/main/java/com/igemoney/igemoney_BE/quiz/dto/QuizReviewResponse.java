package com.igemoney.igemoney_BE.quiz.dto;

import java.util.List;

public record QuizReviewResponse (
        Boolean hasReviewQuizzes,
        List<ReviewQuizDetail> reviewQuizzes
){
}


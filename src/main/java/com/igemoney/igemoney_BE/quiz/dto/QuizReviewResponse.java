package com.igemoney.igemoney_BE.quiz.dto;

import java.util.List;

public record QuizReviewResponse (
        List<ReviewQuizDetail> reviewQuizzes
){
}


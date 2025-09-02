package com.igemoney.igemoney_BE.quiz.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class QuizCreateRequest {
    private String questionTitle;
    private String questionType;
    private String questionData;
    private String difficultyLevel;
    private String explanation;
    private Integer questionOrder;
    private BigDecimal correctRate;
    private Long topicId;
}
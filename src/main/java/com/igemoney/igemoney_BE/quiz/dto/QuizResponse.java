package com.igemoney.igemoney_BE.quiz.dto;

import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class QuizResponse {
    private Long quizId;
    private String questionTitle;
    private String questionType;
    private String questionData;
    private String difficultyLevel;
    private String explanation;
    private Integer questionOrder;
    private BigDecimal correctRate;

    private Long topicId;
    private String topicName;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
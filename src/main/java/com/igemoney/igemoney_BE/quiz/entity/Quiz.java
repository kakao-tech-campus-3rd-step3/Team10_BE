package com.igemoney.igemoney_BE.quiz.entity;

import com.igemoney.igemoney_BE.common.entity.BaseEntity;
import com.igemoney.igemoney_BE.quiz.entity.enums.DifficultyLevel;
import com.igemoney.igemoney_BE.quiz.entity.enums.QuestionType;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;


@Entity
@Table(name = "quiz")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Quiz extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "quiz_id")
    private Long quizId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "topic_id", nullable = false)
    private QuizTopic topic;

    @Column(name = "question_title", length = 200, nullable = false)
    private String questionTitle;

    @Enumerated(EnumType.STRING)
    @Column(name = "question_type", nullable = false)
    private QuestionType questionType;

    @Column(name = "question_data", columnDefinition = "json")
    private String questionData;

    @Enumerated(EnumType.STRING)
    @Column(name = "difficulty_level", nullable = false)
    private DifficultyLevel difficultyLevel;

    private String explanation;

    @Column(name = "question_order")
    private Integer questionOrder;

    @Column(name = "correct_rate", precision = 5, scale = 2)
    private BigDecimal correctRate;


    @Builder
    public Quiz(QuizTopic topic, String questionTitle, QuestionType questionType, String questionData, DifficultyLevel difficultyLevel, String explanation, Integer questionOrder) {
        this.topic = topic;
        this.questionTitle = questionTitle;
        this.questionType = questionType;
        this.questionData = questionData;
        this.difficultyLevel = difficultyLevel;
        this.explanation = explanation;
        this.questionOrder = questionOrder;
        this.correctRate = BigDecimal.ZERO;
    }

}

package com.igemoney.igemoney_BE.quiz.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "quiz_topic")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class QuizTopic {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String name;

    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    //topic 별로 퀴즈가 여러개 면 OneToMany 필드 추가
}
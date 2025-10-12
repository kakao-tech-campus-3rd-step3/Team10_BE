package com.igemoney.igemoney_BE.quiz.entity;

import com.igemoney.igemoney_BE.common.entity.BaseEntity;
import com.igemoney.igemoney_BE.user.entity.User;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "bookmark")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Bookmark extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY) // FK: user_id
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne(fetch = FetchType.LAZY) // FK: quiz_id
    @JoinColumn(name = "quiz_id", nullable = false)
    private Quiz quiz;

    @Builder
    private Bookmark(User user, Quiz quiz) {
        this.user = user;
        this.quiz = quiz;
    }
}
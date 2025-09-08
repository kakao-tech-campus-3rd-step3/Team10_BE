package com.igemoney.igemoney_BE.quiz.entity;

import com.igemoney.igemoney_BE.common.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Entity
@Table(name = "quiz_topic")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class QuizTopic extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String name;
}
package com.igemoney.igemoney_BE.quiz.repository;

import com.igemoney.igemoney_BE.quiz.entity.QuizTopic;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TopicRepository extends JpaRepository<QuizTopic, Long> {
}
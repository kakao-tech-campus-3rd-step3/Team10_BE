package com.igemoney.igemoney_BE.quiz.repository;


import com.igemoney.igemoney_BE.quiz.entity.UserQuizAttempt;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserQuizAttemptRepository extends JpaRepository<UserQuizAttempt, Long> {
}

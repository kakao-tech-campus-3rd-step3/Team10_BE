package com.igemoney.igemoney_BE.quiz.repository;


import com.igemoney.igemoney_BE.quiz.entity.UserQuizIncorrect;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserQuizIncorrectRepository extends JpaRepository<UserQuizIncorrect, Long> {
}

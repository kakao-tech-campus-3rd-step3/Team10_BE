package com.igemoney.igemoney_BE.quiz.repository;

import com.igemoney.igemoney_BE.quiz.entity.Quiz;
import com.igemoney.igemoney_BE.quiz.entity.UserQuizAttempt;
import com.igemoney.igemoney_BE.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;


public interface UserQuizAttemptRepository extends JpaRepository<UserQuizAttempt, Long> {

    List<UserQuizAttempt> findByUser_userId(@Param("userId") Long userId);

    boolean existsByUserAndQuizAndIsCompletedTrue(User user, Quiz quiz);

    long countByQuizIdAndIsCorrectTrue(Long quizId);
    long countByQuizId(Long quizId);
    Optional<UserQuizAttempt> findByUserAndQuiz(User user, Quiz quiz);

}

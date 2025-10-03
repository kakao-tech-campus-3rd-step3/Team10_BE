package com.igemoney.igemoney_BE.quiz.repository;


import com.igemoney.igemoney_BE.quiz.entity.UserQuizAttempt;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface UserQuizAttemptRepository extends JpaRepository<UserQuizAttempt, Long> {

    @Query("""
        SELECT a 
        FROM UserQuizAttempt a 
        JOIN FETCH a.quiz q 
        JOIN FETCH q.topic t 
        WHERE a.user.userId = :userId
    """)
    List<UserQuizAttempt> findReviewAttemptsWithQuizAndTopic(@Param("userId") Long userId);
}

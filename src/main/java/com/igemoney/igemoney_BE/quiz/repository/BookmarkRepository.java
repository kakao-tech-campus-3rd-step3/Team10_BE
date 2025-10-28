package com.igemoney.igemoney_BE.quiz.repository;

import com.igemoney.igemoney_BE.quiz.entity.Bookmark;
import com.igemoney.igemoney_BE.quiz.entity.Quiz;
import com.igemoney.igemoney_BE.user.entity.User;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface BookmarkRepository extends JpaRepository<Bookmark, Long> {
    long deleteByUserUserIdAndQuizId(Long userId, Long quizId);

    @Query("""
        select b
        from Bookmark b
            join fetch b.quiz q
        where b.user.userId = :userId
        order by b.createdAt desc
        """)
    List<Bookmark> findAllByUserIdJoinWithQuiz(Long userId);

    boolean existsByUserAndQuiz(User user, Quiz quiz);
}

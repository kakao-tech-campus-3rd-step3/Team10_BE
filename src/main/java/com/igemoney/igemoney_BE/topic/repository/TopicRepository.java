package com.igemoney.igemoney_BE.topic.repository;

import com.igemoney.igemoney_BE.topic.dto.TopicQuizResponse;
import com.igemoney.igemoney_BE.topic.dto.UserTopicResponse;
import com.igemoney.igemoney_BE.topic.entity.QuizTopic;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TopicRepository extends JpaRepository<QuizTopic, Long> {
    @Query(value = """
            SELECT
                qt.id AS topicId,
                qt.name AS topicName,
                COUNT(DISTINCT q.quiz_id) AS totalQuizCount,
                COUNT(DISTINCT uqa.quiz_id) AS solvedQuizCount
            FROM quiz_topic qt
            LEFT JOIN quiz q
                   ON q.topic_id = qt.id
            LEFT JOIN user_quiz_attempt uqa
                   ON uqa.quiz_id = q.quiz_id
                  AND uqa.user_id = :userId
                  AND uqa.is_completed = 1
            GROUP BY qt.id, qt.name
            ORDER BY qt.id
            """, nativeQuery = true)
    List<UserTopicResponse> findUserTopicSummary(@Param("userId") Long userId);

    @Query("""
    select new com.igemoney.igemoney_BE.topic.dto.TopicQuizResponse(
      q.id, q.questionOrder, q.questionTitle, q.difficultyLevel,
      case when exists (
        select 1
        from UserQuizAttempt uqa
        where uqa.quiz = q
          and uqa.user.userId = :userId
          and uqa.isCompleted = true
      ) then true else false end,
      case when exists (
        select 1
        from Bookmark b
        where b.quiz = q
          and b.user.userId = :userId
      ) then true else false end
    )
    from Quiz q
    where q.topic.id = :topicId
    order by q.questionOrder asc, q.id asc
""")
    Page<TopicQuizResponse> findTopicQuizzes(@Param("userId") Long userId,
                                             @Param("topicId") Long topicId,
                                             Pageable pageable);
}
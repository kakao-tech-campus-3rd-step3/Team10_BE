package com.igemoney.igemoney_BE.topic.repository;

import com.igemoney.igemoney_BE.topic.dto.TopicQuizResponse;
import com.igemoney.igemoney_BE.topic.dto.UserTopicResponse;
import com.igemoney.igemoney_BE.topic.entity.QuizTopic;
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
        q.id,
        q.questionOrder,
        q.questionTitle,
        q.difficultyLevel,
        case when (
            select count(uqa)
            from UserQuizAttempt uqa
            where uqa.quiz.id = q.id
              and uqa.id = :userId
              and uqa.isCompleted = true
        ) > 0 then true else false end,
      case when (
          select count(b)
          from Bookmark b
          where b.quiz.id = q.id
            and b.user.userId = :userId
      ) > 0 then true else false end\s
    )
    from Quiz q
    where q.topic.id = :topicId
    order by q.questionOrder asc, q.id asc
""")
    List<TopicQuizResponse> findTopicQuizzes(Long userId, Long topicId);
}
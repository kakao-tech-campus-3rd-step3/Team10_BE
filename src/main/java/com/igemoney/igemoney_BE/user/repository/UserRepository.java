package com.igemoney.igemoney_BE.user.repository;

import com.igemoney.igemoney_BE.user.entity.User;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByKakaoOauthId(Long kakaoOauthId);

    Optional<User> findByUserId(Long userId);

    Page<User> findAll(Pageable pageable);

    // 랭킹 서비스 관련
    // RatingPoint 상위 3명
    @Query("SELECT u FROM User u ORDER BY u.ratingPoint DESC, u.ratingPointUpdatedAt ASC")
    List<User> findTop3ByRatingPointRank(Pageable pageable);

    // 현재 유저 기준 바로 위 2명
    @Query("""
        SELECT u FROM User u
        WHERE (u.ratingPoint > :ratingPoint)
           OR (u.ratingPoint = :ratingPoint AND u.ratingPointUpdatedAt < :ratingPointUpdatedAt)
        ORDER BY u.ratingPoint ASC, u.ratingPointUpdatedAt DESC
    """)
    List<User> findTop2AboveByRating(
            @Param("ratingPoint") Integer ratingPoint,
            @Param("ratingPointUpdatedAt") LocalDateTime ratingPointUpdatedAt,
            Pageable pageable
    );

    // 현재 유저 기준 바로 아래 2명
    @Query("""
        SELECT u FROM User u
        WHERE (u.ratingPoint < :ratingPoint)
           OR (u.ratingPoint = :ratingPoint AND u.ratingPointUpdatedAt > :ratingPointUpdatedAt)
        ORDER BY u.ratingPoint DESC, u.ratingPointUpdatedAt ASC
    """)
    List<User> findTop2BelowByRating(
            @Param("ratingPoint") Integer ratingPoint,
            @Param("ratingPointUpdatedAt") LocalDateTime ratingPointUpdatedAt,
            Pageable pageable
    );

    // 연속 출석 기준 랭킹
    @Query("SELECT u FROM User u ORDER BY u.consecutiveAttendance DESC, u.consecutiveAttendanceUpdatedAt ASC")
    List<User> findTop3ByConsecutiveAttendanceRank(Pageable pageable);

    @Query("""
        SELECT u FROM User u
        WHERE (u.consecutiveAttendance > :consecutiveAttendance)
           OR (u.consecutiveAttendance = :consecutiveAttendance AND u.consecutiveAttendanceUpdatedAt < :consecutiveAttendanceUpdatedAt)
        ORDER BY u.consecutiveAttendance ASC, u.consecutiveAttendanceUpdatedAt DESC
    """)
    List<User> findTop2AboveByConsecutiveAttendance(
            @Param("consecutiveAttendance") Integer consecutiveAttendance,
            @Param("consecutiveAttendanceUpdatedAt") LocalDateTime consecutiveAttendanceUpdatedAt,
            Pageable pageable
    );

    @Query("""
        SELECT u FROM User u
        WHERE (u.consecutiveAttendance < :consecutiveAttendance)
           OR (u.consecutiveAttendance = :consecutiveAttendance AND u.consecutiveAttendanceUpdatedAt > :consecutiveAttendanceUpdatedAt)
        ORDER BY u.consecutiveAttendance DESC, u.consecutiveAttendanceUpdatedAt ASC
    """)
    List<User> findTop2BelowByConsecutiveAttendance(
            @Param("consecutiveAttendance") Integer consecutiveAttendance,
            @Param("consecutiveAttendanceUpdatedAt") LocalDateTime consecutiveAttendanceUpdatedAt,
            Pageable pageable
    );

    // 현재 유저 랭킹 순위 조회
    @Query("""
        SELECT COUNT(u)
        FROM User u
        WHERE (u.ratingPoint > :ratingPoint)
           OR (u.ratingPoint = :ratingPoint AND u.ratingPointUpdatedAt < :ratingPointUpdatedAt)
    """)
    Long getRatingRank(
            @Param("ratingPoint") Integer ratingPoint,
            @Param("ratingPointUpdatedAt") LocalDateTime ratingPointUpdatedAt
    );

    @Query("""
        SELECT COUNT(u)
        FROM User u
        WHERE (u.consecutiveAttendance > :consecutiveAttendance)
           OR (u.consecutiveAttendance = :consecutiveAttendance AND u.consecutiveAttendanceUpdatedAt < :consecutiveAttendanceUpdatedAt)
    """)
    Long getConsecutiveAttendanceRank(
            @Param("consecutiveAttendance") Integer consecutiveAttendance,
            @Param("consecutiveAttendanceUpdatedAt") LocalDateTime consecutiveAttendanceUpdatedAt
    );
}

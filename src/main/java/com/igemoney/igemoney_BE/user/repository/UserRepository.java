package com.igemoney.igemoney_BE.user.repository;

import com.igemoney.igemoney_BE.user.entity.User;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByKakaoOauthId(Long kakaoOauthId);

    Optional<User> findByUserId(Long userId);

    Page<User> findAll(Pageable pageable);

    // 랭킹 서비스 관련
    // RatingPoint 상위 3명
    List<User> findTop3ByOrderByRatingPointDesc();

    // 현재 유저 기준 바로 위 2명
    List<User> findTop2ByRatingPointGreaterThanOrderByRatingPointAsc(int ratingPoint);

    // 현재 유저 기준 바로 아래 2명
    List<User> findTop2ByRatingPointLessThanOrderByRatingPointDesc(int ratingPoint);

    // 연속 출석 기준 랭킹
    List<User> findTop3ByOrderByConsecutiveAttendanceDesc();
    List<User> findTop2ByConsecutiveAttendanceGreaterThanOrderByConsecutiveAttendanceAsc(int consecutiveAttendance);
    List<User> findTop2ByConsecutiveAttendanceLessThanOrderByConsecutiveAttendanceDesc(int consecutiveAttendance);
}

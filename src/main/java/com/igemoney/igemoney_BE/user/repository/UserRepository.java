package com.igemoney.igemoney_BE.user.repository;

import com.igemoney.igemoney_BE.user.entity.User;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByKakaoOauthId(Long kakaoOauthId);

    // 랭킹 서비스 관련
    List<User> findTop3ByOrderByRatingPointDesc();

    List<User> findTop3ByOrderByConsecutiveAttendanceDesc();
}

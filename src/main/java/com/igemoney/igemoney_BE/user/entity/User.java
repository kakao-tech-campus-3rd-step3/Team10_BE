package com.igemoney.igemoney_BE.user.entity;

import com.igemoney.igemoney_BE.common.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;


// todo: 매일 자정마다 유저 엔티티 순회해 연속 출석일, 오늘 푼 문제수 재조정하는 스케줄링 로직 작성

@Entity
@Table(name = "user")
@Getter
@NoArgsConstructor
public class User extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    @Column(name = "nickname", unique = true, nullable = false)
    private String nickname;

    @Column(unique = true)
    private Long kakaoOauthId;

    @Column
    private Integer ratingPoint;

    @Column
    private Integer consecutiveAttendance;

    @Column
    private Integer todayCount;

    @Column
    private Boolean isActive;


    // 가입단에서 유저를 만들 때 사용하는 생성자
    @Builder
    public User(String nickname, Long oauthId) {
        this.nickname = nickname;
        this.kakaoOauthId = oauthId;
        this.ratingPoint = 0;
        this.consecutiveAttendance = 1;
        this.todayCount = 0;
        this.isActive = true;
    }


    public void increaseTodaySolvedCount() {
        this.todayCount++;
    }


    public void updateConsecutiveAttendance(Integer consecutiveAttendance) {
        this.consecutiveAttendance = consecutiveAttendance;
    }


    // todo: 푼 문제의 난이도 별 가중치를 다르게 적용시키는 비즈니스 로직 작성하기
    public void updateRatingPoint(Integer ratingPoint) {
        this.ratingPoint = ratingPoint;
    }

}

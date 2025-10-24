package com.igemoney.igemoney_BE.user.entity;

import com.igemoney.igemoney_BE.common.entity.BaseEntity;
import com.igemoney.igemoney_BE.propensity.type.InvestmentPropensity;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Entity
@Table(name = "user",
        indexes = {
                @Index(name = "idx_consecutive_attendance_desc", columnList = "consecutiveAttendance DESC")
        })
@Getter
@NoArgsConstructor
public class User extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    @Column(name = "nickname", unique = true, nullable = false)
    private String nickname;

    @Column(name = "kakao_oauth_id", unique = true)
    private Long kakaoOauthId;

    @Column
    private Integer ratingPoint;

    @Column
    private Integer consecutiveAttendance;

    @Column
    private Integer todayCount;

    @Column
    private Boolean isActive;

    @Enumerated(EnumType.STRING)
    @Column(name = "investment_propensity")
    private InvestmentPropensity investmentPropensity;


    // 가입단에서 유저를 만들 때 사용하는 생성자
    @Builder
    public User(String nickname, Long oauthId) {
        this.nickname = nickname;
        this.kakaoOauthId = oauthId;
        this.ratingPoint = 0;
        this.consecutiveAttendance = 1;
        this.todayCount = 0;
        this.isActive = true;
        this.investmentPropensity = InvestmentPropensity.UNDIAGNOSED;
    }


    public void increaseTodaySolvedCount() {
        this.todayCount++;
    }

    public void resetTodaySolvedCount() {
        this.todayCount = 0;
    }

    public void increaseConsecutiveAttendance() {
        this.consecutiveAttendance++;
    }

    public  void resetConsecutiveAttendance() {
        this.consecutiveAttendance = 0;
    }

    public void updateInvestmentPropensity(InvestmentPropensity propensity) {
        this.investmentPropensity = propensity;
    }

    // todo: 푼 문제의 난이도 별 가중치를 다르게 적용시키는 비즈니스 로직 작성하기
    public void updateRatingPoint(Integer ratingPoint) {
        this.ratingPoint = ratingPoint;
    }

}

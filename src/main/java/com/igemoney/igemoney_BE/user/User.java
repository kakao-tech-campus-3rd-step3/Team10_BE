package com.igemoney.igemoney_BE.user;

import com.igemoney.igemoney_BE.BaseEntity.BaseEntity;
import jakarta.persistence.*;

@Entity
@Table(name = "user")
public class User extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String userId;

    @Column(name = "nickname", unique = true, nullable = false)
    private String nickname;


    @Column(name = "oauth_id", unique = true)
    private String oauthId;

    @Column(name = "rating_point")
    private int ratingPoint;

    @Column(name = "consecutive_attendence_days")
    private int consecutiveAttendence;

    @Column(name = "today_solved_count")
    private int todayCount;

    @Column(name = "is_active")
    private boolean isActive;
}

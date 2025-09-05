package com.igemoney.igemoney_BE.user;

import com.igemoney.igemoney_BE.BaseEntity.BaseEntity;
import jakarta.persistence.*;

@Entity
@Table(name = "user")
public class UserModel extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String userId;

    @Column(name = "nickname", unique = true, nullable = false)
    private String nickname;


    @Column(name = "oauth_id", unique = true)
    private String oauthId;

    @Column(name = "rating_point")
    private int rating_point;

    @Column(name = "consecutive_attendence_days")
    private int consecutive_attendence;

    @Column(name = "today_solved_count")
    private int today_count;

    @Column(name = "is_active")
    private boolean is_active;
}

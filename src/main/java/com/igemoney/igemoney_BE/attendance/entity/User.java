package com.igemoney.igemoney_BE.attendance.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.time.LocalDateTime;

@Entity
@Table(name = "users")
public class User {

    @Id
    @Column(name = "`Key`", nullable = false, length = 255)
    private String key;

    @Column(nullable = false, length = 50)
    private String nickname;

    @Column(name = "oauth_id", nullable = false, length = 100)
    private String oauthId;

    @Column(name = "rating_point", nullable = false)
    private int ratingPoint;

    @Column(name = "consecutive_attendance_days", nullable = false)
    private int consecutiveAttendanceDays;

    @Column(name = "last_attendance_at")
    private LocalDateTime lastAttendanceAt;

    @Column(name = "today_solved_count", nullable = false)
    private int todaySolvedCount;

    @Column(name = "is_active", nullable = false)
    private boolean isActive;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

    // Getters and Setters
    public String getKey() { return key; }
    public void setKey(String key) { this.key = key; }

    public String getNickname() { return nickname; }
    public void setNickname(String nickname) { this.nickname = nickname; }

    public String getOauthId() { return oauthId; }
    public void setOauthId(String oauthId) { this.oauthId = oauthId; }

    public int getRatingPoint() { return ratingPoint; }
    public void setRatingPoint(int ratingPoint) { this.ratingPoint = ratingPoint; }

    public int getConsecutiveAttendanceDays() { return consecutiveAttendanceDays; }
    public void setConsecutiveAttendanceDays(int consecutiveAttendanceDays) { this.consecutiveAttendanceDays = consecutiveAttendanceDays; }

    public LocalDateTime getLastAttendanceAt() {
        return lastAttendanceAt;
    }

    public void setLastAttendanceAt(LocalDateTime lastAttendanceAt) {
        this.lastAttendanceAt = lastAttendanceAt;
    }

    public int getTodaySolvedCount() { return todaySolvedCount; }
    public void setTodaySolvedCount(int todaySolvedCount) { this.todaySolvedCount = todaySolvedCount; }

    public boolean isActive() { return isActive; }
    public void setActive(boolean active) { isActive = active; }

    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }
}

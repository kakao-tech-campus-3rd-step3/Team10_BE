package com.igemoney.igemoney_BE.attendance.entity;

import com.igemoney.igemoney_BE.common.entity.BaseEntity;
import com.igemoney.igemoney_BE.user.entity.User;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;

@Entity
@Table(
        name = "user_attendance_day",
        uniqueConstraints = {
                @UniqueConstraint(name = "unique_attendance_user_date", columnNames = {"user_id", "attendance_date"})
        },
        indexes = {
                @Index(name = "idx_attendance_user_date", columnList = "user_id, attendance_date")
        }
)
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class UserAttendanceDay extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", nullable = false) // User.userId FK
    private User user;

    @Column(name = "attendance_date", nullable = false)
    private LocalDate attendanceDate; // 유저 기준 날짜 스냅샷

    public UserAttendanceDay(User user, LocalDate attendanceDate) {
        this.user = user;
        this.attendanceDate = attendanceDate;
    }
}

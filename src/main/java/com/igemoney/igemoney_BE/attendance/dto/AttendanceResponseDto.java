package com.igemoney.igemoney_BE.attendance.dto;

public class AttendanceResponseDto {
    private boolean attendanceToday;
    private int todaySolvedCount;

    public AttendanceResponseDto(boolean attendanceToday, int todaySolvedCount) {
        this.attendanceToday = attendanceToday;
        this.todaySolvedCount = todaySolvedCount;
    }

    public boolean isAttendanceToday() { return attendanceToday; }
    public void setAttendanceToday(boolean attendanceToday) { this.attendanceToday = attendanceToday; }

    public int getTodaySolvedCount() { return todaySolvedCount; }
    public void setTodaySolvedCount(int todaySolvedCount) { this.todaySolvedCount = todaySolvedCount; }
}

package com.igemoney.igemoney_BE.user.dto;

public record TodayAttendanceResponse(
    boolean isAttended,
    int todaySolvedCount
) {

}

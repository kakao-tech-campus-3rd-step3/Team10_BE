package com.igemoney.igemoney_BE.topic.dto;

public record UserTopicResponse(
        Long topicId,
        String topicName,
        long totalQuizCount,
        long solvedQuizCount
) {
}
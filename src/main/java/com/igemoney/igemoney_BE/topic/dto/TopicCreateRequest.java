package com.igemoney.igemoney_BE.topic.dto;

import com.igemoney.igemoney_BE.topic.entity.QuizTopic;

public record TopicCreateRequest(String name
) {
    public static QuizTopic toEntity(TopicCreateRequest request) {
        return QuizTopic.builder()
                .name(request.name())
                .build();
    }
}
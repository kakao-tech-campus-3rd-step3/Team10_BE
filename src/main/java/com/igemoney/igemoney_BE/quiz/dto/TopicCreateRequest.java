package com.igemoney.igemoney_BE.quiz.dto;

import com.igemoney.igemoney_BE.quiz.entity.QuizTopic;

public record TopicCreateRequest(String name
) {
    public static QuizTopic toEntity(TopicCreateRequest request) {
        return QuizTopic.builder()
                .name(request.name())
                .build();
    }
}
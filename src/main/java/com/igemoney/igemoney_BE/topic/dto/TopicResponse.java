package com.igemoney.igemoney_BE.topic.dto;

import com.igemoney.igemoney_BE.topic.entity.QuizTopic;

public record TopicResponse(Long id, String name) {
    public static TopicResponse from(QuizTopic topic) {
        return new TopicResponse(topic.getId(), topic.getName());
    }
}
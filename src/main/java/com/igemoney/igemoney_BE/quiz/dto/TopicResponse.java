package com.igemoney.igemoney_BE.quiz.dto;

import com.igemoney.igemoney_BE.quiz.entity.QuizTopic;

public record TopicResponse(Long id, String name) {
    public static TopicResponse from(QuizTopic topic) {
        return new TopicResponse(topic.getId(), topic.getName());
    }
}
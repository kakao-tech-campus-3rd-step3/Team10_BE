package com.igemoney.igemoney_BE.topic.exception;

public class TopicNotFoundException extends RuntimeException {
    public TopicNotFoundException(Long topicId) {
        super("Topic not found with id: " + topicId);
    }
}
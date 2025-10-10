package com.igemoney.igemoney_BE.topic.service;

import com.igemoney.igemoney_BE.topic.dto.*;
import com.igemoney.igemoney_BE.topic.entity.QuizTopic;
import com.igemoney.igemoney_BE.topic.exception.TopicNotFoundException;
import com.igemoney.igemoney_BE.topic.repository.TopicRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class TopicService {
    private final TopicRepository topicRepository;

    public TopicResponse createTopic(TopicCreateRequest request) {
        QuizTopic saved = topicRepository.save(TopicCreateRequest.toEntity(request));
        return TopicResponse.from(saved);
    }

    public void deleteTopic(Long id) {
        topicRepository.deleteById(id);
    }

    @Transactional(readOnly = true)
    public List<TopicResponse> getAllTopics() {
        return topicRepository.findAll().stream()
                .map(TopicResponse::from)
                .toList();
    }

    @Transactional(readOnly = true)
    public UserTopicList getTopicsProgress(Long userId) {
        List<UserTopicResponse> responses = topicRepository.findUserTopicSummary(userId);
        return new UserTopicList(responses);
    }

    public TopicQuizList getTopicQuizzes(Long userId, Long topicId) {
        List<TopicQuizResponse> responses = topicRepository.findTopicQuizzes(userId, topicId);
        return new TopicQuizList(responses);
    }

    public QuizTopic getTopicOrThrow(Long topicId) {
        return topicRepository.findById(topicId)
                .orElseThrow(() -> new TopicNotFoundException(topicId));
    }
}
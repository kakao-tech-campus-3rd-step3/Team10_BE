package com.igemoney.igemoney_BE.topic.service;

import com.igemoney.igemoney_BE.common.exception.user.UserNotFoundException;
import com.igemoney.igemoney_BE.quiz.entity.Quiz;
import com.igemoney.igemoney_BE.topic.dto.*;
import com.igemoney.igemoney_BE.topic.entity.QuizTopic;
import com.igemoney.igemoney_BE.topic.exception.TopicNotFoundException;
import com.igemoney.igemoney_BE.topic.repository.TopicRepository;
import com.igemoney.igemoney_BE.user.entity.User;
import com.igemoney.igemoney_BE.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties.Retry.Topic;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class TopicService {
    private final TopicRepository topicRepository;
    private final UserRepository userRepository;

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

    public TopicQuizList getTopicQuizzes(Long userId, Long topicId, int page, int size) {
        User user = userRepository.findById(userId)
            .orElseThrow(UserNotFoundException::new);

        QuizTopic topic = topicRepository.findById(topicId)
            .orElseThrow(() -> new TopicNotFoundException(topicId));

        Pageable pageable = PageRequest.of(page, size);

        Page<TopicQuizResponse> quizPage = topicRepository.findTopicQuizzes(userId, topicId, pageable);

        return new TopicQuizList(quizPage.getContent());
    }

    public QuizTopic getTopicOrThrow(Long topicId) {
        return topicRepository.findById(topicId)
                .orElseThrow(() -> new TopicNotFoundException(topicId));
    }
}
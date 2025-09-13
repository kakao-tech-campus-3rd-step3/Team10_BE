package com.igemoney.igemoney_BE.quiz.service;

import com.igemoney.igemoney_BE.quiz.dto.TopicCreateRequest;
import com.igemoney.igemoney_BE.quiz.dto.TopicResponse;
import com.igemoney.igemoney_BE.quiz.entity.QuizTopic;
import com.igemoney.igemoney_BE.quiz.repository.TopicRepository;
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
}
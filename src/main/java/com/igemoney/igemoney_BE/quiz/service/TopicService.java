package com.igemoney.igemoney_BE.quiz.service;

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

    public QuizTopic createTopic(QuizTopic topic) {
        return topicRepository.save(topic);
    }

    public void deleteTopic(Long id) {
        topicRepository.deleteById(id);
    }

    @Transactional(readOnly = true)
    public List<QuizTopic> getAllTopics() {
        return topicRepository.findAll();
    }
}
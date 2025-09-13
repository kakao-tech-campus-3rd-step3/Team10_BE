package com.igemoney.igemoney_BE.quiz.controller;

import com.igemoney.igemoney_BE.quiz.dto.TopicCreateRequest;
import com.igemoney.igemoney_BE.quiz.dto.TopicResponse;
import com.igemoney.igemoney_BE.quiz.entity.QuizTopic;
import com.igemoney.igemoney_BE.quiz.service.TopicService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/topic")
@RequiredArgsConstructor
public class TopicController {
    private final TopicService topicService;

    @PostMapping
    public TopicResponse createTopic(@RequestBody TopicCreateRequest request) {
        return topicService.createTopic(request);
    }

    @DeleteMapping("/{id}")
    public void deleteTopic(@PathVariable Long id) {
        topicService.deleteTopic(id);
    }

    @GetMapping
    public List<TopicResponse> getAllTopics() {
        return topicService.getAllTopics();
    }
}
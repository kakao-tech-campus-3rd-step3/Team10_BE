package com.igemoney.igemoney_BE.topic.controller;

import com.igemoney.igemoney_BE.common.annotation.Authenticated;
import com.igemoney.igemoney_BE.common.utils.JwtUtil;
import com.igemoney.igemoney_BE.topic.dto.TopicCreateRequest;
import com.igemoney.igemoney_BE.topic.dto.TopicResponse;
import com.igemoney.igemoney_BE.topic.dto.UserTopicList;
import com.igemoney.igemoney_BE.topic.service.TopicService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/topic")
@RequiredArgsConstructor
public class TopicController {
    private final TopicService topicService;
    private final JwtUtil jwtUtil;

    @PostMapping
    public TopicResponse createTopic(@RequestBody TopicCreateRequest request) {
        return topicService.createTopic(request);
    }

    @DeleteMapping("/{id}")
    public void deleteTopic(@PathVariable Long id) {
        topicService.deleteTopic(id);
    }

    @GetMapping("/all")
    public List<TopicResponse> getAllTopics() {
        return topicService.getAllTopics();
    }

    @Authenticated
    @GetMapping
    public UserTopicList getUserTopics(@RequestHeader("Authorization") String authHeader) {
        String token = authHeader.replace("Bearer ", "");
        Long userId = Long.parseLong(jwtUtil.getSubject(token));
        return topicService.getUserTopics(userId);
    }
}
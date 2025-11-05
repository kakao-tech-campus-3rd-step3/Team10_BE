package com.igemoney.igemoney_BE.topic.controller;

import com.igemoney.igemoney_BE.common.annotation.Authenticated;
import com.igemoney.igemoney_BE.common.utils.JwtUtil;
import com.igemoney.igemoney_BE.topic.dto.TopicCreateRequest;
import com.igemoney.igemoney_BE.topic.dto.TopicQuizList;
import com.igemoney.igemoney_BE.topic.dto.TopicResponse;
import com.igemoney.igemoney_BE.topic.dto.UserTopicList;
import com.igemoney.igemoney_BE.topic.entity.QuizTopic;
import com.igemoney.igemoney_BE.topic.service.TopicService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/topics")
@RequiredArgsConstructor
@Tag(name = "Quiz Topic", description = "퀴즈 토픽 API")
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
    public UserTopicList getTopicsProgress(@RequestAttribute("userId") Long userId){
        return topicService.getTopicsProgress(userId);
    }

    @Authenticated
    @GetMapping("/{topicId}")
    public TopicQuizList getTopicQuizzes(
            @RequestAttribute("userId") Long userId,
            @PathVariable Long topicId,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size
    ){
        QuizTopic topic = topicService.getTopicOrThrow(topicId);
        return topicService.getTopicQuizzes(userId, topicId, page, size);
    }
}
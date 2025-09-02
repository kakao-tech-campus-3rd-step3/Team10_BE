package com.igemoney.igemoney_BE.quiz.service;

import com.igemoney.igemoney_BE.quiz.dto.QuizCreateRequest;
import com.igemoney.igemoney_BE.quiz.dto.QuizResponse;
import com.igemoney.igemoney_BE.quiz.entity.DifficultyLevel;
import com.igemoney.igemoney_BE.quiz.entity.QuestionType;
import com.igemoney.igemoney_BE.quiz.entity.Quiz;
import com.igemoney.igemoney_BE.quiz.entity.QuizTopic;
import com.igemoney.igemoney_BE.quiz.repository.QuizRepository;
import com.igemoney.igemoney_BE.quiz.repository.TopicRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class QuizService {
    private final QuizRepository quizRepository;
    private final TopicRepository topicRepository;
    public Quiz createQuiz(QuizCreateRequest request) {
        QuizTopic topic = topicRepository.findById(request.getTopicId())
                .orElseThrow(() -> new IllegalArgumentException("Topic not found"));

        Quiz quiz = Quiz.builder()
                .questionTitle(request.getQuestionTitle())
                .questionType(QuestionType.valueOf(request.getQuestionType()))
                .questionData(request.getQuestionData())
                .difficultyLevel(DifficultyLevel.valueOf(request.getDifficultyLevel()))
                .explanation(request.getExplanation())
                .questionOrder(request.getQuestionOrder())
                .correctRate(request.getCorrectRate())
                .topic(topic)
                .build();

        return quizRepository.save(quiz);
    }

    public void deleteQuiz(Long id) {
        quizRepository.deleteById(id);
    }

    @Transactional(readOnly = true)
    public List<QuizResponse> getAll() {
        return quizRepository.findAll().stream()
                .map(this::toResponse)
                .toList();
    }

    private QuizResponse toResponse(Quiz q) {
        return QuizResponse.builder()
                .quizId(q.getQuizId())
                .questionTitle(q.getQuestionTitle())
                .questionType(q.getQuestionType().name())
                .questionData(q.getQuestionData())
                .difficultyLevel(q.getDifficultyLevel().name())
                .explanation(q.getExplanation())
                .questionOrder(q.getQuestionOrder())
                .correctRate(q.getCorrectRate())
                .topicId(q.getTopic().getId())
                .topicName(q.getTopic().getName())
                .createdAt(q.getCreatedAt())
                .updatedAt(q.getUpdatedAt())
                .build();
    }
}
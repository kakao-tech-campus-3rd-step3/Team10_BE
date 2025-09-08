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
@Transactional
@RequiredArgsConstructor
public class QuizService {
    private final QuizRepository quizRepository;
    private final TopicRepository topicRepository;
    public Quiz createQuiz(QuizCreateRequest request) {
        QuizTopic topic = topicRepository.findById(request.topicId())
                .orElseThrow(() -> new IllegalArgumentException("Topic not found"));

        Quiz quiz = Quiz.builder()
                .questionTitle(request.questionTitle())
                .questionType(QuestionType.valueOf(request.questionType()))
                .questionData(request.questionData())
                .difficultyLevel(DifficultyLevel.valueOf(request.difficultyLevel()))
                .explanation(request.explanation())
                .questionOrder(request.questionOrder())
                .correctRate(request.correctRate())
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
        return new QuizResponse(
                q.getQuizId(),
                q.getQuestionTitle(),
                q.getQuestionType().name(),
                q.getQuestionData(),
                q.getDifficultyLevel().name(),
                q.getExplanation(),
                q.getQuestionOrder(),
                q.getCorrectRate(),
                q.getTopic().getId(),
                q.getTopic().getName(),
                q.getCreatedAt(),
                q.getUpdatedAt()
        );
    }
}
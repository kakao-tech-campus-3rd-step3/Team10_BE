package com.igemoney.igemoney_BE.quiz.service;


import com.igemoney.igemoney_BE.quiz.dto.QuizCreateRequest;
import com.igemoney.igemoney_BE.quiz.dto.QuizResponse;
import com.igemoney.igemoney_BE.quiz.dto.QuizSubmitRequest;
import com.igemoney.igemoney_BE.quiz.entity.UserQuizCorrect;
import com.igemoney.igemoney_BE.quiz.entity.UserQuizIncorrect;
import com.igemoney.igemoney_BE.quiz.entity.enums.DifficultyLevel;
import com.igemoney.igemoney_BE.quiz.entity.enums.QuestionType;
import com.igemoney.igemoney_BE.quiz.entity.Quiz;
import com.igemoney.igemoney_BE.quiz.entity.QuizTopic;
import com.igemoney.igemoney_BE.quiz.repository.QuizRepository;
import com.igemoney.igemoney_BE.quiz.repository.TopicRepository;
import com.igemoney.igemoney_BE.quiz.repository.UserQuizCorrectRepository;
import com.igemoney.igemoney_BE.quiz.repository.UserQuizIncorrectRepository;
import com.igemoney.igemoney_BE.user.entity.User;
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
	private final UserQuizCorrectRepository userQuizCorrectRepository;
	private final UserQuizIncorrectRepository userQuizIncorrectRepository;


	public QuizResponse createQuiz(QuizCreateRequest request) {
		QuizTopic topic = topicRepository.findById(request.topicId())
			.orElseThrow(() -> new IllegalArgumentException("Topic not found: " + request.topicId()));

		Quiz quiz = QuizCreateRequest.toEntity(request, topic);
		Quiz saved = quizRepository.save(quiz);

		return QuizResponse.from(saved);
	}


	public void deleteQuiz(Long id) {
		quizRepository.deleteById(id);
	}


	@Transactional(readOnly = true)
	public List<QuizResponse> getAll() {
		return quizRepository.findAll().stream()
			.map(QuizResponse::from)
			.toList();
	}


	private QuizResponse toResponse(Quiz q) {
		return new QuizResponse(
			q.getId(),
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

	@Transactional(readOnly = true)
	public QuizResponse getQuizInfo(Long id) {
		Quiz quiz = quizRepository.findById(id)
			.orElseThrow(() -> new IllegalArgumentException("Quiz not found"));

		return QuizResponse.from(quiz);
	}


	// todo: 인증인가 들어오면 userId도 받고 User 찾는 로직 채워넣기
	public void submitQuizResult(Long quizId, QuizSubmitRequest request) {
		Quiz quiz = quizRepository.findById(quizId)
			.orElseThrow(() -> new IllegalArgumentException("Quiz not found"));

		//	    User user = userRepository.findById()
		//	        .orElseThrow(() -> new IllegalArgumentException("User not found"));

		if (request.isCorrect()) {
			UserQuizCorrect userQuizCorrect = UserQuizCorrect.builder()
				.user(new User())
				.quiz(quiz)
				.build();

			userQuizCorrectRepository.save(userQuizCorrect);
		} else {
			UserQuizIncorrect userQuizIncorrect = UserQuizIncorrect.builder()
				.user(new User())
				.quiz(quiz)
				.build();

			userQuizIncorrectRepository.save(userQuizIncorrect);
		}
	}

}

package com.igemoney.igemoney_BE.quiz.service;


import com.igemoney.igemoney_BE.quiz.dto.*;
import com.igemoney.igemoney_BE.quiz.entity.UserQuizAttempt;
import com.igemoney.igemoney_BE.quiz.entity.Quiz;
import com.igemoney.igemoney_BE.topic.entity.QuizTopic;
import com.igemoney.igemoney_BE.quiz.repository.QuizRepository;
import com.igemoney.igemoney_BE.topic.repository.TopicRepository;
import com.igemoney.igemoney_BE.quiz.repository.UserQuizAttemptRepository;
import com.igemoney.igemoney_BE.user.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;


@Service
@Transactional
@RequiredArgsConstructor
public class QuizService {

	private final QuizRepository quizRepository;
	private final TopicRepository topicRepository;
	private final UserQuizAttemptRepository userQuizAttemptRepository;


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


	@Transactional(readOnly = true)
	public QuizResponse getQuizInfo(Long id) {
		Quiz quiz = quizRepository.findById(id)
			.orElseThrow(() -> new IllegalArgumentException("Quiz not found"));

		return QuizResponse.from(quiz);
	}

	public QuizReviewResponse getQuizReview(Long userId) {
		List<UserQuizAttempt> attempts = userQuizAttemptRepository.findReviewAttemptsWithQuizAndTopic(userId);

		List<ReviewQuizDetail> quizDetails = attempts.stream()
			.map(ReviewQuizDetail::from)
			.toList();

		return new QuizReviewResponse(
				!quizDetails.isEmpty(),
				quizDetails
		);
	}


	// todo: 인증인가 들어오면 userId도 받고 User 찾는 로직 채워넣기
	public void submitQuizResult(Long quizId, QuizSubmitRequest request) {
		Quiz quiz = quizRepository.findById(quizId)
			.orElseThrow(() -> new IllegalArgumentException("Quiz not found"));

		//	    User user = userRepository.findById()
		//	        .orElseThrow(() -> new IllegalArgumentException("User not found"));
		User user = new User();

		if(request.isCorrect()){
			UserQuizAttempt userQuizCorrect = UserQuizAttempt.userQuizCorrect(user, quiz);
			userQuizAttemptRepository.save(userQuizCorrect);
		} else {
			UserQuizAttempt userQuizWrong = UserQuizAttempt.userQuizInCorrect(user, quiz);
			userQuizAttemptRepository.save(userQuizWrong);
		}
	}

}
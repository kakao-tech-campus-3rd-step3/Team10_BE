package com.igemoney.igemoney_BE.quiz.service;


import com.igemoney.igemoney_BE.common.exception.quiz.QuizNotFoundException;
import com.igemoney.igemoney_BE.common.exception.user.UserNotFoundException;
import com.igemoney.igemoney_BE.quiz.dto.*;
import com.igemoney.igemoney_BE.quiz.entity.UserQuizAttempt;
import com.igemoney.igemoney_BE.quiz.entity.Quiz;
import com.igemoney.igemoney_BE.quiz.repository.BookmarkRepository;

import com.igemoney.igemoney_BE.quiz.repository.QuizRepository;
import com.igemoney.igemoney_BE.topic.repository.TopicRepository;
import com.igemoney.igemoney_BE.quiz.repository.UserQuizAttemptRepository;
import com.igemoney.igemoney_BE.user.entity.User;
import com.igemoney.igemoney_BE.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;


@Service
@Transactional
@RequiredArgsConstructor
public class QuizService {

	private final UserRepository userRepository;
	private final QuizRepository quizRepository;
	private final TopicRepository topicRepository;
	private final UserQuizAttemptRepository userQuizAttemptRepository;
	private final BookmarkRepository bookmarkRepository;


//	public QuizResponse createQuiz(QuizCreateRequest request) {
//		QuizTopic topic = topicRepository.findById(request.topicId())
//			.orElseThrow(() -> new IllegalArgumentException("Topic not found: " + request.topicId()));
//
//		Quiz quiz = QuizCreateRequest.toEntity(request, topic);
//		Quiz saved = quizRepository.save(quiz);
//
//		return QuizResponse.from(saved);
//	}
//
//
//	public void deleteQuiz(Long id) {
//		quizRepository.deleteById(id);
//	}


//	@Transactional(readOnly = true)
//	public List<QuizResponse> getAll() {
//		return quizRepository.findAll().stream()
//			.map(QuizResponse::from)
//			.toList();
//	}


	@Transactional(readOnly = true)
	public QuizResponse getQuizInfo(Long quizId, Long userId) {
		Quiz quiz = quizRepository.findById(quizId)
			.orElseThrow(QuizNotFoundException::new);

		User user = userRepository.findByUserId(userId)
			.orElseThrow(UserNotFoundException::new);

		boolean isBookmarked = bookmarkRepository.existsByUserAndQuiz(user, quiz);
		boolean isSolved = userQuizAttemptRepository.existsByUserAndQuizAndIsCompletedTrue(user, quiz);

		return QuizResponse.from(quiz, isBookmarked, isSolved);
	}

	@Transactional(readOnly = true)
	public QuizReviewResponse getQuizReview(Long userId) {
		List<UserQuizAttempt> attempts = userQuizAttemptRepository.findByUser_userId(userId);

		List<ReviewQuizDetail> quizDetails = attempts.stream()
			.map(ReviewQuizDetail::from)
			.toList();

		return new QuizReviewResponse(
				!quizDetails.isEmpty(),
				quizDetails
		);
	}


	public void submitQuizResult(Long quizId, QuizSubmitRequest request, Long userId) {
		Quiz quiz = quizRepository.findById(quizId)
			.orElseThrow(QuizNotFoundException::new);

		User user = userRepository.findByUserId(userId)
				.orElseThrow(UserNotFoundException::new);

		UserQuizAttempt attempt = userQuizAttemptRepository
				.findByUserAndQuiz(user, quiz)
				.orElse(null);

		if (attempt != null) return ;

		if(request.isCorrect()){
			UserQuizAttempt userQuizCorrect = UserQuizAttempt.userQuizCorrect(user, quiz);
			userQuizAttemptRepository.save(userQuizCorrect);
		} else {
			UserQuizAttempt userQuizWrong = UserQuizAttempt.userQuizInCorrect(user, quiz);
			userQuizAttemptRepository.save(userQuizWrong);
		}
		quiz.updateCorrectRate(calculateAccuracyRate(quiz.getId()));

		quizRepository.save(quiz);
	}

	public BigDecimal calculateAccuracyRate(Long quizId) {
		long correctAttempts = userQuizAttemptRepository.countByQuizIdAndIsCorrectTrue(quizId);
		long totalAttempts = userQuizAttemptRepository.countByQuizId(quizId);

		if (totalAttempts == 0) {
			return BigDecimal.ZERO;
		}

		return BigDecimal.valueOf(correctAttempts)
				.divide(BigDecimal.valueOf(totalAttempts), 2, RoundingMode.HALF_UP)
				.multiply(BigDecimal.valueOf(100));
	}


}

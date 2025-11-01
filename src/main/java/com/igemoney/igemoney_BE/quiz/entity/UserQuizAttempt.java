package com.igemoney.igemoney_BE.quiz.entity;


import com.igemoney.igemoney_BE.common.entity.BaseEntity;
import com.igemoney.igemoney_BE.quiz.entity.enums.ReviewStep;
import com.igemoney.igemoney_BE.user.entity.User;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;


@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(uniqueConstraints = {
		@UniqueConstraint(
				name = "uk_user_quiz",
				columnNames = {"user_id", "quiz_id"}
		)
})
public class UserQuizAttempt extends BaseEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id", nullable = false)
	private User user;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "quiz_id", nullable = false)
	private Quiz quiz;

	@Column
	private LocalDate nextReviewDate;

	@Enumerated(EnumType.STRING)
	@Column
	private ReviewStep reviewStep;

	@Column
	private Boolean isCompleted;

	@Column(nullable = false)
	private Boolean isCorrect;


	@Builder
	private UserQuizAttempt(User user, Quiz quiz, LocalDate nextReviewDate, ReviewStep reviewStep, Boolean isCompleted, Boolean isCorrect) {
		this.user = user;
		this.quiz = quiz;
		this.nextReviewDate = nextReviewDate;
		this.reviewStep = reviewStep;
		this.isCompleted = isCompleted;
		this.isCorrect = isCorrect;
	}


	// 정답일 때 사용하는 생성자 팩토리 메서드
	public static UserQuizAttempt userQuizCorrect(User user, Quiz quiz) {
		return UserQuizAttempt.builder()
			.user(user)
			.quiz(quiz)
			.isCompleted(true)
			.isCorrect(true).build();
	}


	// 오답일 때 사용하는 생성자 팩토리 메서드
	public static UserQuizAttempt userQuizInCorrect(User user, Quiz quiz) {
		return UserQuizAttempt.builder()
			.user(user)
			.quiz(quiz)
			.nextReviewDate(LocalDate.now().plusDays(1))
			.reviewStep(ReviewStep.D1)
			.isCompleted(false)
			.isCorrect(false).build();
	}


	public void updateOnCorrectReview() {
		if (this.isCorrect || this.isCompleted) {
			throw new IllegalArgumentException("정답이거나 복습을 완료해 복습주기 업데이트 대상 퀴즈가 아닙니다.");
		}

		if (this.reviewStep == ReviewStep.D1) {
			this.reviewStep = ReviewStep.D4;
			this.nextReviewDate = LocalDate.now().plusDays(4);
		} else if (this.reviewStep == ReviewStep.D4) {
			this.reviewStep = ReviewStep.DONE;
			this.isCompleted = true;
			this.nextReviewDate = null;
		}
	}


	public void updateOnIncorrectReview() {
		if (this.isCorrect || this.isCompleted) {
			throw new IllegalArgumentException("정답이거나 복습을 완료해 복습주기 업데이트 대상 퀴즈가 아닙니다.");
		}

		if (this.reviewStep == ReviewStep.D1) {
			this.nextReviewDate = LocalDate.now().plusDays(1);
		} else if (this.reviewStep == ReviewStep.D4) {
			this.reviewStep = ReviewStep.D1;
			this.nextReviewDate = LocalDate.now().plusDays(1);
		}
	}

}

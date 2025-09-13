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
import java.time.ZoneId;


@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class UserQuizIncorrect extends BaseEntity {
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
	@Column(nullable = false, columnDefinition = "enum('D1','D4','DONE') default 'D1'")
	private ReviewStep reviewCycle;

	@Column(nullable = false, columnDefinition = "TINYINT(1) DEFAULT 0")
	private Boolean isCompleted;


	@Builder
	public UserQuizIncorrect(User user, Quiz quiz) {
		this.user = user;
		this.quiz = quiz;
		this.nextReviewDate = LocalDate.now().plusDays(1);
		this.reviewCycle = ReviewStep.D1;
		this.isCompleted = false;
	}


	public void updateOnCorrectReview() {
		if (this.isCompleted){
			return;
		}

		if (this.reviewCycle == ReviewStep.D1){
			this.reviewCycle = ReviewStep.D4;
			this.nextReviewDate = LocalDate.now().plusDays(4);
		} else if (this.reviewCycle == ReviewStep.D4){
			this.reviewCycle = ReviewStep.DONE;
			this.isCompleted = true;
			this.nextReviewDate = null;
		}
	}

	public void updateOnIncorrectReview() {
		if (this.isCompleted){
			return;
		}

		if (this.reviewCycle == ReviewStep.D1){
			this.nextReviewDate = LocalDate.now().plusDays(1);
		} else if (this.reviewCycle == ReviewStep.D4){
			this.reviewCycle = ReviewStep.D1;
			this.nextReviewDate = LocalDate.now().plusDays(1);
		}
	}

}

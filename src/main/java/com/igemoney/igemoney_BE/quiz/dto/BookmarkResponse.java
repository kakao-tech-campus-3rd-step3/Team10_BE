package com.igemoney.igemoney_BE.quiz.dto;

import com.igemoney.igemoney_BE.quiz.entity.Bookmark;

public record BookmarkResponse(
    Long quizId,
    String questionTitle,
    String questionTopic
) {
    public static BookmarkResponse of(Bookmark bookmark) {
        return new BookmarkResponse(
            bookmark.getId(),
            bookmark.getQuiz().getQuestionTitle(),
            bookmark.getQuiz().getTopic().getName()
        );
    }
}

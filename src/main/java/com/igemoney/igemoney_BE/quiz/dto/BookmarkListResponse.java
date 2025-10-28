package com.igemoney.igemoney_BE.quiz.dto;

import java.util.List;

public record BookmarkListResponse(
    List<BookmarkResponse> bookmarkedQuizzes
) {
    public static BookmarkListResponse of(List<BookmarkResponse> bookmarkResponses) {
        return new BookmarkListResponse(bookmarkResponses);
    }
}

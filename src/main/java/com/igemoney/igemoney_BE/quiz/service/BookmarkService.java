package com.igemoney.igemoney_BE.quiz.service;

import com.igemoney.igemoney_BE.common.exception.quiz.QuizNotFoundException;
import com.igemoney.igemoney_BE.common.exception.user.UserNotFoundException;
import com.igemoney.igemoney_BE.quiz.dto.BookmarkListResponse;
import com.igemoney.igemoney_BE.quiz.dto.BookmarkResponse;
import com.igemoney.igemoney_BE.quiz.entity.Bookmark;
import com.igemoney.igemoney_BE.quiz.entity.Quiz;
import com.igemoney.igemoney_BE.quiz.repository.BookmarkRepository;
import com.igemoney.igemoney_BE.quiz.repository.QuizRepository;
import com.igemoney.igemoney_BE.user.entity.User;
import com.igemoney.igemoney_BE.user.repository.UserRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class BookmarkService {
    private final BookmarkRepository bookmarkRepository;
    private final UserRepository userRepository;
    private final QuizRepository quizRepository;

    @Transactional
    public boolean toggleBookmark(Long userId, Long quizId) {
        long deleted = bookmarkRepository.deleteByUserUserIdAndQuizId(userId, quizId);
        if (deleted > 0) return false; // 이미 있었으니 삭제됨

        User user = userRepository.findById(userId)
            .orElseThrow(UserNotFoundException::new);

        Quiz quiz = quizRepository.findById(quizId)
            .orElseThrow(QuizNotFoundException::new);

        bookmarkRepository.save(Bookmark.builder()
                .user(user)
                .quiz(quiz)
                .build());
        return true;
    }

    @Transactional(readOnly = true)
    public BookmarkListResponse getBookmarkList(Long userId) {
        User user = userRepository.findById(userId)
            .orElseThrow(() -> new UserNotFoundException("존재하지 않는 유저입니다."));

        List<BookmarkResponse> items = bookmarkRepository.findAllByUserIdJoinWithQuiz(userId)
            .stream()
            .map(BookmarkResponse::of)
            .toList();

        return BookmarkListResponse.of(items);
    }
}

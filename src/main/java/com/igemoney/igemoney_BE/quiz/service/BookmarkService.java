package com.igemoney.igemoney_BE.quiz.service;

import com.igemoney.igemoney_BE.quiz.entity.Bookmark;
import com.igemoney.igemoney_BE.quiz.entity.Quiz;
import com.igemoney.igemoney_BE.quiz.repository.BookmarkRepository;
import com.igemoney.igemoney_BE.quiz.repository.QuizRepository;
import com.igemoney.igemoney_BE.user.entity.User;
import com.igemoney.igemoney_BE.user.repository.UserRepository;
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
    public boolean toggle(Long userId, Long quizId) {
        long deleted = bookmarkRepository.deleteByUserUserIdAndQuizId(userId, quizId);
        if (deleted > 0) return false; // 이미 있었으니 삭제됨

        User user = userRepository.getReferenceById(userId);
        Quiz quiz = quizRepository.getReferenceById(quizId);
        bookmarkRepository.save(Bookmark.builder()
                .user(user)
                .quiz(quiz)
                .build());
        return true;
    }
}
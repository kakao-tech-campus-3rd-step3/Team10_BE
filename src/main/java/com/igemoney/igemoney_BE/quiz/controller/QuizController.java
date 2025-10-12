package com.igemoney.igemoney_BE.quiz.controller;

import com.igemoney.igemoney_BE.attendance.service.AttendanceService;
import com.igemoney.igemoney_BE.common.annotation.Authenticated;
import com.igemoney.igemoney_BE.quiz.dto.QuizCreateRequest;
import com.igemoney.igemoney_BE.quiz.dto.QuizResponse;
import com.igemoney.igemoney_BE.quiz.dto.QuizReviewResponse;
import com.igemoney.igemoney_BE.quiz.dto.QuizSubmitRequest;
import com.igemoney.igemoney_BE.quiz.service.QuizService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/quiz")
@RequiredArgsConstructor
@Tag(name = "Quiz", description = "Quiz API")
public class QuizController {
    private final QuizService quizService;
    private final AttendanceService attendanceService;

    @PostMapping
    public QuizResponse createQuiz(@RequestBody QuizCreateRequest quiz){
        return quizService.createQuiz(quiz);
    }

    @DeleteMapping("/{id}")
    public void deleteQuiz(@PathVariable Long id) {
        quizService.deleteQuiz(id);
    }

    @GetMapping
    public List<QuizResponse> getAllQuizzes() {
        return quizService.getAll();
    }

    @GetMapping("/{id}")
    public QuizResponse getQuiz(@PathVariable Long id) {
        return quizService.getQuizInfo(id);
    }

    @Authenticated
    @PostMapping("/{id}/submit")
    public void submitQuizResult(@PathVariable Long id, @RequestBody QuizSubmitRequest request,
                                 @RequestAttribute Long userId) {
        quizService.submitQuizResult(id, request, userId);
        attendanceService.incrementTodaySolvedCount(userId);
    }

    @Authenticated
    @GetMapping("/review")
    public QuizReviewResponse getQuizReview(@RequestAttribute("userId") Long userId) {
        return quizService.getQuizReview(userId);
    }

}
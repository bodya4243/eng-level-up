package com.example.englevelup.service;

import com.example.englevelup.dto.internal.quiz.QuizDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface QuizService {
    QuizDto getQuiz(String quizFocus);

    QuizDto addQuiz(QuizDto quizDto);

    QuizDto updateQuiz(QuizDto dto);

    Page<QuizDto> getAllQuizzes(Pageable pageable);

    void deleteById(Long id);
}

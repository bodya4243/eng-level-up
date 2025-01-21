package com.example.englevelup.service;

import com.example.englevelup.dto.internal.quiz.QuizDto;

public interface QuizService {
    QuizDto getQuiz(String quizFocus);

    QuizDto addQuiz(QuizDto quizDto);
}

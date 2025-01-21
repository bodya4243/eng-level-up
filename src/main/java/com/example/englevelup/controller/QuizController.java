package com.example.englevelup.controller;

import com.example.englevelup.dto.internal.quiz.QuizDto;
import com.example.englevelup.service.QuizService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RequestMapping(value = "/quiz")
@RestController
public class QuizController {
    private final QuizService quizService;

    @GetMapping
    QuizDto getQuiz(@RequestParam String focus) {
        return quizService.getQuiz(focus);
    }

    @PostMapping
    QuizDto addQuiz(@RequestBody QuizDto quizDto) {
        return quizService.addQuiz(quizDto);
    }
}

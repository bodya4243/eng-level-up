package com.example.englevelup.controller;

import com.example.englevelup.dto.internal.quiz.QuizDto;
import com.example.englevelup.service.QuizService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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

    @GetMapping("/all")
    Page<QuizDto> getAllQuizzes(Pageable pageable) {
        return quizService.getAllQuizzes(pageable);
    }

    @PutMapping
    QuizDto updateById(@RequestBody QuizDto dto) {
        return quizService.updateQuiz(dto);
    }

    @DeleteMapping("/{id}")
    void deleteById(@PathVariable Long id) {
        quizService.deleteById(id);
    }
}

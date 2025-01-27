package com.example.englevelup.service;

import com.example.englevelup.dto.internal.quiz.QuizDto;
import com.example.englevelup.mapper.QuizMapper;
import com.example.englevelup.model.quiz.Quiz;
import com.example.englevelup.repository.QuizRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class QuizServiceImpl implements QuizService {
    private final QuizRepository quizRepository;
    private final QuizMapper quizMapper;

    @Override
    public QuizDto getQuiz(String quizFocus) {
        return quizMapper.toDto(quizRepository.findByFocus(quizFocus));
    }

    @Override
    public QuizDto addQuiz(QuizDto quizDto) {
        Quiz quiz = quizMapper.toModel(quizDto);

        quizDto.getQuestions().forEach(question -> question.setQuiz(quiz));

        return quizMapper.toDto(quizRepository.save(quiz));
    }
}

package com.example.englevelup.service;

import com.example.englevelup.dto.internal.quiz.QuizDto;
import com.example.englevelup.mapper.QuizMapper;
import com.example.englevelup.model.quiz.Question;
import com.example.englevelup.model.quiz.Quiz;
import com.example.englevelup.repository.QuestionRepository;
import com.example.englevelup.repository.QuizRepository;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class QuizServiceImpl implements QuizService {
    private final QuizRepository quizRepository;
    private final QuizMapper quizMapper;
    private final QuestionRepository questionRepository;

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

    @Override
    public Page<QuizDto> getAllQuizzes(Pageable pageable) {
        Page<Quiz> quizzes = quizRepository.findAll(pageable);

        return quizzes.map(quizMapper::toDto);
    }

    @Override
    public void deleteById(Long id) {
        quizRepository.deleteById(id);
    }

    @Override
    public QuizDto updateQuiz(QuizDto dto) {
        Quiz quiz = quizRepository.findById(dto.getId()).orElseThrow(()
                -> new RuntimeException("Cannot find quiz by id: " + dto.getId()));

        quiz.setFocus(dto.getFocus());
        quiz.setTitle(dto.getTitle());
        updateQuestions(quiz, dto);

        return quizMapper.toDto(quizRepository.save(quiz));
    }

    private void updateQuestions(Quiz quiz, QuizDto dto) {
        List<Long> ids = dto.getQuestions().stream().map(Question::getId).toList();

        List<Question> questions = questionRepository.findAllById(ids);

        Map<Long, Question> dtoMap = dto.getQuestions().stream()
                .collect(Collectors.toMap(Question::getId, question -> question));

        for (Question question : questions) {
            Question currentDtoQuestion = dtoMap.get(question.getId());

            question.setQuiz(quiz);
            question.setQuestion(currentDtoQuestion.getQuestion());
            question.setOptions(currentDtoQuestion.getOptions());
            question.setCorrectAnswer(currentDtoQuestion.getCorrectAnswer());
        }

        questionRepository.saveAll(questions);
    }
}

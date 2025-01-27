package com.example.englevelup.mapper;

import com.example.englevelup.config.MapperConfig;
import com.example.englevelup.dto.internal.quiz.QuizDto;
import com.example.englevelup.model.quiz.Quiz;
import org.mapstruct.Mapper;

@Mapper(config = MapperConfig.class)
public interface QuizMapper {
    QuizDto toDto(Quiz quiz);

    Quiz toModel(QuizDto quizDto);
}

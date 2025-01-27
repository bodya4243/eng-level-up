package com.example.englevelup.dto.internal.quiz;

import com.example.englevelup.model.quiz.Question;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class QuizDto {
    private String title;
    private String focus;
    private List<Question> questions;
}


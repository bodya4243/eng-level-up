package com.example.englevelup.dto.internal.reading;

import com.example.englevelup.model.EnglishLevel;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ReadingDto {
    private Long id;
    private String title;
    private String description;
    private String content;
    private EnglishLevel level;
}

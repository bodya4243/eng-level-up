package com.example.englevelup.dto.internal.listening;

import com.example.englevelup.model.EnglishLevel;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ListeningDto {
    private String title;
    private String description;
    private EnglishLevel level;
    private String filePath;
}

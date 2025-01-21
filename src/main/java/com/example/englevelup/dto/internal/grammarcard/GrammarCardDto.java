package com.example.englevelup.dto.internal.grammarcard;

import com.example.englevelup.model.EnglishLevel;
import com.example.englevelup.model.grammarcard.GrammarCardContent;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GrammarCardDto {
    private EnglishLevel level;
    private String title;
    private String description;
    private List<GrammarCardContent> content;
}

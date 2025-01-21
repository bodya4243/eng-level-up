package com.example.englevelup.service;

import com.example.englevelup.dto.internal.grammarcard.GrammarCardDto;
import com.example.englevelup.model.EnglishLevel;
import java.util.List;

public interface GrammarCardService {
    GrammarCardDto addCard(GrammarCardDto grammarCardDto);

    List<GrammarCardDto> getCardByLevel(EnglishLevel englishLevel);
}

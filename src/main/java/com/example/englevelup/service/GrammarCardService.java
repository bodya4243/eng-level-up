package com.example.englevelup.service;

import com.example.englevelup.dto.internal.grammarcard.GrammarCardDto;
import com.example.englevelup.model.EnglishLevel;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface GrammarCardService {
    GrammarCardDto addCard(GrammarCardDto grammarCardDto);

    List<GrammarCardDto> getCardByLevel(EnglishLevel englishLevel);

    Page<GrammarCardDto> getAllCards(Pageable pageable);

    GrammarCardDto updateById(Long id, GrammarCardDto dto);

    void deleteById(Long id);
}

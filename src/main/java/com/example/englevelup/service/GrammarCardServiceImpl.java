package com.example.englevelup.service;

import com.example.englevelup.dto.internal.grammarcard.GrammarCardDto;
import com.example.englevelup.mapper.GrammarCardMapper;
import com.example.englevelup.model.EnglishLevel;
import com.example.englevelup.model.grammarcard.GrammarCard;
import com.example.englevelup.repository.GrammarCardRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class GrammarCardServiceImpl implements GrammarCardService {
    private final GrammarCardRepository grammarCardRepository;
    private final GrammarCardMapper grammarCardMapper;

    @Override
    public GrammarCardDto addCard(GrammarCardDto grammarCardDto) {
        GrammarCard grammarCard = grammarCardMapper.toModel(grammarCardDto);

        grammarCard.getContent().forEach(item -> item.setGrammarCard(grammarCard));

        grammarCardRepository.save(grammarCard);
        return grammarCardMapper.toDto(grammarCard);
    }

    @Override
    public List<GrammarCardDto> getCardByLevel(EnglishLevel englishLevel) {
        List<GrammarCard> grammarCards = grammarCardRepository
                .findAllByLevelWithContent(englishLevel);

        return grammarCards.stream()
                .map(grammarCardMapper::toDto)
                .toList();
    }
}

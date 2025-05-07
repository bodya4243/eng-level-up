package com.example.englevelup.service;

import com.example.englevelup.dto.internal.grammarcard.GrammarCardDto;
import com.example.englevelup.mapper.GrammarCardMapper;
import com.example.englevelup.model.EnglishLevel;
import com.example.englevelup.model.grammarcard.GrammarCard;
import com.example.englevelup.model.grammarcard.GrammarCardContent;
import com.example.englevelup.repository.CardContentRepository;
import com.example.englevelup.repository.GrammarCardRepository;
import java.util.ArrayList;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class GrammarCardServiceImpl implements GrammarCardService {
    private final GrammarCardRepository grammarCardRepository;
    private final GrammarCardMapper grammarCardMapper;
    private final CardContentRepository cardContentRepository;

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

    @Override
    public Page<GrammarCardDto> getAllCards(Pageable pageable) {
        Page<GrammarCard> cards = grammarCardRepository.findAll(pageable);

        return cards.map(grammarCardMapper::toDto);
    }

    @Override
    public GrammarCardDto updateById(Long id, GrammarCardDto dto) {
        GrammarCard grammarCard = grammarCardRepository.findByIdWithContent(id)
                .orElseThrow(() -> new RuntimeException("Cannot find grammarCard by id: " + id));

        grammarCard.setDescription(dto.getDescription());
        grammarCard.setTitle(dto.getTitle());
        grammarCard.setLevel(dto.getLevel());

        updateContent(dto, grammarCard);

        grammarCardRepository.save(grammarCard);

        return grammarCardMapper.toDto(grammarCard);
    }

    @Override
    public void deleteById(Long id) {
        grammarCardRepository.deleteById(id);
    }

    private void updateContent(GrammarCardDto dto, GrammarCard grammarCard) {
        if (grammarCard.getContent().isEmpty()) {
            List<GrammarCardContent> contentToSave = dto.getContent();

            contentToSave.forEach(e -> e.setGrammarCard(grammarCard));

            for (int i = 0; i < dto.getContent().size(); i++) {
                cardContentRepository.save(contentToSave.get(i));
            }
        }

        List<GrammarCardContent> content = new ArrayList<>();

        List<Long> contentToUpdate = new ArrayList<>();
        dto.getContent().forEach(e -> contentToUpdate.add(e.getId()));

        for (Long id : contentToUpdate) {
            content.add(cardContentRepository.findById(id).orElseThrow(()
                    -> new RuntimeException("Cannot find content")));
        }

        for (int i = 0; i < content.size(); i++) {
            content.get(i).setGrammarCard(grammarCard);
            content.get(i).setTitle(dto.getContent().get(i).getTitle());
            content.get(i).setDescription(dto.getContent().get(i).getDescription());
            content.get(i).setContent(dto.getContent().get(i).getContent());
        }

        grammarCard.setContent(content);
    }
}

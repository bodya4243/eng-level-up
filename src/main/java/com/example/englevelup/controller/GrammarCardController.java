package com.example.englevelup.controller;

import com.example.englevelup.dto.internal.grammarcard.GrammarCardDto;
import com.example.englevelup.model.EnglishLevel;
import com.example.englevelup.service.GrammarCardService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RequestMapping(value = "/grammar-card")
@RestController
public class GrammarCardController {
    private final GrammarCardService grammarCardService;

    @GetMapping
    List<GrammarCardDto> grammarCard(EnglishLevel englishLevel) {
        return grammarCardService.getCardByLevel(englishLevel);
    }

    @PostMapping
    GrammarCardDto addGrammarCard(@RequestBody GrammarCardDto grammarCardDto) {
        return grammarCardService.addCard(grammarCardDto);
    }

    @GetMapping("/all")
    Page<GrammarCardDto> getAllCards(Pageable pageable) {
        return grammarCardService.getAllCards(pageable);
    }

    @PutMapping("/{id}")
    GrammarCardDto updateById(@PathVariable Long id,
                              @RequestBody GrammarCardDto dto) {
        return grammarCardService.updateById(id, dto);
    }

    @DeleteMapping("/{id}")
    void deleteById(@PathVariable Long id) {
        grammarCardService.deleteById(id);
    }
}

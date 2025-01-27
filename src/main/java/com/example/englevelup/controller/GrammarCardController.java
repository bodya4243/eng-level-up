package com.example.englevelup.controller;

import com.example.englevelup.dto.internal.grammarcard.GrammarCardDto;
import com.example.englevelup.model.EnglishLevel;
import com.example.englevelup.service.GrammarCardService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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
}

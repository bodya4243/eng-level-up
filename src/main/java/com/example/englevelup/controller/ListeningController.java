package com.example.englevelup.controller;

import com.example.englevelup.dto.internal.listening.ListeningDto;
import com.example.englevelup.model.EnglishLevel;
import com.example.englevelup.service.ListeningService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RequestMapping(value = "/listening")
@RestController
public class ListeningController {
    private final ListeningService listeningService;

    @PostMapping
    ListeningDto addListening(@RequestBody ListeningDto listeningDto) {
        return listeningService.addListening(listeningDto);
    }

    @GetMapping
    List<ListeningDto> getListeningByLevel(@RequestParam("level") EnglishLevel englishLevel) {
        return listeningService.getListeningByLevel(englishLevel);
    }
}

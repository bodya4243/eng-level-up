package com.example.englevelup.service;

import com.example.englevelup.dto.internal.listening.ListeningDto;
import com.example.englevelup.model.EnglishLevel;
import java.util.List;

public interface ListeningService {
    ListeningDto addListening(ListeningDto listeningDto);

    List<ListeningDto> getListeningByLevel(EnglishLevel englishLevel);
}

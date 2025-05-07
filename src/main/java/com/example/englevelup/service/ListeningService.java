package com.example.englevelup.service;

import com.example.englevelup.dto.internal.listening.ListeningDto;
import com.example.englevelup.model.EnglishLevel;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ListeningService {
    ListeningDto addListening(ListeningDto listeningDto);

    List<ListeningDto> getListeningByLevel(EnglishLevel englishLevel);

    Page<ListeningDto> getAllListening(Pageable pageable);

    List<ListeningDto> updateListening(List<ListeningDto> dtos);

    void deleteById(Long id);
}

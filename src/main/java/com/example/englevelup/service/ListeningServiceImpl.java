package com.example.englevelup.service;

import com.example.englevelup.dto.internal.listening.ListeningDto;
import com.example.englevelup.mapper.ListeningMapper;
import com.example.englevelup.model.EnglishLevel;
import com.example.englevelup.model.listening.Listening;
import com.example.englevelup.repository.ListeningRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class ListeningServiceImpl implements ListeningService {
    private final ListeningRepository listeningRepository;
    private final ListeningMapper listeningMapper;

    @Override
    public ListeningDto addListening(ListeningDto listeningDto) {
        Listening listening = listeningMapper.toModel(listeningDto);
        listeningRepository.save(listening);

        return listeningMapper.toDto(listening);
    }

    @Override
    public List<ListeningDto> getListeningByLevel(EnglishLevel englishLevel) {

        return listeningRepository.findAllByLevel(englishLevel).stream()
                .map(listeningMapper::toDto)
                .toList();
    }
}

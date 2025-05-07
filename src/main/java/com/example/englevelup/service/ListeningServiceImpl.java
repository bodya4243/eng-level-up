package com.example.englevelup.service;

import com.example.englevelup.dto.internal.listening.ListeningDto;
import com.example.englevelup.mapper.ListeningMapper;
import com.example.englevelup.model.EnglishLevel;
import com.example.englevelup.model.listening.Listening;
import com.example.englevelup.repository.ListeningRepository;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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

    @Override
    public Page<ListeningDto> getAllListening(Pageable pageable) {
        Page<Listening> listenings = listeningRepository.findAll(pageable);

        return listenings.map(listeningMapper::toDto);
    }

    @Override
    public List<ListeningDto> updateListening(List<ListeningDto> dtos) {
        List<Long> ids = dtos.stream().map(ListeningDto::getId).toList();
        List<Listening> listenings = listeningRepository.findAllById(ids);

        Map<Long, ListeningDto> dtoMap = dtos.stream()
                .collect(Collectors.toMap(ListeningDto::getId, Function.identity()));

        for (Listening listening : listenings) {
            ListeningDto currentDto = dtoMap.get(listening.getId());
            listening.setTitle(currentDto.getTitle());
            listening.setDescription(currentDto.getDescription());
            listening.setFilePath(currentDto.getFilePath());
            listening.setLevel(currentDto.getLevel());
        }

        listeningRepository.saveAll(listenings);

        return listenings.stream().map(listeningMapper::toDto).toList();
    }

    @Override
    public void deleteById(Long id) {
        listeningRepository.deleteById(id);
    }
}

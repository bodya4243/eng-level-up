package com.example.englevelup.service;

import com.example.englevelup.dto.internal.essay.EssayDto;
import com.example.englevelup.mapper.EssayMapper;
import com.example.englevelup.model.EnglishLevel;
import com.example.englevelup.model.writing.Essay;
import com.example.englevelup.repository.EssayRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class EssayServiceImpl implements EssayService {
    private final EssayRepository essayRepository;
    private final EssayMapper essayMapper;

    @Override
    public EssayDto addEssay(EssayDto essayDto) {
        Essay essay = essayMapper.toModel(essayDto);
        essayRepository.save(essay);

        return essayMapper.toDto(essay);
    }

    @Override
    public List<EssayDto> getEssayByLevel(EnglishLevel englishLevel) {
        return essayRepository.findAllByLevel(englishLevel).stream()
                .map(essayMapper::toDto)
                .toList();
    }
}

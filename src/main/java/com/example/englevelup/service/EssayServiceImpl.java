package com.example.englevelup.service;

import com.example.englevelup.dto.internal.essay.EssayDto;
import com.example.englevelup.mapper.EssayMapper;
import com.example.englevelup.model.EnglishLevel;
import com.example.englevelup.model.writing.Essay;
import com.example.englevelup.repository.EssayRepository;
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

    @Override
    public List<EssayDto> updateById(List<EssayDto> dtos) {
        List<Long> ids = dtos.stream().map(EssayDto::getId).toList();
        List<Essay> essays = essayRepository.findAllById(ids);

        Map<Long, EssayDto> dtoMap = dtos.stream()
                .collect(Collectors.toMap(EssayDto::getId, Function.identity()));

        for (Essay essay : essays) {
            EssayDto currentDto = dtoMap.get(essay.getId());
            essay.setLevel(currentDto.getLevel());
            essay.setTitle(currentDto.getTitle());
        }

        essayRepository.saveAll(essays);

        return essays.stream().map(essayMapper::toDto).toList();
    }

    @Override
    public Page<EssayDto> getAllEssays(Pageable pageable) {
        Page<Essay> essays = essayRepository.findAll(pageable);

        return essays.map(essayMapper::toDto);
    }

    @Override
    public void deleteById(Long id) {
        essayRepository.deleteById(id);
    }
}

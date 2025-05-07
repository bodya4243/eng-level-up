package com.example.englevelup.service;

import com.example.englevelup.dto.internal.reading.ReadingDto;
import com.example.englevelup.mapper.ReadingMapper;
import com.example.englevelup.model.EnglishLevel;
import com.example.englevelup.model.Reading;
import com.example.englevelup.repository.ReadingRepository;
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
public class ReadingServiceImpl implements ReadingService {
    private final ReadingRepository readingRepository;
    private final ReadingMapper readingMapper;

    @Override
    public List<ReadingDto> getReadingTask(EnglishLevel level) {
        return readingRepository.findAllByLevel(level).stream()
                .map(readingMapper::toDto)
                .toList();
    }

    @Override
    public ReadingDto addReadingTask(ReadingDto readingDto) {
        Reading reading = readingMapper.toModel(readingDto);

        return readingMapper.toDto(readingRepository.save(reading));
    }

    @Override
    public Page<ReadingDto> getAllReadingTasks(Pageable pageable) {
        Page<Reading> readingTasks = readingRepository.findAll(pageable);

        return readingTasks.map(readingMapper::toDto);
    }

    @Override
    public List<ReadingDto> updateAll(List<ReadingDto> dtos) {
        List<Long> ids = dtos.stream().map(ReadingDto::getId).toList();
        List<Reading> readingTasks = readingRepository.findAllById(ids);

        Map<Long, ReadingDto> dtoMap = dtos.stream()
                .collect(Collectors.toMap(ReadingDto::getId, Function.identity()));

        for (Reading reading : readingTasks) {
            ReadingDto currentDto = dtoMap.get(reading.getId());
            reading.setTitle(currentDto.getTitle());
            reading.setDescription(currentDto.getDescription());
            reading.setContent(currentDto.getContent());
            reading.setLevel(currentDto.getLevel());
        }

        readingRepository.saveAll(readingTasks);

        return readingTasks.stream().map(readingMapper::toDto).toList();
    }

    @Override
    public void deleteById(Long id) {
        readingRepository.deleteById(id);
    }
}

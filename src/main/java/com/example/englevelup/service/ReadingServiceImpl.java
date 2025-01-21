package com.example.englevelup.service;

import com.example.englevelup.dto.internal.reading.ReadingDto;
import com.example.englevelup.mapper.ReadingMapper;
import com.example.englevelup.model.EnglishLevel;
import com.example.englevelup.model.Reading;
import com.example.englevelup.repository.ReadingRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
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
        readingRepository.save(reading);

        return readingMapper.toDto(reading);
    }
}

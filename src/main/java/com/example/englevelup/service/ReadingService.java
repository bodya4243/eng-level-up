package com.example.englevelup.service;

import com.example.englevelup.dto.internal.reading.ReadingDto;
import com.example.englevelup.model.EnglishLevel;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ReadingService {
    List<ReadingDto> getReadingTask(EnglishLevel level);

    ReadingDto addReadingTask(ReadingDto readingDto);

    Page<ReadingDto> getAllReadingTasks(Pageable pageable);

    List<ReadingDto> updateAll(List<ReadingDto> dtos);

    void deleteById(Long id);
}

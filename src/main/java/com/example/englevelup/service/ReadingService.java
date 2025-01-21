package com.example.englevelup.service;

import com.example.englevelup.dto.internal.reading.ReadingDto;
import com.example.englevelup.model.EnglishLevel;
import java.util.List;

public interface ReadingService {
    List<ReadingDto> getReadingTask(EnglishLevel level);

    ReadingDto addReadingTask(ReadingDto readingDto);
}

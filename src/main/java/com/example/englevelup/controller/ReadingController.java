package com.example.englevelup.controller;

import com.example.englevelup.dto.internal.reading.ReadingDto;
import com.example.englevelup.model.EnglishLevel;
import com.example.englevelup.service.ReadingService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RequestMapping(value = "/reading")
@RestController
public class ReadingController {
    private final ReadingService readingService;

    @GetMapping
    public List<ReadingDto> getReadingTask(@RequestParam("level") EnglishLevel level) {
        return readingService.getReadingTask(level);
    }

    @PostMapping
    public ReadingDto addReadingTask(@RequestBody ReadingDto readingDto) {
        return readingService.addReadingTask(readingDto);
    }
}

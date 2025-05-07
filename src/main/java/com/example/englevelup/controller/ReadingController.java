package com.example.englevelup.controller;

import com.example.englevelup.dto.internal.reading.ReadingDto;
import com.example.englevelup.model.EnglishLevel;
import com.example.englevelup.service.ReadingService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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

    @GetMapping("/all")
    public Page<ReadingDto> getAllReadingTasks(Pageable pageable) {
        return readingService.getAllReadingTasks(pageable);
    }

    @PutMapping()
    List<ReadingDto> updateAll(@RequestBody List<ReadingDto> dtos) {
        return readingService.updateAll(dtos);
    }

    @DeleteMapping("/{id}")
    void deleteById(@PathVariable Long id) {
        readingService.deleteById(id);
    }
}

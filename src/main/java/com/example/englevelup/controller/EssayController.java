package com.example.englevelup.controller;

import com.example.englevelup.dto.internal.essay.EssayDto;
import com.example.englevelup.model.EnglishLevel;
import com.example.englevelup.service.EssayService;
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
@RequestMapping(value = "/essay")
@RestController
public class EssayController {
    private final EssayService essayService;

    @PostMapping
    EssayDto addEssay(@RequestBody EssayDto essayDto) {
        return essayService.addEssay(essayDto);
    }

    @GetMapping
    List<EssayDto> getAllByLevel(@RequestParam("level") EnglishLevel englishLevel) {
        return essayService.getEssayByLevel(englishLevel);
    }

    @PutMapping()
    List<EssayDto> updateById(@RequestBody List<EssayDto> essayDtos) {
        return essayService.updateById(essayDtos);
    }

    @GetMapping("/all")
    Page<EssayDto> getAllEssays(Pageable pageable) {
        return essayService.getAllEssays(pageable);
    }

    @DeleteMapping("/{id}")
    void deleteById(@PathVariable Long id) {
        essayService.deleteById(id);
    }
}

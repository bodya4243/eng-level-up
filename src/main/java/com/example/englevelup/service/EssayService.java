package com.example.englevelup.service;

import com.example.englevelup.dto.internal.essay.EssayDto;
import com.example.englevelup.model.EnglishLevel;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface EssayService {
    EssayDto addEssay(EssayDto essay);

    List<EssayDto> getEssayByLevel(EnglishLevel englishLevel);

    List<EssayDto> updateById(List<EssayDto> dto);

    Page<EssayDto> getAllEssays(Pageable pageable);

    void deleteById(Long id);
}

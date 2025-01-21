package com.example.englevelup.service;

import com.example.englevelup.dto.internal.essay.EssayDto;
import com.example.englevelup.model.EnglishLevel;
import java.util.List;

public interface EssayService {
    EssayDto addEssay(EssayDto essay);

    List<EssayDto> getEssayByLevel(EnglishLevel englishLevel);
}

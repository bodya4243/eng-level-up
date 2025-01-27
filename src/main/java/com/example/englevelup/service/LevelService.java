package com.example.englevelup.service;

import com.example.englevelup.dto.internal.level.LevelResponseDto;
import com.example.englevelup.mapper.LevelMapper;
import com.example.englevelup.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class LevelService {

    private final LevelMapper levelMapper;

    public LevelResponseDto getLevel(User user) {
        return levelMapper.toDto(user);
    }
}

package com.example.englevelup.service;

import com.example.englevelup.dto.internal.level.LevelResponseDto;
import com.example.englevelup.dto.internal.user.UserRequestDto;
import com.example.englevelup.dto.internal.user.UserResponseDto;
import com.example.englevelup.model.EnglishLevel;
import com.example.englevelup.model.User;

public interface UserService {
    UserResponseDto register(UserRequestDto userRequestDto);

    LevelResponseDto updateLevel(User user, EnglishLevel englishLevel);
}

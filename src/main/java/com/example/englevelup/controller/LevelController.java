package com.example.englevelup.controller;

import com.example.englevelup.dto.internal.level.LevelResponseDto;
import com.example.englevelup.model.EnglishLevel;
import com.example.englevelup.model.User;
import com.example.englevelup.service.LevelService;
import com.example.englevelup.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RequestMapping(value = "/level")
@RestController
public class LevelController {

    private final UserService userService;
    private final LevelService levelService;

    @PutMapping
    LevelResponseDto updateEngLevel(
            @RequestParam("level") EnglishLevel englishLevel,
            @AuthenticationPrincipal User user
    ) {
        return userService.updateLevel(user, englishLevel);
    }

    @GetMapping
    LevelResponseDto getLevel(@AuthenticationPrincipal User user) {
        return levelService.getLevel(user);
    }
}

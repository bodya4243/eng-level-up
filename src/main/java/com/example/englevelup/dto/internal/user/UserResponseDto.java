package com.example.englevelup.dto.internal.user;

import com.example.englevelup.model.EnglishLevel;
import lombok.Data;

@Data
public class UserResponseDto {
    private Long id;
    private String fullName;
    private String email;
    private EnglishLevel level;
}

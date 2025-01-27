package com.example.englevelup.mapper;

import com.example.englevelup.config.MapperConfig;
import com.example.englevelup.dto.internal.level.LevelResponseDto;
import com.example.englevelup.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(config = MapperConfig.class)
public interface LevelMapper {
    @Mapping(target = "level", source = "level")
    LevelResponseDto toDto(User user);
}

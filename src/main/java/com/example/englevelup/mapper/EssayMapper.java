package com.example.englevelup.mapper;

import com.example.englevelup.config.MapperConfig;
import com.example.englevelup.dto.internal.essay.EssayDto;
import com.example.englevelup.model.writing.Essay;
import org.mapstruct.Mapper;

@Mapper(config = MapperConfig.class)
public interface EssayMapper {
    EssayDto toDto(Essay essay);

    Essay toModel(EssayDto essayDto);
}

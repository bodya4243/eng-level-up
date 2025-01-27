package com.example.englevelup.mapper;

import com.example.englevelup.config.MapperConfig;
import com.example.englevelup.dto.internal.reading.ReadingDto;
import com.example.englevelup.model.Reading;
import org.mapstruct.Mapper;

@Mapper(config = MapperConfig.class)
public interface ReadingMapper {
    ReadingDto toDto(Reading reading);

    Reading toModel(ReadingDto readingDto);
}

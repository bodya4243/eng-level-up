package com.example.englevelup.mapper;

import com.example.englevelup.config.MapperConfig;
import com.example.englevelup.dto.internal.listening.ListeningDto;
import com.example.englevelup.model.listening.Listening;
import org.mapstruct.Mapper;

@Mapper(config = MapperConfig.class)
public interface ListeningMapper {
    ListeningDto toDto(Listening listening);

    Listening toModel(ListeningDto listeningDto);
}

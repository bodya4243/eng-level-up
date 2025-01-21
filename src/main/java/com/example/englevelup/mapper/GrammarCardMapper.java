package com.example.englevelup.mapper;

import com.example.englevelup.config.MapperConfig;
import com.example.englevelup.dto.internal.grammarcard.GrammarCardDto;
import com.example.englevelup.model.grammarcard.GrammarCard;
import org.mapstruct.Mapper;

@Mapper(config = MapperConfig.class)
public interface GrammarCardMapper {
    GrammarCardDto toDto(GrammarCard grammarCard);

    GrammarCard toModel(GrammarCardDto grammarCardDto);
}

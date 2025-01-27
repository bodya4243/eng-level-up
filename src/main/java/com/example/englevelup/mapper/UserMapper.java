package com.example.englevelup.mapper;

import com.example.englevelup.config.MapperConfig;
import com.example.englevelup.dto.internal.user.UserRequestDto;
import com.example.englevelup.dto.internal.user.UserResponseDto;
import com.example.englevelup.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(config = MapperConfig.class)
public interface UserMapper {
    User toModel(UserRequestDto userRequestDto);

    @Mapping(target = "level", source = "level")
    UserResponseDto toDto(User user);
}

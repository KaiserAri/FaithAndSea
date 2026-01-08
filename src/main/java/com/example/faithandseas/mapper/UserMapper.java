package com.example.faithandseas.mapper;

import com.example.faithandseas.dto.UserDto;
import com.example.faithandseas.entity.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserDto toDto(User user);
    User toEntity(UserDto userDto);
}
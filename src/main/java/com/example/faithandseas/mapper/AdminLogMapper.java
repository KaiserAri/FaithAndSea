package com.example.faithandseas.mapper;

import com.example.faithandseas.dto.AdminLogDto;
import com.example.faithandseas.entity.AdminLog;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {UserMapper.class})
public interface AdminLogMapper {
    @Mapping(source = "admin", target = "admin") // Ánh xạ User sang UserDto
    AdminLogDto toDto(AdminLog adminLog);
    @Mapping(source = "admin", target = "admin")
    AdminLog toEntity(AdminLogDto adminLogDto);
}
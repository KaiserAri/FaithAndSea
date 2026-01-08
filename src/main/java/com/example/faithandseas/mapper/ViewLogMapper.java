package com.example.faithandseas.mapper;

import com.example.faithandseas.dto.ViewLogDto;
import com.example.faithandseas.entity.ViewLog;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {PostMapper.class, ArtworkMapper.class})
public interface ViewLogMapper {
    ViewLogDto toDto(ViewLog viewLog);
    ViewLog toEntity(ViewLogDto viewLogDto);
}
package com.example.faithandseas.mapper;

import com.example.faithandseas.dto.ShareLogDto;
import com.example.faithandseas.entity.ShareLog;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {UserMapper.class, PostMapper.class, ArtworkMapper.class})
public interface ShareLogMapper {
    ShareLogDto toDto(ShareLog shareLog);
    ShareLog toEntity(ShareLogDto shareLogDto);
}

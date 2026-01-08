package com.example.faithandseas.mapper;

import com.example.faithandseas.dto.LikeDto;
import com.example.faithandseas.entity.Like;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {UserMapper.class, PostMapper.class, ArtworkMapper.class})
public interface LikeMapper {
    LikeDto toDto(Like like);
    Like toEntity(LikeDto likeDto);
}
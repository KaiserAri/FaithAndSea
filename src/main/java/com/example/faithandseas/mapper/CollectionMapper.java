package com.example.faithandseas.mapper;

import com.example.faithandseas.dto.CollectionDto;
import com.example.faithandseas.entity.Collection;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {ArtworkMapper.class})
public interface CollectionMapper {
    CollectionDto toDto(Collection collection);
    Collection toEntity(CollectionDto collectionDto);
}
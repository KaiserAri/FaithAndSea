package com.example.faithandseas.mapper;

import com.example.faithandseas.dto.ArtworkDto;
import com.example.faithandseas.entity.Artwork;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {ArtistMapper.class})
public interface ArtworkMapper {
    ArtworkDto toDto(Artwork artwork);
    Artwork toEntity(ArtworkDto artworkDto);
}
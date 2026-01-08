package com.example.faithandseas.mapper;

import com.example.faithandseas.dto.ArtistDto;
import com.example.faithandseas.entity.Artist;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {ArtworkMapper.class})
public interface ArtistMapper {
    ArtistDto toDto(Artist artist);
    Artist toEntity(ArtistDto artistDto);
}
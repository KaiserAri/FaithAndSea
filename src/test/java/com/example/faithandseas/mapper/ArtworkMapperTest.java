package com.example.faithandseas.mapper;

import com.example.faithandseas.dto.ArtworkDto;
import com.example.faithandseas.entity.Artwork;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

import static org.assertj.core.api.Assertions.assertThat;

class ArtworkMapperTest {

    private final ArtworkMapper mapper =
            Mappers.getMapper(ArtworkMapper.class);

    @Test
    void toDto_shouldMapBasicFields() {
        // given
        Artwork artwork = new Artwork();
        artwork.setId(1L);
        artwork.setTitle("Test Artwork");

        // when
        ArtworkDto dto = mapper.toDto(artwork);

        // then
        assertThat(dto).isNotNull();
        assertThat(dto.getId()).isEqualTo(1L);
        assertThat(dto.getTitle()).isEqualTo("Test Artwork");
    }
}

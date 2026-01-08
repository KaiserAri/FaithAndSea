package com.example.faithandseas.mapper;

import com.example.faithandseas.dto.ArtistDto;
import com.example.faithandseas.entity.Artist;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

import static org.assertj.core.api.Assertions.assertThat;

class ArtistMapperTest {

    private final ArtistMapper mapper =
            Mappers.getMapper(ArtistMapper.class);

    @Test
    void toDto_shouldMapBasicFields() {
        // given
        Artist artist = new Artist();
        artist.setId(1L);
        artist.setName("Test Artist");

        // when
        ArtistDto dto = mapper.toDto(artist);

        // then
        assertThat(dto).isNotNull();
        assertThat(dto.getId()).isEqualTo(1L);
        assertThat(dto.getName()).isEqualTo("Test Artist");
    }
}

package com.example.faithandseas.dto;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ArtistDtoTest {

    @Test
    void shouldSetAndGetFields() {
        ArtistDto dto = new ArtistDto();
        dto.setId(1L);
        dto.setName("Test Artist");

        assertThat(dto.getId()).isEqualTo(1L);
        assertThat(dto.getName()).isEqualTo("Test Artist");
    }
}

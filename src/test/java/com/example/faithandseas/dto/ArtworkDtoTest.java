package com.example.faithandseas.dto;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ArtworkDtoTest {

    @Test
    void shouldSetAndGetFields() {
        ArtworkDto dto = new ArtworkDto();
        dto.setId(1L);
        dto.setTitle("Test Artwork");

        assertThat(dto.getId()).isEqualTo(1L);
        assertThat(dto.getTitle()).isEqualTo("Test Artwork");
    }
}

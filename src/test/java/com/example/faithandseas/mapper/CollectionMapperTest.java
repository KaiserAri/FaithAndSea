package com.example.faithandseas.mapper;

import com.example.faithandseas.dto.CollectionDto;
import com.example.faithandseas.entity.Collection;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;


import static org.assertj.core.api.Assertions.assertThat;

class CollectionMapperTest {

    private final CollectionMapper mapper =
            Mappers.getMapper(CollectionMapper.class);

    @Test
    void toDto_shouldMapBasicFields() {
        Collection c = Collection.builder()
                .id(1L)
                .title("Test")
                .build();

        CollectionDto dto = mapper.toDto(c);

        assertThat(dto.getId()).isEqualTo(1L);
        assertThat(dto.getTitle()).isEqualTo("Test");
    }
}

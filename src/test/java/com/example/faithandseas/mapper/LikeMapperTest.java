package com.example.faithandseas.mapper;

import com.example.faithandseas.dto.LikeDto;
import com.example.faithandseas.entity.Like;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

import static org.assertj.core.api.Assertions.assertThat;

class LikeMapperTest {

    private final LikeMapper likeMapper =
            Mappers.getMapper(LikeMapper.class);

    @Test
    void toDto_shouldMapBasicFields() {
        Like like = new Like();
        like.setId(1L);

        LikeDto dto = likeMapper.toDto(like);

        assertThat(dto).isNotNull();
        assertThat(dto.getId()).isEqualTo(1L);
    }
}

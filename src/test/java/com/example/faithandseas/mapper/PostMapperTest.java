package com.example.faithandseas.mapper;

import com.example.faithandseas.dto.PostDto;
import com.example.faithandseas.entity.Post;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

import static org.assertj.core.api.Assertions.assertThat;

class PostMapperTest {

    private final PostMapper postMapper =
            Mappers.getMapper(PostMapper.class);

    @Test
    void toDto_shouldMapBasicFields() {
        Post post = new Post();
        post.setId(1L);
        post.setTitle("Bài viết test");

        PostDto dto = postMapper.toDto(post);

        assertThat(dto).isNotNull();
        assertThat(dto.getId()).isEqualTo(1L);
        assertThat(dto.getTitle()).isEqualTo("Bài viết test");
    }
}

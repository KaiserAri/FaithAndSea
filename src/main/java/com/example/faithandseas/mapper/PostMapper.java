package com.example.faithandseas.mapper;

import com.example.faithandseas.dto.PostDto;
import com.example.faithandseas.entity.Post;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {ArtistMapper.class, UserMapper.class})
public interface PostMapper {
    PostDto toDto(Post post);
    Post toEntity(PostDto postDto);
}
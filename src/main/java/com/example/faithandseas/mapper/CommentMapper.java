package com.example.faithandseas.mapper;

import com.example.faithandseas.dto.CommentDto;
import com.example.faithandseas.entity.Comment;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {UserMapper.class, PostMapper.class, ArtworkMapper.class})
public interface CommentMapper {
    CommentDto toDto(Comment comment);
    Comment toEntity(CommentDto commentDto);
}
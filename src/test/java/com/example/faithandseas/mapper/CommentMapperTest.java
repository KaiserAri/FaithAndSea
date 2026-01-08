package com.example.faithandseas.mapper;

import com.example.faithandseas.dto.CommentDto;
import com.example.faithandseas.entity.Comment;
import com.example.faithandseas.entity.User;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

import static org.assertj.core.api.Assertions.assertThat;

class CommentMapperTest {

    // Khởi tạo mapper trực tiếp
    private final CommentMapper mapper = Mappers.getMapper(CommentMapper.class);

    @Test
    void toDto_shouldMapIdAndUser() {
        // Tạo Comment
        Comment c = new Comment();
        c.setId(1L);

        // Tạo User cho Comment
        User user = new User();   // constructor mặc định
        user.setRole("Nguyen Van A");
        c.setUser(user);

        // Chuyển Comment sang CommentDto
        CommentDto dto = mapper.toDto(c);

        // Kiểm tra kết quả
        assertThat(dto).isNotNull();
        assertThat(dto.getId()).isEqualTo(1L);
        assertThat(dto.getUser()).isNotNull();
        assertThat(dto.getUser().getRole()).isEqualTo("Nguyen Van A");
    }
}

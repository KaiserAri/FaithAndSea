package com.example.faithandseas.mapper;

import com.example.faithandseas.dto.UserDto;
import com.example.faithandseas.entity.User;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

import static org.assertj.core.api.Assertions.assertThat;

class UserMapperTest {

    private final UserMapper mapper =
            Mappers.getMapper(UserMapper.class);

    @Test
    void toDto_shouldMapBasicFields() {
        User user = User.builder()
                .id(1L)
                .email("a@gmail.com")
                .fullName("Admin")
                .build();

        UserDto dto = mapper.toDto(user);

        assertThat(dto.getId()).isEqualTo(1L);
        assertThat(dto.getEmail()).isEqualTo("a@gmail.com");
    }
}
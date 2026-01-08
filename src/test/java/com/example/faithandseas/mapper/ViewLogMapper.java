package com.example.faithandseas.mapper;

import com.example.faithandseas.dto.ViewLogDto;
import com.example.faithandseas.entity.ViewLog;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class ViewLogMapperTest {

    @Autowired
    private ViewLogMapper viewLogMapper;

    @Test
    void toDto_shouldMapBasicFields() {
        ViewLog viewLog = new ViewLog();
        viewLog.setId(1L);

        ViewLogDto dto = viewLogMapper.toDto(viewLog);

        assertThat(dto).isNotNull();
        assertThat(dto.getId()).isEqualTo(1L);
    }
}

package com.example.faithandseas.mapper;

import com.example.faithandseas.dto.AdminLogDto;
import com.example.faithandseas.entity.AdminLog;
import com.example.faithandseas.entity.User;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class AdminLogMapperTest {

    @Autowired
    private AdminLogMapper mapper;

    @Test
    void toDto_shouldMapIdAndAction_only() {
        AdminLog adminLog = new AdminLog();
        adminLog.setId(10L);
        adminLog.setAction("CREATE");

        AdminLogDto dto = mapper.toDto(adminLog);

        assertThat(dto).isNotNull();
        assertThat(dto.getId()).isEqualTo(10L);
        assertThat(dto.getAction()).isEqualTo("CREATE");
    }
}


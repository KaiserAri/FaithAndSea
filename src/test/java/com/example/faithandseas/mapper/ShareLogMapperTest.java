package com.example.faithandseas.mapper;

import com.example.faithandseas.dto.ShareLogDto;
import com.example.faithandseas.entity.ShareLog;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

import static org.assertj.core.api.Assertions.assertThat;

class ShareLogMapperTest {

    private final ShareLogMapper shareLogMapper =
            Mappers.getMapper(ShareLogMapper.class);

    @Test
    void toDto_shouldMapBasicFields() {
        ShareLog shareLog = new ShareLog();
        shareLog.setId(1L);

        ShareLogDto dto = shareLogMapper.toDto(shareLog);

        assertThat(dto).isNotNull();
        assertThat(dto.getId()).isEqualTo(1L);
    }
}

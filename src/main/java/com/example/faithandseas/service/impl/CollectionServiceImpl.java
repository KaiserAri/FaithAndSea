package com.example.faithandseas.service.impl;

import com.example.faithandseas.dto.CollectionDto;
import com.example.faithandseas.entity.Collection;
import com.example.faithandseas.mapper.CollectionMapper;
import com.example.faithandseas.repo.CollectionRepository;
import com.example.faithandseas.service.CollectionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CollectionServiceImpl implements CollectionService {

    private final CollectionRepository collectionRepository;
    private final CollectionMapper collectionMapper;

    @Override
    public List<CollectionDto> getAllCollections() {
        return collectionRepository.findAll()
                .stream()
                .map(collectionMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public CollectionDto getCollectionById(Long id) {
        Collection collection = collectionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Không tìm thấy bộ sưu tập"));
        return collectionMapper.toDto(collection);
    }

    @Override
    public CollectionDto createCollection(CollectionDto collectionDto) {
        Collection collection = collectionMapper.toEntity(collectionDto);
        return collectionMapper.toDto(collectionRepository.save(collection));
    }
}
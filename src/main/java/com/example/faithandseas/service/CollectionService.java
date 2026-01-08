package com.example.faithandseas.service;


import com.example.faithandseas.dto.CollectionDto;
import java.util.List;

public interface CollectionService {
    List<CollectionDto> getAllCollections();
    CollectionDto getCollectionById(Long id);
    CollectionDto createCollection(CollectionDto collectionDto); // Cho Admin
}
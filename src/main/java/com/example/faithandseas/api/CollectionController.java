package com.example.faithandseas.api;


import com.example.faithandseas.dto.CollectionDto;
import com.example.faithandseas.service.CollectionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/collections")
@RequiredArgsConstructor
public class CollectionController {

    private final CollectionService collectionService;

    // Xem danh sách tất cả bộ sưu tập
    @GetMapping
    public ResponseEntity<List<CollectionDto>> getAllCollections() {
        return ResponseEntity.ok(collectionService.getAllCollections());
    }

    // Xem chi tiết bộ sưu tập (bao gồm các tranh bên trong)
    @GetMapping("/{id}")
    public ResponseEntity<CollectionDto> getCollectionDetail(@PathVariable Long id) {
        return ResponseEntity.ok(collectionService.getCollectionById(id));
    }

    // Admin: Tạo bộ sưu tập mới (Nên bảo mật thêm Role ADMIN nếu cần)
    @PostMapping
    public ResponseEntity<CollectionDto> createCollection(@RequestBody CollectionDto collectionDto) {
        return ResponseEntity.ok(collectionService.createCollection(collectionDto));
    }
}
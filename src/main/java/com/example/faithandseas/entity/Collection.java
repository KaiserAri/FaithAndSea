package com.example.faithandseas.entity;


import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "collections")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Collection {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    @Column(columnDefinition = "NVARCHAR(MAX)")
    private String description;

    private String thumbnailUrl;

    private LocalDateTime createdAt;

    // Một bộ sưu tập có nhiều tác phẩm
    @OneToMany(mappedBy = "collection", cascade = CascadeType.ALL)
    private List<Artwork> artworks;

    @PrePersist
    protected void onCreate() {
        createdAt = LocalDateTime.now();
    }
}
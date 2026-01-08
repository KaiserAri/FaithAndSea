package com.example.faithandseas.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(name = "view_logs")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ViewLog {
    @Id

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "post_id")
    private Post post;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "artwork_id")
    private Artwork artwork;

    @Column(name = "ip_address", length = 100)
    private String ipAddress;

    @CreationTimestamp
    @Column(name = "viewed_at", updatable = false)
    private LocalDateTime viewedAt;
}
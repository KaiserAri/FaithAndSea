package com.example.faithandseas.repo;

import com.example.faithandseas.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {

    @Query("SELECT p FROM Post p WHERE " +
            "(:keyword IS NULL OR LOWER(p.title) LIKE LOWER(CONCAT('%', :keyword, '%'))) AND " +
            "(:artistId IS NULL OR p.artist.id = :artistId) AND " +
            "(:status IS NULL OR p.status = :status) " +
            "ORDER BY p.createdAt DESC")
    List<Post> filterAdvanced(@Param("keyword") String keyword,
                              @Param("artistId") Long artistId,
                              @Param("status") String status);
}
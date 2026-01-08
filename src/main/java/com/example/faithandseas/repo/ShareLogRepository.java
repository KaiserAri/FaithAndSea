package com.example.faithandseas.repo;

import com.example.faithandseas.entity.ShareLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShareLogRepository extends JpaRepository<ShareLog, Long> {}
package com.example.faithandseas.repo;

import com.example.faithandseas.entity.AdminLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminLogRepository extends JpaRepository<AdminLog, Long> {}

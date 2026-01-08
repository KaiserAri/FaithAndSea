package com.example.faithandseas.repo;

import com.example.faithandseas.entity.ViewLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ViewLogRepository extends JpaRepository<ViewLog, Long> {}
package com.example.gradletest.repository;

import com.example.gradletest.model.Log;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LogRepository extends JpaRepository<Log, Long> {
    List<Log> findByLevel(String level);
    List<Log> findByUserId(Long userId);
    List<Log> findByLevelAndUserId(String level, Long userId);
}

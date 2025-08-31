package com.example.gradletest.service;

import com.example.gradletest.model.Log;
import com.example.gradletest.repository.LogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LogService {

    @Autowired
    private LogRepository logRepository;

    public List<Log> getAllLogs() {
        return logRepository.findAll();
    }

    public Optional<Log> getLogById(Long id) {
        return logRepository.findById(id);
    }

    public Log saveLog(Log log) {
        return logRepository.save(log);
    }

    public void deleteLog(Long id) {
        logRepository.deleteById(id);
    }

    public List<Log> getLogsByLevel(String level) {
        return logRepository.findByLevel(level);
    }

    public List<Log> getLogsByUserId(Long userId) {
        return logRepository.findByUserId(userId);
    }

    public List<Log> getLogsByLevelAndUserId(String level, Long userId) {
        return logRepository.findByLevelAndUserId(level, userId);
    }
}

package com.example.gradletest.controller;

import com.example.gradletest.model.Log;
import com.example.gradletest.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/logs")
public class LogController {

    @Autowired
    private LogService logService;

    @GetMapping
    public ResponseEntity<List<Log>> getAllLogs() {
        return ResponseEntity.ok(logService.getAllLogs());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Log> getLogById(@PathVariable Long id) {
        return logService.getLogById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Log> createLog(@RequestBody Log log) {
        return ResponseEntity.ok(logService.saveLog(log));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Log> updateLog(@PathVariable Long id, @RequestBody Log log) {
        return logService.getLogById(id)
                .map(existingLog -> {
                    log.setId(id);
                    return ResponseEntity.ok(logService.saveLog(log));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLog(@PathVariable Long id) {
        if (logService.getLogById(id).isPresent()) {
            logService.deleteLog(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }
}

package com.example.gradletest.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

@Entity
@Table(name = "logs")
public class Log {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Level is required")
    @Column(nullable = false)
    private String level;

    @NotBlank(message = "Message is required")
    @Column(nullable = false, columnDefinition = "TEXT")
    private String message;

    @Column(name = "user_id")
    private Long userId;

    @Column(name = "created_timestamp")
    private LocalDateTime createdTimestamp;

    @Column(name = "updated_timestamp")
    private LocalDateTime updatedTimestamp;

    public Log() {}

    public Log(String level, String message, Long userId) {
        this.level = level;
        this.message = message;
        this.userId = userId;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public LocalDateTime getCreatedTimestamp() {
        return createdTimestamp;
    }

    public void setCreatedTimestamp(LocalDateTime createdTimestamp) {
        this.createdTimestamp = createdTimestamp;
    }

    public LocalDateTime getUpdatedTimestamp() {
        return updatedTimestamp;
    }

    public void setUpdatedTimestamp(LocalDateTime updatedTimestamp) {
        this.updatedTimestamp = updatedTimestamp;
    }

    @PrePersist
    protected void onCreate() {
        createdTimestamp = LocalDateTime.now();
        updatedTimestamp = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
        updatedTimestamp = LocalDateTime.now();
    }

    @Override
    public String toString() {
        return "Log{" +
                "id=" + id +
                ", level='" + level + '\'' +
                ", message='" + message + '\'' +
                ", userId=" + userId +
                ", createdTimestamp=" + createdTimestamp +
                ", updatedTimestamp=" + updatedTimestamp +
                '}';
    }
}

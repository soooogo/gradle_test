-- V4__Create_logs_table.sql
-- ログテーブルの作成

CREATE TABLE logs (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    level VARCHAR(10) NOT NULL,
    message TEXT NOT NULL,
    user_id BIGINT,
    created_timestamp TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_timestamp TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    FOREIGN KEY (user_id) REFERENCES users(id) ON DELETE SET NULL
);

-- インデックスの作成
CREATE INDEX idx_logs_level ON logs(level);
CREATE INDEX idx_logs_created_timestamp ON logs(created_timestamp);
CREATE INDEX idx_logs_user_id ON logs(user_id);

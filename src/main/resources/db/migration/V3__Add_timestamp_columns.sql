-- V3__Add_timestamp_columns.sql
-- タイムスタンプカラムの追加

-- usersテーブルにタイムスタンプカラムを追加
ALTER TABLE users 
ADD COLUMN created_timestamp TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
ADD COLUMN updated_timestamp TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP;

-- 既存のレコードにタイムスタンプを設定
UPDATE users SET 
    created_timestamp = created_at,
    updated_timestamp = updated_at
WHERE created_timestamp IS NULL;

-- インデックスの作成
CREATE INDEX idx_users_created_timestamp ON users(created_timestamp);
CREATE INDEX idx_users_updated_timestamp ON users(updated_timestamp);

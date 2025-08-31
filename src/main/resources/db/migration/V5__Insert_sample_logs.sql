-- V5__Insert_sample_logs.sql
-- サンプルログデータの挿入

INSERT INTO logs (level, message, user_id) VALUES
('INFO', 'User John Doe logged in', 1),
('INFO', 'User Jane Smith created new account', 2),
('WARN', 'User Bob Johnson failed login attempt', 3),
('ERROR', 'Database connection timeout', NULL),
('INFO', 'System backup completed successfully', NULL);

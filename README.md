# Gradle Test Project

Spring Boot + Gradle + MySQL を使用したサンプルアプリケーションです。

## プロジェクト構成

- **Spring Boot 3.2.0**: Webアプリケーションフレームワーク
- **Gradle 8.5**: ビルドツール
- **MySQL 8.0**: データベース
- **Docker**: コンテナ化
- **Docker Compose**: マルチコンテナ環境

## 機能

- ユーザー管理（CRUD操作）
- RESTful API
- MySQLデータベース連携
- Dockerコンテナ化

## 必要な環境

- Docker
- Docker Compose
- Java 17（ローカル開発用）

## 起動方法

### Docker Composeを使用（推奨）

```bash
# アプリケーションとMySQLを起動
docker-compose up -d

# ログを確認
docker-compose logs -f

# 停止
docker-compose down
```

### ローカル開発

```bash
# Gradle Wrapperを使用してビルド
./gradlew build

# アプリケーションを起動
./gradlew bootRun
```

## API エンドポイント

### ユーザー管理

- `GET /api/users` - 全ユーザー取得
- `GET /api/users/{id}` - 特定ユーザー取得
- `POST /api/users` - ユーザー作成
- `PUT /api/users/{id}` - ユーザー更新
- `DELETE /api/users/{id}` - ユーザー削除

### サンプルリクエスト

```bash
# 全ユーザー取得
curl http://localhost:8080/api/users

# ユーザー作成
curl -X POST http://localhost:8080/api/users \
  -H "Content-Type: application/json" \
  -d '{"name":"Test User","email":"test@example.com","phone":"+1234567890"}'

# 特定ユーザー取得
curl http://localhost:8080/api/users/1

# ユーザー更新
curl -X PUT http://localhost:8080/api/users/1 \
  -H "Content-Type: application/json" \
  -d '{"name":"Updated User","email":"updated@example.com","phone":"+0987654321"}'

# ユーザー削除
curl -X DELETE http://localhost:8080/api/users/1
```

## データベース

- **ホスト**: localhost:3306
- **データベース名**: gradletest
- **ユーザー名**: root
- **パスワード**: password

## 開発

### プロジェクト構造

```
src/
├── main/
│   ├── java/
│   │   └── com/example/gradletest/
│   │       ├── GradleTestApplication.java
│   │       ├── controller/
│   │       │   └── UserController.java
│   │       ├── model/
│   │       │   └── User.java
│   │       ├── repository/
│   │       │   └── UserRepository.java
│   │       └── service/
│   │           └── UserService.java
│   └── resources/
│       └── application.yml
└── test/
    └── java/
        └── com/example/gradletest/
```

### ビルド

```bash
# クリーンビルド
./gradlew clean build

# テスト実行
./gradlew test

# アプリケーション実行
./gradlew bootRun
```

## Docker

### イメージビルド

```bash
# アプリケーションイメージをビルド
docker build -t gradle-test-app .

# MySQLイメージは公式イメージを使用
docker pull mysql:8.0
```

### コンテナ実行

```bash
# アプリケーションコンテナを実行
docker run -p 8080:8080 gradle-test-app

# MySQLコンテナを実行
docker run -d \
  --name mysql \
  -e MYSQL_ROOT_PASSWORD=password \
  -e MYSQL_DATABASE=gradletest \
  -p 3306:3306 \
  mysql:8.0
```

## トラブルシューティング

### よくある問題

1. **ポートが既に使用されている場合**
   ```bash
   # 使用中のポートを確認
   lsof -i :8080
   lsof -i :3306
   ```

2. **MySQL接続エラー**
   - MySQLコンテナが正常に起動しているか確認
   - データベース接続設定を確認

3. **Gradleビルドエラー**
   ```bash
   # Gradleキャッシュをクリア
   ./gradlew clean
   ```

## ライセンス

このプロジェクトはMITライセンスの下で公開されています。

# タスク管理システム

## 実行手順

1. `cd docker`：docker ディレクトに移動
2. `docker compose up -d --build`：spring、postgres コンテナを立ち上げ
3. `docker compose exec java bash`：spring コンテナ内に入る
4. `./gradlew build`：spring プロジェクトをビルド
5. `java -jar ./build/libs/spring-0.0.1-SNAPSHOT.jar`：実行可能 jar を実行しアプリケーションサーバー立ち上げ
6. `http://localhost:8080/users`：ブラウザで確認

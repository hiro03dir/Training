# タスク管理システム

## コンテナ

- postgres

1. `TaskMS/docker/postgres`でコマンド`$docker compose up --build`を実行。
2. コンテナが立ち上がったことを確認したら、`docker compose exec postgre psql -U user -d tms_db`
3. テーブル一覧：`\dt`

## react-router-dom

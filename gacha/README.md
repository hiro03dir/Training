# ログイン機能つきガチャ
## 開発手順

### 環境構築
- gradleで立てるdockerの構築

build.gradleファイルにbuildscriptとapply以下でcomposeを構築できるようにしている。

- 接続情報の設定

resources/application.ymlで起動したコンテナに繋ぐ設定を行う。

- コンテナ立ち上げ

一度buildし直すと、右のgradleバーのTasks配下にdockerフォルダができる。
こちらのcomposeUpを実行するとdockerが立ち上がる。

### 初期データの挿入
```sql
-- userの挿入
CREATE TABLE "users" (
	"id" SERIAL NOT NULL,
	"name" TEXT NOT NULL primary key,
	"password" TEXT NOT NULL,
	"coin" INTEGER NOT NULL
)
;

INSERT INTO "users" ("name", "password", "coin") VALUES ('zenn', 'zenn', '900');

-- キャラクターの挿入
CREATE TABLE "characters" (
	"id" SERIAL NOT NULL primary key,
	"name" TEXT NOT NULL,
	"lank" INTEGER NOT NULL
)
;

INSERT INTO "characters" ("name", "lank") VALUES ('【明け色の陽射し】レイヴィニア＝バードウェイ', 3);
INSERT INTO "characters" ("name", "lank") VALUES ('【自動書記】インデックス', 3);
INSERT INTO "characters" ("name", "lank") VALUES ('【常盤台中学生】御坂美琴', 1);
INSERT INTO "characters" ("name", "lank") VALUES ('【学生】佐天涙子', 1);
INSERT INTO "characters" ("name", "lank") VALUES ('【座標移動】結標淡希', 2);

-- Userのcharacterコレクションテーブルを追加
CREATE TABLE "stocks" (
	"id" SERIAL NOT NULL primary key,
	"user_id" INTEGER NOT NULL,
	"character_id" INTEGER NOT NULL
);

```



### アプリケーション起動

- Docker立ち上げ
  /gacha/dockerでpostgresコンテナと/vuejsでvueコンテナを立ち上げる。

- アプリケーション
gradleのbootRunを実行

- URLでweb画面を表示
  Vueのデフォルト画面： http://localhost:8081/
　画面

#### エラー関連
- docker
  - postgres
    'The data directory was initialized by PostgreSQL version 15, which is not compatible with this version 16.0'
    のようなエラーが出た場合、docker-compose.ymlではpostgresの最新版のイメージを使っているが、すでにビルドされているデータディレクトリが古いバージョンなので互換性がないというエラーになる。
    対策としては、生成ファイルであるdataディレクトリを一度削除してビルドしなおすか、docker-compose.ymlでのpostgresのバージョンを下げれば良い。
  - vuejs
    dockerのビルドの時点でvuejsのコードの中身にまで口出してくるので注意
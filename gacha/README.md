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

### アプリケーション起動

- Docker立ち上げ
  /gacha/dockerでpostgresコンテナと/vuejsでvueコンテナを立ち上げる。

- アプリケーション
gradleのbootRunを実行

- URLでweb画面を表示
  Vueのデフォルト画面： http://localhost:8081/
　画面

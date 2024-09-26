https://www.postgresqltutorial.com/


dvdrental.zipをダウンロード

https://www.postgresqltutorial.com/postgresql-getting-started/postgresql-sample-database/

zipファイルを解凍

```shell
unzip dvdrental.zip
```

dvdrental.tarできる

```shell
ls -l dvdrental.tar
```

DB起動

```shell
docker compose up -d
```

dvdrental.tarをコピー

```shell
docker cp dvdrental.tar コンテナID:/tmp
```

DBコンテナに入る

```shell
docker compose exec db bash 
```

リストア（時間がかかる）

```shell
pg_restore -U postgres -f /tmp/dvdrental.tar
```


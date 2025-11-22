# wpg

> web playground

used framework and library

+ spring boot 3.x
+ [jooq](https://www.jooq.org/)
+ flyway

## env setting

1. deploy PostgreSQL db with docker

    ```shell
    docker pull postgres:17.5
    docker run --name pg17d5 -e POSTGRES_PASSWORD=whatever -p 5432:5432 -d postgres:17.5
    ```

    ```shell
    docker pull redis:8.2-alpine
    docker run -itd --name redis-pg -p 6379:6379 redis:8.2-alpine
    ```

   ```shell
    docker pull clickhouse/clickhouse-server
    docker run -d -p 18123:8123 -p19000:9000 -e CLICKHOUSE_PASSWORD=changeme --name some-clickhouse-server --ulimit nofile=262144:262144 clickhouse/clickhouse-server
   ```

2. init data

    ```shell
    gradle flywayMigrate -i
    ```

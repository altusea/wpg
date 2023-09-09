# wpg

> web playground

used framework and library

+ spring boot 3.x
+ [jooq](https://www.jooq.org/)
+ flyway

## env setting

1. deploy PostgreSQL db with docker

    ```shell
    docker pull postgres:15.4
    docker run --name pg15d4 -e POSTGRES_PASSWORD=whatever -p 5432:5432 -d postgres:15.4
    ```

    ```shell
    docker pull redis:7.2-alpine
    docker run -itd --name redis-pg -p 6379:6379 redis:7.2-alpine
    ```

2. init data

    ```shell
    gradle flywayMigrate -i
    ```

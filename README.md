# wpg

> web playground

used framework and library

+ spring boot 3.x
+ [jooq](https://www.jooq.org/)
+ flyway

## env setting

1. deploy PostgreSQL db with docker

    ```shell
    docker pull postgres:14.9
    docker run --name pg14d9 -e POSTGRES_PASSWORD=pg1234 -p 5432:5432 -d postgres:14.9
    ```

2. init data

    ```shell
    gradle flywayMigrate -i
    ```

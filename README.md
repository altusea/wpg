# wpg

> web playground

used framework and library

+ spring boot 3.x
+ [jooq](https://www.jooq.org/)

## env setting

1. deploy PostgreSQL db with docker

    ```shell
    docker pull postgres:14.9
    docker run --name pg14d9 -e POSTGRES_PASSWORD=pg1234 -p 5432:5432 -d postgres:14.9
    ```

2. init data

    ```sql
    create schema wpg;

    create table wpg.operator
    (
        id   varchar(20) primary key,
        name varchar(20) not null,
        tel  varchar(12),
        addr varchar(40)
    );
    
    insert into operator(id, name, tel, addr)
    values ('001', 'ada', '111', 'china'),
           ('002', 'bob', '112', 'china'),
           ('003', 'jun', '113', 'china');
    ```

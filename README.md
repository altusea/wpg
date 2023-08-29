# wpg

> web playground

## env setting

1. deploy PostgreSQL db with docker

    ```shell
    dockr pull postgres:14.9
    docker run --name pg14d9 -e POSTGRES_PASSWORD=pg1234 -p 5432:5432 -d postgres:14.9
    ```

2. init data

    ```sql
    create table operator
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

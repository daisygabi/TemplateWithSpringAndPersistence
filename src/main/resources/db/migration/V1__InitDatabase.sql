-- auto-generated definition
create table remote_dev
(
    id            bigserial     not null
            primary key,
    first_name    varchar(300)  not null,
    last_name     varchar(300)  not null,
    created_at    timestamp     not null,
    updated_at    timestamp default CURRENT_DATE
);
create unique index remote_dev_id_uindex
    on remote_dev (id);

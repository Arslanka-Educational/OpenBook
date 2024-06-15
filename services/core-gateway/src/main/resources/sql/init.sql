create table users
(
    id        uuid primary key,
    name      varchar        not null,
    password  varchar        not null,
    email     varchar unique not null,
    user_type varchar        not null
);
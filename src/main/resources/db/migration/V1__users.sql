create table users (
    id bigserial primary key,
    email varchar(255) not null unique,
    username varchar(100) not null unique,
    password varchar(255) not null
);

create table person
(
    id         int auto_increment
        primary key,
    first_name varchar(255) null,
    last_name  varchar(255) null,
    password   varchar(255) null,
    user_name  varchar(255) null,
    city       varchar(255) null
);
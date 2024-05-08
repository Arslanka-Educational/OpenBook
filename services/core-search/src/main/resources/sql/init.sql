drop type if exists booking_status;

create type booking_status as enum ('AVAILABLE', 'UNAVAILABLE');

create table if not exists author
(
    id   uuid primary key,
    name varchar(128) not null
);

create table if not exists library
(
    id   uuid primary key,
    name varchar(256) not null,
    city varchar(128) not null
);

create table if not exists publisher
(
    id   uuid primary key,
    name varchar(128) not null
);

create table if not exists book_info
(
    id           uuid primary key,
    name         varchar(256) not null,
    author_id    uuid         not null,
    publisher_id uuid         not null,
    CONSTRAINT author_id_fk FOREIGN KEY (author_id) REFERENCES author (id),
    CONSTRAINT publisher_id_fk FOREIGN KEY (publisher_id) REFERENCES publisher (id)
);

create table if not exists book
(
    id           uuid primary key,
    book_info_id uuid           not null,
    library_id   uuid           not null,
    status       booking_status not null,
    CONSTRAINT book_info_id_fk FOREIGN KEY (book_info_id) REFERENCES book_info (id),
    CONSTRAINT library_id_fk FOREIGN KEY (library_id) REFERENCES library (id)
);
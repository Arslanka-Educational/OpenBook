drop table if exists authors cascade;
drop table if exists libraries cascade;
drop table if exists publishers cascade;
drop table if exists book_info cascade;
drop table if exists books cascade;
drop table if exists reservation;
drop type if exists booking_status cascade;

create type booking_status as enum ('AVAILABLE', 'UNAVAILABLE');

create table authors
(
    id   UUID primary key,
    name varchar(128) not null
);

create table libraries
(
    id   UUID primary key,
    name varchar(256) not null,
    city varchar(128) not null
);

create table publishers
(
    id   UUID primary key,
    name varchar(128) not null
);

create table book_info
(
    id        UUID primary key,
    name      varchar(256) not null,
    author_id UUID         not null,
    CONSTRAINT author_id_fk FOREIGN KEY (author_id) REFERENCES authors (id)
);

create table books
(
    id           uuid primary key,
    book_info_id uuid           not null,
    library_id   uuid           not null,
    publisher_id uuid           not null,
    status       booking_status not null default 'UNAVAILABLE',
    CONSTRAINT book_info_id_fk FOREIGN KEY (book_info_id) REFERENCES book_info (id),
    CONSTRAINT library_id_fk FOREIGN KEY (library_id) REFERENCES libraries (id),
    CONSTRAINT publisher_id_fk FOREIGN KEY (publisher_id) REFERENCES publishers (id)
);

create table reservation
(
    id                          uuid primary key,
    book_id                     uuid      not null,
    reserved_date               timestamp not null,
    reservation_expiration_date timestamp not null,
    CONSTRAINT book_id_fk FOREIGN KEY (book_id) REFERENCES books (id)
);

create index on authors (name);
create index on publishers (name);
create index on libraries (name);
create index on book_info (name);
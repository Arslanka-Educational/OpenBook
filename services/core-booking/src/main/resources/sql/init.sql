create table if not exists books_reservations
(
    id                   uuid primary key,
    reservation_date     TIMESTAMPTZ not null,
    reservation_due_date TIMESTAMPTZ not null,
    book_id              uuid      not null
)
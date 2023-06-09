create table products
(
    id         bigserial primary key,
    title      varchar(255),
    price      numeric(8, 2) not null,
    created_at timestamp default current_timestamp,
    updated_at timestamp default current_timestamp
);

insert into products (title, price)
values ('Milk', 85),
       ('Bread', 25),
       ('Cheese', 425);

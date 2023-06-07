create table groups (id bigserial primary key, title varchar(255));
insert into groups (title)
values
('ABC-123');

create table students (id bigserial primary key, name varchar(255), age integer, group_id bigint references groups(id));
insert into students (name, age, group_id)
values
('Bob', 30, 1),
('Max', 32, 1);


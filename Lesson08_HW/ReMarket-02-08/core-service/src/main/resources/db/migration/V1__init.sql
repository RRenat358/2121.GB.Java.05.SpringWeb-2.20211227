
-- //============================================================

/*
create table if not exists products (
    id          bigserial primary key,
    title       varchar(255),
    price       int
);


insert into products (title, price)
values ('Milk', 100),
       ('Bread', 80),
       ('Cheese', 90);
*/

-- //============================================================
create table products (
    id bigserial        primary key,
    name                varchar(255),
    proteins            varchar(255),
    fats                varchar(255),
    carbohydrates       varchar(255),
    calories            varchar(255),
    group_product       varchar(255),
    price               int,

    created_at          timestamp default current_timestamp,
    updated_at          timestamp default current_timestamp
                      );

insert into products (
    name,
    proteins, fats, carbohydrates, calories,
    group_product,
    price)
values
    ('Клюква','0,7','0','4,9','27','ягоды','30'),
    ('Хрен','2,6','0','16,1','70','овощи','70'),
    ('Инжир','0,9','0','13,7','57','фрукты','120'),
    ('Курага','5,7','0','65,3','270','сухофрукты','50'),
    ('Капуста цветная','2,7','0','5,2','30','овощи','130'),
    ('Кизил','1,1','0','9,4','42','ягоды','10'),
    ('Перец красный сладкий','1,2','0','5,5','26','овощи','150'),
    ('Фисташки','20','50,5','7,3','555','орехи','30'),
    ('Шелковица','0,6','0','12,5','50','ягоды','130'),
    ('Репа','1,6','0','5,8','27','овощи','60'),
    ('Смородина красная','0,6','0','8,7','39','ягоды','60'),
    ('Лук порей','3,2','0','7,1','38','зелень','30'),
    ('Шиповник свежий','1,5','0','24,2','106','ягоды','60'),
    ('Памело','0,6','0,1','6,1','29','фрукты','70'),
    ('Картофель молодой','2,2','0,3','12,5','57','овощи','130'),
    ('Апельсин','0,8','0','8,6','38','фрукты','190'),
    ('Лимон','0,9','0','3,3','30','фрукты','30'),
    ('Картофель жареный','2,6','9,7','23,5','198','овощи','190'),
    ('Черника','1,2','0','8,8','41','ягоды','30'),
    ('Изюм с косточкой','1,7','0','70,7','273','сухофрукты','60'),
    ('Редька','1,7','0','7,1','33','овощи','190'),
    ('Алыча','0,3','0','7,6','35','фрукты','130'),
    ('Морковь','1,3','0,1','6,3','29','овощи','180'),
    ('Киви','1','0,7','9,7','46','фрукты','100'),
    ('Айва','0,6','0','8,7','37','фрукты','140'),
    ('Картофель вареный','2','0,3','16,5','80','овощи','150'),
    ('Облепиха','0,8','0','5,6','31','ягоды','110'),
    ('Свекла','1,7','0','10,5','46','овощи','110'),
    ('Клубника','0,6','0,4','7','30','ягоды','180'),
    ('Томаты (парниковые)','0,7','0','2,6','12','овощи','40'),
    ('Шиповник сушеный','4,5','0','60,1','259','ягоды','70'),
    ('Малина','0,7','0','9,2','43','ягоды','120'),
    ('Бобы','6,1','0,1','8,1','59','овощи','50'),
    ('Слива','0,8','0','9,7','41','фрукты','150'),
    ('Дыня','0,8','0,3','7,3','34','фрукты','120'),
    ('Черешня','1,3','0','12,5','54','фрукты','160'),
    ('Яблоки сушенные','3,1','0','68,3','275','сухофрукты','120'),
    ('Смородина черная','1','0','8','38','ягоды','180'),
    ('Горошек зеленый','5,4','0,2','13,6','75','овощи','190'),
    ('Груша','0,5','0','10,6','41','фрукты','160'),
    ('Морошка','0,9','0','6,9','33','ягоды','200'),
    ('Лук репчатый','1,6','0','9,3','41','овощи','90'),
    ('Мандарин','0,9','0','8,8','39','фрукты','130'),
    ('Хурма','0,7','0','15,7','61','фрукты','110'),
    ('Кешью','25,8','54,3','13,3','647','орехи','20'),
    ('Кабачки','0,8','0,3','5,9','30','овощи','40'),
    ('Грецкий орех','13,5','61,5','10,6','662','орехи','10'),
    ('Персики','0,9','0','10,1','42','фрукты','140'),
    ('Ежевика','1,9','0','5,1','31','ягоды','40'),
    ('Огурцы парниковые','0,7','0','1,6','9','овощи','130'),
    ('Абрикосы','0,7','0','10,1','44','фрукты','70'),
    ('Брюква','1,2','0,1','8,4','38','овощи','120'),
    ('Огурцы грунтовые','0,7','0','3,1','15','овощи','140'),
    ('Гранат','0,9','0','11,9','53','фрукты','110'),
    ('Финики','2,5','0,4','69,6','277','сухофрукты','160'),
    ('Рябина','1,6','0','12,2','57','ягоды','160'),
    ('Миндаль','18,3','57,9','13,4','643','орехи','90'),
    ('Урюк','5,3','0','67,9','279','сухофрукты','140'),
    ('Петрушка (зелень)','3,8','0','8','45','зелень','40'),
    ('Грейпфрут','0,8','0','7,5','37','фрукты','170'),
    ('Щавель','1,6','0','5,5','29','зелень','70'),
    ('Редис','1,5','0','4,2','22','овощи','100'),
    ('Салат','1,6','0','2,1','15','зелень','70'),
    ('Перец зеленый сладкий','1,2','0','4,8','24','овощи','100'),
    ('Виноград','0,5','0','17,8','73','фрукты','120'),
    ('Лук зеленый (перо)','1,4','0','4,2','21','зелень','60'),
    ('Чернослив','2,7','0','65,3','262','сухофрукты','60'),
    ('Петрушка (корень)','1,6','0','11,2','48','овощи','130'),
    ('Ананас','0,3','0','11,9','49','фрукты','60'),
    ('Бананы','1,7','0','22,1','87','фрукты','10'),
    ('Чеснок','6,6','0','21,1','103','овощи','40'),
    ('Арахис','26,2','45,3','9,9','555','орехи','200'),
    ('Томаты (грунтовые)','0,7','0','4,1','19','овощи','20'),
    ('Земляника','1,9','0','7,1','40','ягоды','60'),
    ('Крыжовник','0,8','0','9,7','43','ягоды','10'),
    ('Семя подсолнечника','20,9','52,5','5,4','582','орехи','180'),
    ('Шпинат','2,5','0','2,6','22','зелень','20'),
    ('Брусника','0,6','0','8,8','42','ягоды','160'),
    ('Фундук','16,3','66,7','9,8','701','орехи','170'),
    ('Смородина белая','0,4','0','8,5','37','ягоды','80'),
    ('Манго','0,6','0,4','11,8','69','фрукты','170'),
    ('Вишня','0,9','0','11,1','46','фрукты','60'),
    ('Фасоль','4,4','0','4,4','36','овощи','90'),
    ('Капуста краснокочанная','1,9','0','6,3','34','овощи','80'),
    ('Баклажаны','0,6','0,1','7,5','22','овощи','80'),
    ('Яблоки','0,5','0','11,4','48','фрукты','10'),
    ('Оливки','0,6','10,2','6,7','111','овощи','110'),
    ('Голубика','1,1','0','7,4','35','ягоды','170'),
    ('Изюм кишмиш','2,5','0','71,4','285','сухофрукты','150'),
    ('Капуста белокочанная','1,9','0','5,7','31','овощи','110');


-- //============================================================
create table orders (
    id              bigserial primary key,
    user_id         varchar(255) not null,
    total_price     int not null,
    address         varchar(255),
    phone           varchar(255),
    created_at      timestamp default current_timestamp,
    updated_at      timestamp default current_timestamp
);

create table order_items (
    id                  bigserial primary key,
    product_id          bigint not null references products (id),
    order_id            bigint not null references orders (id),
    quantity            int not null,
    price_per_product   int not null,
    price               int not null,
    created_at          timestamp default current_timestamp,
    updated_at          timestamp default current_timestamp
);

-- //============================================================

insert into orders (user_id, total_price, address, phone)
values ('bob', 200, 'ул.Ипподромная 54', '89670670112');

insert into order_items (product_id, order_id, quantity, price_per_product, price)
values (1, 1, 2, 100, 200);



-- //============================================================


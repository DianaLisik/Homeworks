-- создание таблицы Товар
create table if not exists product (
  id serial primary key, -- идентификатор строки, всегда уникальный
  "name" varchar not null, -- описание
  price integer not null, -- стоимость
  quantity integer not null -- количество
);

-- создание таблицы Покупатель
create table if not exists customer (
  id serial primary key, -- идентификатор строки, всегда уникальный
  "name" varchar(100) not null -- имя/фамилия
);

-- создание таблицы Заказ
 create table if not exists orders (
  customer_id integer, -- id-заказчика (внешний ключ)
  product_id integer, -- id-товара (внешний ключ)
  create_date timestamp default current_date, -- дата заказа
  quantity integer not null, -- количество товаров
  -- при удалении Покупателя из таблицы, все его Заказы из таблицы удалялятся автоматически
  foreign key (customer_id)
    references customer(id)
    on delete cascade,
  -- при удалении Продукта из таблицы, все связаные Заказы из таблицы удалялятся автоматически
  foreign key (product_id)
    references product(id)
    on delete cascade
);

-- добавление информации
insert into product("name", price, quantity) values
('Хлеб', 40, 60),
('Молоко', 60, 30),
('Торт', 1000, 7),
('Кофе растворимый', 879, 13),
('Масло', 150, 18);

insert into customer(name) values
('Павел Андреевич'),
('Анна Петровна'),
('Борис'),
('Екатерина Семенова');

insert into orders(customer_id, product_id, quantity) values
(1, 1, 1), --Павел Андреевич 1 Хлеб
(1, 5, 1), --Павел Андреевич 1 Масло
(1, 3, 1), --Павел Андреевич 1 Торт
(2, 4, 1), --Анна Петровна 1 Кофе растворимый
(2, 2, 3), --Анна Петровна 3 Молоко
(2, 1, 2), --Анна Петровна 2 Хлеб
(4, 1, 1), --Екатерина Семенова 1 Хлеб
(4, 3, 4), --Екатерина Семенова 4 Торт
(4, 4, 2), --Екатерина Семенова 2 Кофе растворимый
(1, 2, 2); --Павел Андреевич 2 Молоко

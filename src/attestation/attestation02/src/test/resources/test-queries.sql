----Тест по таблице Покупателей ----
-- получение всех данных из таблицы
select *
from customer;

-- обновление информации
update customer
set "name" = 'Ольга Петровна'
where id = 2;

--удаление объекта
delete
from customer
where "name" = 'Борис';


----Тест по таблице Продукты ----
-- получение всех данных из таблицы
select *
from product;

-- обновление информации
update product
set "name" = 'Молоко 3.2%',
price = 88,
quantity = 33
where "name" = 'Молоко';

--удаление объекта
delete
from product
where "name" = 'Торт';


----Тест по таблице Заказы ----
-- получение всех данных из таблицы
select *
from orders;

select c."name", p."name", o.quantity, o.create_date
from orders o, product p, customer c
where o.product_id=p."id" and o.customer_id=c."id";

-- обновление информации
update orders
set quantity = 9
where customer_id= 1 and product_id = 1;

--удаление объектов
delete
from orders
where product_id = 5;
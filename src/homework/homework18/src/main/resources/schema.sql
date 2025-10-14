--CREATE TABLE IF NOT EXISTS user (
--  id SERIAL PRIMARY KEY,
--  user_name VARCHAR(100) NOT NULL
--);
--
-- CREATE TABLE IF NOT EXISTS order (
--  id SERIAL PRIMARY KEY,
--  user_id INTEGER REFERENCES  user(id),
--  create_date TIMESTAMP DEFAULT CURRENT_DATE,
--  order_count INT,
--  discount INT
--);

INSERT INTO javacore3."user"(name) VALUES('Пупочкин Вася');
INSERT INTO javacore3."user"(name) VALUES('Сидоров Коля');

INSERT INTO javacore3."order"(user_id, order_count, discount) VALUES
(1, 5, 10),
(1, 17, 30),
(2, 3, 50),
(1, 60, 10);

SELECT * FROM javacore3."user"
SELECT * FROM javacore3."order"
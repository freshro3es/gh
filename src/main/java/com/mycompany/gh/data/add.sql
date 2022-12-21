/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/SQLTemplate.sql to edit this template
 */

DROP TABLE IF EXISTS "order", part, part_order, work, work_type, "user";

CREATE TABLE IF NOT EXISTS "order"
(
    order_id smallint NOT NULL,
    terms_of_work time without time zone,
    client_mail character varying(50),
    order_status boolean,
    car_name character varying(50),
    CONSTRAINT order_pkey PRIMARY KEY (order_id)
);

CREATE TABLE IF NOT EXISTS part
(
    id serial NOT NULL,
    name character varying(50),
    type character varying(50),
    price int,
    amount int,
    order_id int,
    CONSTRAINT part_pkey PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS part_order
(
    part_name character varying(50),
    part_type character varying(50),
    price int,
    amount int,
    order_id int
);

CREATE TABLE IF NOT EXISTS work
(
    work_id serial NOT NULL,
    work_type_id smallint NOT NULL,
    work_name character varying(50),
    execution_duration time without time zone,
    work_cost real
);

CREATE TABLE IF NOT EXISTS work_type
(
    work_type_id serial NOT NULL,
    work_type_name character varying(50)
);

CREATE TABLE IF NOT EXISTS "user"
(
    email varchar(50) NOT NULL,
    password varchar(50) NOT NULL,
    name varchar(50) NOT NULL,
    lastname varchar(50) NOT NULL,
    role varchar(15) NOT NULL,
    CONSTRAINT user_pkey PRIMARY KEY (email)
);

INSERT INTO "user" (email, password, name, lastname, role)
VALUES  ('1111', '1111', 'Остап', 'Бендер', 'admin'),
        ('2222', '2222', 'Андрей', 'Алегров', 'mechanic'),
        ('3333', '3333', 'Сергей', 'Васильев', 'client'),
        ('4444', '4444', 'Вова', 'Седой', 'admin');


INSERT INTO part (id, name, type, price, amount, order_id)
VALUES  (DEFAULT, 'Сцепление', 'Трансмиссия', 10000, 1, 1234),
        (DEFAULT, 'Масло', 'Трансмиссия', 2000, 2, 4321),
        (DEFAULT, 'МКПП', 'Трансмиссия', 150000, 1, 1234);

INSERT INTO part_order (part_name, part_type, price, amount, order_id)
VALUES  ('Амортизатор', 'Подвеска', 10000, 4, 4321),
        ('Сайлентблок', 'Подвеска', 2000, 20, 7522),
        ('Шаровая опора', 'Подвеска', 15000, 3, 7522);

INSERT INTO work_type (work_type_id, work_type_name)
VALUES  (DEFAULT, 'Техническое обслуживание'),
        (DEFAULT, 'Двигатель и система охлаждения'),
        (DEFAULT, 'Кузовной ремонт и сварочные работы'),
        (DEFAULT, 'Обслуживание ходовой части'),
        (DEFAULT, 'Шиномонтаж и сход-развал'),
        (DEFAULT, 'Трансмиссия'),
        (DEFAULT, 'Рулевое управление'),
        (DEFAULT, 'Тормозная система'),
        (DEFAULT, 'Дополнительные услуги');

INSERT INTO work (work_id, work_type_id, work_name, execution_duration, work_cost)
VALUES  (DEFAULT, 1, 'Замена масла в ДВС', '00:10:00', 1321),
        (DEFAULT, 1, 'Замена масляного фильтра', '00:10:00', 1321),
        (DEFAULT, 1, 'Замена воздушного фильтра', '00:10:00', 1321),
        (DEFAULT, 1, 'Замена топливного фильтра', '00:10:00', 1321),
        (DEFAULT, 1, 'Сброс межсервисных интервалов', '00:10:00', 1321),
        (DEFAULT, 1, 'Замена тормозной жидкости', '00:10:00', 1321),
        (DEFAULT, 1, 'Замена охлаждающей жидкости', '00:10:00', 1321),
        (DEFAULT, 1, 'Замена патрубков системы охлаждения', '00:10:00', 1321),
        (DEFAULT, 1, 'Замена жидкости ГУР', '00:10:00', 1321),
        (DEFAULT, 1, 'Диагностика форсунок (диагностика инжектора)', '00:10:00', 1321);


CREATE TABLE IF NOT EXISTS work
(
    work_id serial NOT NULL,
    work_type_id smallint NOT NULL,
    work_name character varying(50),
    execution_duration time without time zone,
    work_cost real
);
/**
 * Author:  Игорь
 * Created: 17 дек. 2022 г.
 */


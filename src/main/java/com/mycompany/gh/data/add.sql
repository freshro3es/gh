/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/SQLTemplate.sql to edit this template
 */

DROP TABLE IF EXISTS "order", order_work, part, part_order, work, work_type, "user";

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

CREATE TABLE IF NOT EXISTS "order"
(
    order_id serial NOT NULL,
    login varchar(50) NOT NULL,
    name varchar(50) NOT NULL,
    lastname varchar(50) NOT NULL,
    phone varchar(50) NOT NULL,
    email varchar(50) NOT NULL,
    status varchar(15) NOT NULL
);

CREATE TABLE IF NOT EXISTS order_work
(
    order_id int NOT NULL,
    work_id int NOT NULL,
    status varchar(15) NOT NULL
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
VALUES  (DEFAULT, 1, 'Замена масла в ДВС', '00:30:00', 1000),
        (DEFAULT, 1, 'Замена масляного фильтра', '00:15:00', 500),
        (DEFAULT, 1, 'Замена воздушного фильтра', '00:15:00', 700),
        (DEFAULT, 1, 'Замена топливного фильтра', '00:20:00', 1500),
        (DEFAULT, 1, 'Сброс межсервисных интервалов', '00:30:00', 3000),
        (DEFAULT, 1, 'Замена тормозной жидкости', '00:10:00', 500),
        (DEFAULT, 1, 'Замена охлаждающей жидкости', '00:10:00', 500),
        (DEFAULT, 1, 'Замена патрубков системы охлаждения', '01:00:00', 3500),
        (DEFAULT, 1, 'Замена жидкости ГУР', '00:40:00', 2500),
        (DEFAULT, 1, 'Диагностика форсунок (диагностика инжектора)', '00:30:00', 1750),
        (DEFAULT, 2, 'Капитальный ремонт двигателя', '24:00:00', 50000),
        (DEFAULT, 2, 'Замена ремня и цепи ГРМ', '01:30:00', 7000),
        (DEFAULT, 2, 'Замена приводных ремней', '02:00:00', 9000),
        (DEFAULT, 2, 'Замена опор двигателя', '03:00:00', 15000),
        (DEFAULT, 2, 'Замена поршневых колец и малосъемных колпачков', '04:00:00', 13000),
        (DEFAULT, 2, 'Замена сальников', '02:30:00', 6000),
        (DEFAULT, 2, 'Промывка топливной системы', '01:30:00', 3500),
        (DEFAULT, 2, 'Ремонт головки блока цилиндров', '03:45:00', 8500),
        (DEFAULT, 2, 'Замена радиатора', '01:00:00', 10000),
        (DEFAULT, 2, 'Замена насоса охлаждающей жидкости (помпы)', '00:45:00', 4500),
        (DEFAULT, 2, 'Очистка дроссельной заслонки', '00:35:00', 3250),
        (DEFAULT, 2, 'Замена турбины', '02:10:00', 17500),
        (DEFAULT, 2, 'Замена масляного насоса', '02:00:00', 5000),
        (DEFAULT, 2, 'Замер компрессии в ДВС', '01:30:00', 4000),
        (DEFAULT, 2, 'Ремонт выхлопной системы', '07:00:00', 30000),
        (DEFAULT, 2, 'Регулировка клапанов', '01:40:00', 4000),
        (DEFAULT, 2, 'Замена воздушного фильтра', '00:10:00', 2500),
        (DEFAULT, 2, 'Замена топливного фильтра', '00:30:00', 6000),
        (DEFAULT, 3, 'Кузовной ремонт', '04:00:00', 10000),
        (DEFAULT, 3, 'Покраска кузова автомобиля', '24:00:00', 50000),
        (DEFAULT, 3, 'Ремонт бампера', '08:00:00', 10000),
        (DEFAULT, 3, 'Вакуумное удаление вмятин без покраски', '02:00:00', 5000),
        (DEFAULT, 3, 'Восстановление геометрии кузова', '10:00:00', 17000),
        (DEFAULT, 3, 'Ремонт после аварии', '24:00:00', 500000),
        (DEFAULT, 4, 'Замена сцепления', '04:00:00', 9000),
        (DEFAULT, 4, 'Замена сайлентблока', '01:30:00', 4500),
        (DEFAULT, 4, 'Замена амортизатора', '02:00:00', 7500),
        (DEFAULT, 4, 'Замена шаровых опор', '01:45:00', 5000),
        (DEFAULT, 4, 'Замена рычагов', '01:30:00', 9000),
        (DEFAULT, 5, 'Компьютерная диагностика развал-схождение 3D', '01:00:00', 5000),
        (DEFAULT, 5, 'Балансировка колес', '01:00:00', 6000),
        (DEFAULT, 5, 'Хранение шин', '24:00:00', 10000),
        (DEFAULT, 6, 'Замена сцепления', '04:00:00', 9000),
        (DEFAULT, 6, 'Замена масла в АКПП', '01:00:00', 2500),
        (DEFAULT, 6, 'Замена АКПП', '05:00:00', 35000),
        (DEFAULT, 6, 'Замена крестовин', '02:00:00', 9000),
        (DEFAULT, 6, 'Ремонт МКПП', '10:00:00', 20000),
        (DEFAULT, 6, 'Замена карданного вала', '05:00:00', 11500),
        (DEFAULT, 6, 'Ремонт карданного вала', '08:00:00', 9750),
        (DEFAULT, 6, 'Замена редукторов', '05:00:00', 8000),
        (DEFAULT, 6, 'Ремонт редукторов', '09:00:00', 7000),
        (DEFAULT, 6, 'Замена раздаточных коробок', '07:00:00', 20000),
        (DEFAULT, 6, 'Ремонт раздаточных коробок', '11:00:00', 15000),
        (DEFAULT, 6, 'Замена ШРУСов и пыльников ШРУСов', '03:00:00', 5000),
        (DEFAULT, 6, 'Замена подшипников полуосей', '03:00:00', 5000),
        (DEFAULT, 7, 'Замена рулевых тяг и наконечников', '03:00:00', 7500),
        (DEFAULT, 7, 'Замена рулевых реек', '03:30:00', 9000),
        (DEFAULT, 7, 'Ремонт рулевой рейки', '04:30:00', 8000),
        (DEFAULT, 7, 'Замена рулевых редукторов', '04:00:00', 8200),
        (DEFAULT, 7, 'Ремонт рулевых редукторов', '05:00:00', 7600),
        (DEFAULT, 7, 'Замена жидкости ГУР', '00:40:00', 2500),
        (DEFAULT, 7, 'Замена насоса системы ГУР', '01:30:00', 6100),
        (DEFAULT, 8, 'Замена тормозных дисков', '00:45:00', 5000),
        (DEFAULT, 8, 'Замена тормозных колодок', '00:45:00', 2500),
        (DEFAULT, 8, 'Замена тормозной жидкости', '00:15:00', 1000),
        (DEFAULT, 9, 'Установка парктроников', '02:00:00', 18000),
        (DEFAULT, 9, 'Установка камеры заднего вида', '02:00:00', 19000),
        (DEFAULT, 9, 'Шумоизоляция автомобиля', '24:00:00', 50000),
        (DEFAULT, 9, 'Установка защиты картера', '05:00:00', 13210),
        (DEFAULT, 9, 'Автомойка, полировка, химчистка', '03:00:00', 10000);

/**
 * Author:  Игорь
 * Created: 17 дек. 2022 г.
 */


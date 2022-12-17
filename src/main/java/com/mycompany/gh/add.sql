/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/SQLTemplate.sql to edit this template
 */

DROP TABLE IF EXISTS mechanic, order, order_part, order_work, part, part_request, work, work_type;

CREATE TABLE IF NOT EXISTS mechanic
(
    mail character varying(50),
    name character varying(100),
    id smallint NOT NULL,
    CONSTRAINT mechanic_pkey PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS order
(
    order_id smallint NOT NULL,
    terms_of_work time without time zone,
    client_mail character varying(50),
    order_status boolean,
    car_name character varying(50),
    CONSTRAINT order_pkey PRIMARY KEY (order_id)
);

CREATE TABLE IF NOT EXISTS order_part
(
    order_id smallint,
    part_id smallint,
    number_of_details smallint
);

CREATE TABLE IF NOT EXISTS order_work
(
    order_id smallint,
    work_id smallint,
    mechanic_id time without time zone,
    work_status boolean
);

CREATE TABLE IF NOT EXISTS part
(
    id smallint NOT NULL,
    type character varying(50),
    price smallint,
    name character varying(50),
    CONSTRAINT part_pkey PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS part_request
(
    order_id smallint,
    part_id smallint,
    number_of_details smallint
);

CREATE TABLE IF NOT EXISTS parts_request
(
    order_id smallint,
    mechanic_id smallint
);

CREATE TABLE IF NOT EXISTS work
(
    work_id smallint NOT NULL,
    work_type_id smallint NOT NULL,
    work_name character varying(50),
    execution_duration time without time zone,
    work_cost real,
    CONSTRAINT work_pkey PRIMARY KEY (work_id),
    CONSTRAINT work_work_name_key UNIQUE (work_name)
);

CREATE TABLE IF NOT EXISTS work_type
(
    work_type_id smallint NOT NULL,
    work_type_name character varying(50),
    CONSTRAINT work_type_pkey PRIMARY KEY (work_type_id),
    CONSTRAINT work_type_work_type_name_key UNIQUE (work_type_name)
)


/**
 * Author:  Игорь
 * Created: 17 дек. 2022 г.
 */


DROP database IF EXISTS MediScreenP9;
create database MediScreenP9;
use MediScreenP9;

CREATE TABLE users
(
	patient_id            BIGINT       NOT NULL AUTO_INCREMENT PRIMARY KEY,
    first_name         VARCHAR(100) NOT NULL,
    last_name          VARCHAR(100) NOT NULL,
    birth_date                DATE   NOT NULL,
    gender 				VARCHAR(100) NOT NULL,
    address 				VARCHAR(100) NOT NULL,
    phone 				VARCHAR(100) NOT NULL
);

INSERT INTO users (first_name, last_name, birth_date,gender,address,phone)
values ('Bob', 'Morran', '2022-05-21', 'M', '6 Rue du lac', '060904');
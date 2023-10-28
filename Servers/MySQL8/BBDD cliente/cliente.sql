create database if not exists bbdd_sboot_prueba;
use bbdd_sboot_prueba;

create table clientes(
id_cliente int auto_increment primary key,
nombre varchar(45) not null,
facturacion_anual dec(11,2),
numero_empleados int
);
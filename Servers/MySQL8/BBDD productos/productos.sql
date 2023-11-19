create database productosbd;
use productosbd;
create table familias (
id_familia int not null auto_increment primary key,
descripcion varchar(45) not null
);

insert into familias values
(1,"camisas"),
(2,"Pantalones"),
(3,"Faldas"),
(4,"Cinturones");

create table productos (
id_producto int not null auto_increment primary key,
descripcion varchar(45) not null,
marca varchar(45),
precio_unitario decimal(9,2),
stock int,
fecha_alta date,
id_familia int not null,
foreign key (id_familia) references familias(id_familia)
);

insert into productos values
(1,"camisa blanca S Mujer","nisu",120,50,current_date(),1),
(2,"camisa verde L Mujer","lois",60,50,current_date(),1),
(3,"camisa negra XL Hombre","nisu",36,50,current_date(),1);
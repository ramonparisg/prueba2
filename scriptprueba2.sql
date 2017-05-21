drop database if exists prograweb;

create database prograweb;

use prograweb;

create table perfil(
id int auto_increment,
detalle varchar(45),
primary key(id)
);

create table usuario(
id int auto_increment,
perfil_id int,
nombre varchar(45),
apellido varchar(45),
email varchar(150),
fecha_creacion date,
primary key(id),
constraint fk_usuario_perfil foreign key(perfil_id) references perfil(id)
);

create table post_estado(
id int auto_increment,
detalle varchar(45),
primary key(id)
);

create table post(
id int auto_increment,
usuario_id int,
titulo varchar(200),
cuerpo text,
post_estado_id int,
fecha_creacion date,
primary key(id),
constraint fk_post_usuario foreign key(usuario_id) references usuario(id),
constraint fk_post_estado foreign key(post_estado_id) references post_estado(id)
);

create table comentario_estado(
id int auto_increment,
detalle varchar(45),
primary key (id)
);

create table comentario(
id int auto_increment,
usuario_id int,
post_id int,
comentario_estado_id int,
comentario text,
fecha_creacion date,
primary key (id),
constraint fk_comentario_usuario foreign key(usuario_id) references usuario(id),
constraint fk_comentario_post foreign key(post_id) references post(id),
constraint fk_comentario_estado foreign key(comentario_estado_id) references comentario_estado(id)
);
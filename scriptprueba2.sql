drop database if exists prograweb;

create database prograweb;

use prograweb;

create table perfil(
id int,
detalle varchar(45),
primary key(id)
);

create table usuario(
id int auto_increment,
perfil_id int,
nombre varchar(45),
apellido varchar(45),
email varchar(150) not null unique,
fecha_creacion date,
primary key(id),
constraint fk_usuario_perfil foreign key(perfil_id) references perfil(id)
);

create table post_estado(
id int,
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
id int,
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


insert into perfil values (1,'Administrador');

insert into usuario(perfil_id,
					nombre,
					apellido,
					email,
					fecha_creacion) values (1,'Ramon','Paris','pariis78@gmail.com',now());

insert into post_estado values (1,'Online');


insert into post(usuario_id,
				titulo,
				cuerpo,
				post_estado_id,
				fecha_creacion) values (1,
										'Lorem Ipsum',
										'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Morbi pellentesque eros ante, eu fringilla orci bibendum quis. Nullam dictum enim vitae rhoncus suscipit. Nam gravida consequat tortor ut aliquet. Praesent a lacinia lorem. Etiam et ante non lorem sollicitudin pellentesque. Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas. Ut sed ullamcorper massa, in auctor risus. Pellentesque egestas tellus est, id lobortis tellus porttitor quis. Morbi vel mi ut eros luctus ultricies. Phasellus vehicula tempus est, non aliquet libero luctus eu. Nunc commodo sodales velit vitae sollicitudin.',
										1,now());

insert into comentario_estado values(1,"Publicado");
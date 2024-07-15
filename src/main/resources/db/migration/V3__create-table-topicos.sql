create table topicos(
    id bigint not null auto_increment,
    titulo varchar(100) not null,
    mensaje varchar(300) not null,
    perfil_id bigint not null,
    curso_id bigint not null,
    fecha datetime not null,

    primary key(id),

    constraint fk_consultas_perfil_id foreign key (perfil_id) references perfiles(id),
    constraint fk_consultas_curso_id foreign key (curso_id) references cursos(id)
);
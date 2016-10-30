create database add_a1;
use add_a1;

-- 1 a)
create table usuario (
  id int not null primary key auto_increment,
  email varchar(50) not null,
  senha varchar(15) not null,
  ativo int not null default 1
);

-- 1 b)
create table permissao (
  id int not null primary key auto_increment,
  descricao varchar(25)
);

-- 1 c)
alter table usuario
add id_permissao int not null
add foreign key(id_permissao) references permissao(id);

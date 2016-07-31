CREATE DATABASE IF NOT EXISTS cinema;

USE cinema;

CREATE TABLE filmes (
	titulo VARCHAR(50),
    categoria VARCHAR(55),
    duracao INT(5),
    diretor VARCHAR(100),
    sinopse TEXT,
	ano INT(4)
);

INSERT INTO filmes VALUES 
	('Pelé', 'Esporte', 128, 'Chavez', NULL, 2000),
    ('007', 'Ação', 100, 'Fulano', NULL, 2014),
    ('Mogli, o menino urso', 'Ação', 128, 'André Ursoglini', NULL, 2016),
    ('Esquadrão Suicida', 'Ação', 128, 'Fulano', NULL, 2016),
    ('Tarzan', 'Ação', 128, 'André Ursoglini', NULL, 2016);

SELECT f.titulo, f.duracao, f.ano FROM filmes f;
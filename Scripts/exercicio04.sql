USE cinema;

-- 1. Dropar as 2 colunas:

ALTER TABLE filmes 
DROP categoria,
DROP diretor;

-- 2. Criar as 2 novas tabelas:

CREATE TABLE diretores (
	id INT(5) NOT NULL PRIMARY KEY AUTO_INCREMENT,
	nome VARCHAR(50) NOT NULL
);

CREATE TABLE categorias (
	id INT(5) NOT NULL PRIMARY KEY AUTO_INCREMENT,
	nome VARCHAR(50) NOT NULL
);

-- 3. Popular as 2 tabelas:

INSERT diretores (nome) VALUES
	('Indefinido'),
    ('Fulano 1'),
    ('Fulano 2'),
    ('Fulano 3'),
    ('Fulano 4');
    
INSERT categorias VALUES
	(1, 'Indefinida'),
    (2, 'Terror'),
    (3, 'Romance'),
    (4, 'Comédia'),
    (5, 'Ação');

-- 4. Adicionar as 2 novas colunas:
-- 5. Criar suas respectivas chaves estrangeiras:
 
ALTER TABLE filmes
ADD id_categoria INT(5) NOT NULL DEFAULT 1,
ADD id_diretor INT(5) NOT NULL DEFAULT 1,
ADD CONSTRAINT fk_categoria FOREIGN KEY (id_categoria) REFERENCES categorias (id),
ADD CONSTRAINT fk_diretor FOREIGN KEY (id_diretor) REFERENCES diretores (id);

-- UPDATE filmes SET
-- id_categoria = 2,
-- id_diretor = 6
-- WHERE id = 2;
-- 
-- UPDATE filmes SET
-- id_categoria = 3,
-- id_diretor = 3
-- WHERE id = 3;
-- 
-- UPDATE filmes SET
-- id_categoria = 4,
-- id_diretor = 4
-- WHERE id = 4;
-- 
-- UPDATE filmes SET
-- id_categoria = 5,
-- id_diretor = 5
-- WHERE id = 5;
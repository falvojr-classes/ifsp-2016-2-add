CREATE DATABASE agenda;
USE agenda;

CREATE TABLE contatos (
    id INT UNSIGNED NOT NULL PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(50),
    email VARCHAR(50),
    telefone VARCHAR(20),
    data_nascimento DATE
);

CREATE TABLE enderecos (
    id INT UNSIGNED NOT NULL PRIMARY KEY AUTO_INCREMENT,
    logradouro VARCHAR(250) NOT NULL,
    numero VARCHAR(50) NOT NULL,
    complemento VARCHAR(250),
    cep VARCHAR(10) NOT NULL
);

ALTER TABLE enderecos
ADD id_contato INT UNSIGNED NOT NULL,
ADD CONSTRAINT fk_contato FOREIGN KEY (id_contato) REFERENCES contatos(id);

INSERT INTO contatos (nome, email, telefone, data_nascimento) 
VALUES ('teste', 'teste@teste', '999999999', '1989-07-10');

SELECT * FROM contatos;

INSERT INTO enderecos (logradouro, numero, complemento, cep, id_contato) 
VALUES ('teste', '1234', '', '14835-000', 1);

SELECT
c.id id_contato,
c.nome,
c.email,
c.telefone,
c.data_nascimento,
e.id id_endereco,
e.logradouro,
e.numero,
e.complemento,
e.cep
FROM contatos c 
JOIN enderecos e ON c.id = e.id_contato;

SELECT c.nome
FROM contatos c 
JOIN enderecos e ON c.id = e.id_contato
WHERE e.cep = '14835-000';
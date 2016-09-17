CREATE DATABASE agenda;
USE agenda;

CREATE TABLE contatos (
    id INT UNSIGNED NOT NULL PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(50),
    email VARCHAR(50),
    telefone VARCHAR(20),
    data_nascimento DATE
);

SELECT * FROM contatos;
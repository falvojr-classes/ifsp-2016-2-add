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

SELECT * FROM contatos;

SELECT * FROM enderecos;
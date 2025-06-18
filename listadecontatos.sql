CREATE DATABASE agenda_db;

USE agenda_db;

CREATE TABLE contatos (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    telefone VARCHAR(20) NOT NULL,
    email VARCHAR(100) NOT NULL
);

INSERT INTO contatos (nome, telefone, email) VALUES
('Maria Silva', '11999998888', 'maria@email.com'),
('João Souza', '11888887777', 'joao@email.com');
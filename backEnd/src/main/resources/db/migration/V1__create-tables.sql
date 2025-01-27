-- Tabela Banco
CREATE TABLE Banco (
    id SERIAL PRIMARY KEY,
    nome VARCHAR(50) NOT NULL
);

-- Tabela FormaPagamento
CREATE TABLE FormaPagamento (
    id SERIAL PRIMARY KEY,
    nome VARCHAR(50) NOT NULL
);

-- Tabela Status
CREATE TABLE Status (
    id SERIAL PRIMARY KEY,
    nome VARCHAR(50) NOT NULL
);

-- Tabela Responsavel
CREATE TABLE Responsavel (
    id SERIAL PRIMARY KEY,
    nome VARCHAR(50) NOT NULL
);

-- Tabela TipoTransacao
CREATE TABLE TipoTransacao (
    id SERIAL PRIMARY KEY,
    nome VARCHAR(50) NOT NULL
);

-- Tabela Carteira
CREATE TABLE Carteira (
    id SERIAL PRIMARY KEY,
    nome VARCHAR(50) NOT NULL
);

-- Tabela Mes
CREATE TABLE Mes (
    id SERIAL PRIMARY KEY,
    nome VARCHAR(20) NOT NULL,
    ano INT NOT NULL,
    carteira_id INT NOT NULL,
    FOREIGN KEY (carteira_id) REFERENCES Carteira(id)
);

-- Tabela Usuario
CREATE TABLE Usuario (
    id SERIAL PRIMARY KEY,
    nome VARCHAR(50) NOT NULL,
    data_nascimento DATE,
    email VARCHAR(100) NOT NULL,
    senha VARCHAR(255) NOT NULL
);

-- Tabela Usuario_Carteira (relação muitos-para-muitos entre Usuario e Carteira)
CREATE TABLE Usuario_Carteira (
    usuario_id INT NOT NULL,
    carteira_id INT NOT NULL,
    PRIMARY KEY (usuario_id, carteira_id), -- Chave composta
    FOREIGN KEY (carteira_id) REFERENCES Carteira(id),
    FOREIGN KEY (usuario_id) REFERENCES Usuario(id)
);

-- Tabela Transacao
CREATE TABLE Transacao (
    id SERIAL PRIMARY KEY,
    data DATE NOT NULL,
    descricao VARCHAR(255) NOT NULL,
    valor FLOAT NOT NULL,
    quantas_vezes INT NOT NULL,
    banco_id INT NOT NULL,
    forma_pagamento_id INT NOT NULL,
    status_id INT NOT NULL,
    responsavel_id INT NOT NULL,
    mes_id INT NOT NULL,
    tipo_transacao_id INT NOT NULL,
    FOREIGN KEY (banco_id) REFERENCES Banco(id),
    FOREIGN KEY (forma_pagamento_id) REFERENCES FormaPagamento(id),
    FOREIGN KEY (status_id) REFERENCES Status(id),
    FOREIGN KEY (responsavel_id) REFERENCES Responsavel(id),
    FOREIGN KEY (mes_id) REFERENCES Mes(id),
    FOREIGN KEY (tipo_transacao_id) REFERENCES TipoTransacao(id)
);

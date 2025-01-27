-- Inserindo Usuários
INSERT INTO Usuario (id,nome, data_nascimento, email, senha)
VALUES
(1,'Wilson', '1990-05-15', 'wilson@example.com', 'teste123'),
(2,'Gabrielle', '1995-08-25', 'gabrielle@example.com', 'teste123');

-- Inserindo Bancos
INSERT INTO Banco (nome)
VALUES
('Nubank'),
('Itau'),
('Picpay');

-- Inserindo Status
INSERT INTO Status (nome)
VALUES
('Pago'),
('Pendente');

-- Inserindo Wallets
INSERT INTO Carteira (id,nome)
VALUES
(1,'Carteira Wilson'),
(2,'Carteira Gabrielle');

-- Relacionando Usuários e Wallets
INSERT INTO Usuario_Carteira (carteira_id, usuario_id)
VALUES
(1, 1), -- Wilson com Carteira Wilson
(2, 2); -- Gabrielle com Carteira Gabrielle

-- Inserindo Meses
INSERT INTO Mes (nome, ano, carteira_id)
VALUES
('Janeiro', 2025, 1), -- Relacionado à Carteira Wilson
('Fevereiro', 2025, 2); -- Relacionado à Carteira Gabrielle

-- Inserindo Tipos de Transação
INSERT INTO TipoTransacao (nome)
VALUES
('Alimentação'),
('Educação'),
('Lazer');

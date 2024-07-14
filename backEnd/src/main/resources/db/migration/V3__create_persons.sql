/**
 * Author:  wilson
 * Created: Jul 13, 2024
 */
CREATE TABLE persons(
    id SERIAL PRIMARY KEY,
    name VARCHAR(50)
);

-- Supondo que a tabela transaction já existe, com a coluna client
ALTER TABLE transaction
RENAME COLUMN client TO id_person;

-- Supondo que a coluna id_person precisa ser do tipo inteiro
ALTER TABLE transaction
ALTER COLUMN id_person TYPE INT;

-- Adicionar a chave estrangeira e remover a coluna name
ALTER TABLE transaction
ADD CONSTRAINT fk_person
FOREIGN KEY (id_person) REFERENCES persons(id);

-- Se houver uma coluna name que precisa ser removida
ALTER TABLE transaction
DROP COLUMN name;

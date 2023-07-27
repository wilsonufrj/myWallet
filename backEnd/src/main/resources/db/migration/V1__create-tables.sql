/**
 * Author:  wilson
 * Created: Jul 26, 2023
 */
CREATE TABLE wallet(
    id SERIAL PRIMARY KEY,
    name VARCHAR(50),
    description VARCHAR(100)
);

CREATE TABLE health(
    id SERIAL PRIMARY KEY,
    credit_limit FLOAT,
    debit_limit FLOAT,
    close_month BOOLEAN,
    investiment FLOAT,
    id_wallet INT,

    FOREIGN KEY (id_wallet) REFERENCES wallet(id)
);

CREATE TABLE transaction(
    id SERIAL PRIMARY KEY,
    client VARCHAR(50),
    value FLOAT,
    name VARCHAR(50),
    date DATE,
    description VARCHAR(100),
    id_wallet INT,
    type_transaction INT,
    FOREIGN KEY (id_wallet) REFERENCES wallet(id)

);
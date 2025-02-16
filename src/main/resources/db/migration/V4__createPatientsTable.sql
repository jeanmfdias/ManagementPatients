CREATE TABLE patients (
    id BIGSERIAL PRIMARY KEY,
    name VARCHAR(100),
    cpf VARCHAR(15) UNIQUE,
    email VARCHAR(100) UNIQUE,
    phone VARCHAR(11),
    address_name VARCHAR(100) NOT NULL,
    neighborhood VARCHAR(100) NOT NULL,
    zipcode VARCHAR(9) NOT NULL,
    complement VARCHAR(100),
    number VARCHAR(10),
    city VARCHAR(100) NOT NULL,
    state CHAR(2) NOT NULL
);
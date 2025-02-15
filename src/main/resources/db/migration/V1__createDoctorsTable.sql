CREATE TABLE doctors (
    id BIGSERIAL PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    email VARCHAR(100) NOT NULL UNIQUE,
    crm VARCHAR(6) NOT NULL UNIQUE,
    specialty VARCHAR(100) NOT NULL,
    phone VARCHAR(20) NOT NULL,
    address_name VARCHAR(100) NOT NULL,
    neighborhood VARCHAR(100) NOT NULL,
    zipcode VARCHAR(9) NOT NULL,
    complement VARCHAR(100),
    number VARCHAR(10),
    city VARCHAR(100) NOT NULL,
    state CHAR(2) NOT NULL
);
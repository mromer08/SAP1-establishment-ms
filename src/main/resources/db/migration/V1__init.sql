-- Tabla base para Establecimientos
CREATE TABLE establishments (
    id UUID PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    address VARCHAR(500) NOT NULL,
    city VARCHAR(100) NOT NULL,
    phone_number VARCHAR(20) NOT NULL,
    email VARCHAR(255),
    nit VARCHAR(20) NOT NULL,
    active BOOLEAN NOT NULL DEFAULT TRUE
);

-- Tabla para Hoteles (hereda de establishments)
CREATE TABLE hotels (
    id UUID PRIMARY KEY REFERENCES establishments(id),
    has_pool BOOLEAN,
    has_gym BOOLEAN
);

-- Tabla base para Offerings
CREATE TABLE offerings (
    id UUID PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    description TEXT,
    production_cost DECIMAL(10,2) NOT NULL,
    sale_price DECIMAL(10,2) NOT NULL,
    establishment_id UUID NOT NULL REFERENCES establishments(id)
);

-- Tabla para Habitaciones de Hotel (hereda de offerings)
CREATE TABLE hotel_rooms (
    id UUID PRIMARY KEY REFERENCES offerings(id),
    capacity INTEGER NOT NULL,
    has_tv BOOLEAN
);
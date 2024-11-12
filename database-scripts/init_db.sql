CREATE TABLE IF NOT EXISTS clientes (
    id SERIAL PRIMARY KEY,
    codigo_unico VARCHAR(255) NOT NULL UNIQUE,
    nombres VARCHAR(100) NOT NULL,
    apellido_paterno VARCHAR(100) NOT NULL,
    apellido_materno VARCHAR(100) NOT NULL,
    tipo_documento VARCHAR(20) NOT NULL,
    numero_documento VARCHAR(50) NOT NULL UNIQUE,
    activo BOOLEAN DEFAULT TRUE
);


CREATE TABLE IF NOT EXISTS productos_financieros (
    id SERIAL PRIMARY KEY,
    tipo_producto VARCHAR(50) NOT NULL,
    nombre VARCHAR(100) NOT NULL,
    activo BOOLEAN DEFAULT TRUE
);


CREATE TABLE IF NOT EXISTS producto_cliente (
    id SERIAL PRIMARY KEY,
    cliente_id INT REFERENCES clientes(id),
    producto_id INT REFERENCES productos_financieros(id),
    saldo DECIMAL(15, 2) NOT NULL,
    activo BOOLEAN DEFAULT TRUE
);


INSERT INTO clientes (codigo_unico, nombres, apellido_paterno, apellido_materno, tipo_documento, numero_documento, activo) VALUES
('ABC123', 'Juan', 'Pérez', 'García', 'DNI', '12345678', true),
('DEF456', 'María', 'González', 'Rodríguez', 'DNI', '87654321', true),
('GHI789', 'Luis', 'Ramírez', 'Fernández', 'CE', '11223344', true),
('JKL012', 'Ana', 'Martínez', 'López', 'DNI', '55667788', false);

INSERT INTO productos_financieros (tipo_producto, nombre, activo) VALUES
('Cuenta de Ahorros', 'Cuenta de Ahorros Clásica', true),
('Cuenta de Ahorros', 'Cuenta de Ahorros Premium', true),
('Tarjeta de Crédito', 'Tarjeta Visa Oro', true),
('Tarjeta de Crédito', 'Tarjeta Mastercard Platinum', false),  -- Producto inactivo
('Préstamo Personal', 'Préstamo Personal Básico', true);

INSERT INTO producto_cliente (cliente_id, producto_id, saldo, activo) VALUES
(1, 1, 5000.00, true),
(1, 3, 1500.00, true),
(2, 2, 3000.00, true),
(3, 5, 10000.00, true),
(4, 1, 2500.00, true);
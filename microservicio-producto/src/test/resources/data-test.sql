-- Crear un cliente ficticio
INSERT INTO clientes (id, codigo_unico, nombres, apellido_paterno, apellido_materno, tipo_documento, numero_documento, activo)
VALUES (1, '12345', 'Juan', 'Perez', 'Gomez', 'DNI', '12345678', true);

-- Crear un producto financiero ficticio
INSERT INTO productos_financieros (id, tipo_producto, nombre, activo)
VALUES (1, 'Ahorro', 'Cuenta de Ahorro', true);
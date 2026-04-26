
INSERT INTO clientes (nombre, apellidos, email, telefono, direccion, fecha_registro) VALUES
('Daniel', 'Meco', 'dmeco@prometeo.com', '611494801', 'Calle la Noguera 22, Valencia', '2026-04-01'),
('Yago', 'Gomez', 'ygomez@prometeo.com', '612345678', 'Avenida del Puerto 45, Valencia', '2026-04-02'),
('Izan', 'Perez', 'iperez@prometeo.com', '701234567', 'Calle Colon 8, Valencia', '2026-04-03');

INSERT INTO categorias (nombre, descripcion) VALUES
('Frigorificos', 'Electrodomesticos de refrigeracion'),
('Lavadoras', 'Electrodomesticos para lavado de ropa'),
('Microondas', 'Electrodomesticos para calentar alimentos'),
('Pequeno Electrodomestico', 'Electrodomesticos pequenos para el hogar');

INSERT INTO productos (id_categoria, nombre, descripcion, precio, stock) VALUES
(1, 'Frigorifico Bosch KGN39', 'Frigorifico combi de 2 metros', 799.99, 10),
(2, 'Lavadora LG F4WV', 'Lavadora de carga frontal 9 kg', 499.99, 15),
(3, 'Microondas Samsung MG23', 'Microondas con grill 23L', 129.99, 20),
(4, 'Cafetera DeLonghi EC230', 'Cafetera espresso manual', 159.99, 8),
(4, 'Aspiradora Rowenta XNano', 'Aspiradora sin bolsa compacta', 189.99, 12);

INSERT INTO pedidos (id_cliente, fecha_pedido, estado, total) VALUES
(1, '2026-04-10', 'Pendiente', 1458.97),
(2, '2026-04-11', 'Enviado', 129.99),
(3, '2026-04-12', 'Pagado', 349.98);

INSERT INTO detalle_pedido (id_pedido, id_producto, cantidad, precio_unitario, subtotal) VALUES
(1, 2, 2, 499.99, 999.98),
(1, 4, 1, 159.99, 159.99),
(1, 5, 1, 189.99, 189.99),
(1, 3, 1, 129.99, 129.99),
(2, 3, 1, 129.99, 129.99),
(3, 4, 1, 159.99, 159.99),
(3, 5, 1, 189.99, 189.99);

INSERT INTO pagos (id_pedido, fecha_pago, metodo_pago, importe, estado_pago) VALUES
(2, '2026-04-11', 'Tarjeta', 129.99, 'Pagado'),
(3, '2026-04-12', 'PayPal', 349.98, 'Pagado');
#1. Ver todos los clientes
SELECT * FROM clientes;

#2. Ver todos los productos con su categoría
SELECT p.id_producto, p.nombre AS producto, c.nombre AS categoria, p.precio, p.stock
FROM productos p
JOIN categorias c ON p.id_categoria = c.id_categoria;

#3. Ver todos los pedidos con el nombre del cliente
SELECT pe.id_pedido, pe.fecha_pedido, pe.estado, pe.total, c.nombre, c.apellidos
FROM pedidos pe
JOIN clientes c ON pe.id_cliente = c.id_cliente;

#4. Ver el detalle de un pedido
SELECT dp.id_producto , dp.id_pedido, p.nombre AS producto, dp.cantidad, dp.precio_unitario, dp.subtotal
FROM detalle_pedido dp
JOIN productos p ON dp.id_producto = p.id_producto
WHERE dp.id_pedido = 1;

#5. Ver pedidos con pago realizado
SELECT pe.id_pedido, pe.fecha_pedido, pe.total, pa.metodo_pago, pa.estado_pago
FROM pedidos pe
JOIN pagos pa ON pe.id_pedido = pa.id_pedido;

#6. Buscar productos con stock bajo
SELECT * 
FROM productos
WHERE stock < 10;

#7. Total gastado por cada cliente
SELECT c.id_cliente, c.nombre, c.apellidos, SUM(pe.total) AS total_gastado
FROM clientes c
JOIN pedidos pe ON c.id_cliente = pe.id_cliente
GROUP BY c.id_cliente, c.nombre, c.apellidos;
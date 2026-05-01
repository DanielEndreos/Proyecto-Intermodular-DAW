# Programación - ElectroHogar

## Descripción

En esta parte del proyecto se ha creado una aplicación Java por consola para gestionar datos internos de la tienda ElectroHogar.

La aplicación se conecta a la base de datos `electrohogar` mediante JDBC y permite trabajar con datos reales de clientes, productos, pedidos y pagos.

## Funcionalidades principales

### Productos

- Listar productos.
- Buscar productos por nombre.
- Crear nuevos productos.
- Modificar productos existentes.
- Eliminar productos.

### Clientes

- Listar clientes.
- Crear clientes.
- Modificar clientes.
- Eliminar clientes.

### Pedidos

- Listar pedidos.
- Consultar pedidos de un cliente.
- Crear pedidos con varios productos.
- Cambiar el estado de un pedido.
- Eliminar pedidos.

### Pagos

- Listar pagos.
- Registrar pagos.
- Cambiar automáticamente el estado del pedido a `Pagado` cuando se registra un pago.

## Uso de JDBC

La conexión se realiza desde la clase `ConexionBD`, usando `DriverManager` y el conector de MariaDB.

Las operaciones de base de datos están separadas en clases DAO:

- `ClienteDAO`
- `ProductoDAO`
- `PedidoDAO`
- `PagoDAO`

Cada DAO contiene las consultas SQL necesarias para trabajar con su tabla correspondiente.

## Operaciones CRUD

El proyecto incluye operaciones reales de:

- Insertar datos.
- Consultar datos.
- Modificar datos.
- Eliminar datos.

Estas operaciones se hacen directamente contra la base de datos `electrohogar`.

## Gestión de errores

Se usa manejo básico de errores mediante:

- `SQLException` para errores de base de datos.
- `IllegalArgumentException` para datos introducidos incorrectamente.
- Validaciones en los servicios antes de enviar datos a la base de datos.

## Conclusión

Esta parte cumple la función de motor interno del proyecto. La web muestra la tienda por fuera, y esta aplicación permite gestionar parte de los datos internos de la empresa.

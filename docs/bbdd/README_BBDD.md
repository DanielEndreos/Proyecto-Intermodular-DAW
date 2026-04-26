# ElectroHogar

## Descripción del proyecto
ElectroHogar es una empresa ficticia dedicada a la venta de electrodomésticos para el hogar, tanto grandes como pequeños, como por ejemplo frigoríficos, lavadoras, hornos, microondas, cafeteras o aspiradoras.

Este proyecto forma parte del módulo de **Bases de Datos** del Proyecto Intermodular de 1º de DAW. Su objetivo es diseñar una base de datos sencilla y coherente para representar el funcionamiento básico de una tienda online de electrodomésticos.

---

## Análisis de datos

### Tipo de empresa
Se trata de una empresa ficticia dedicada a la venta de electrodomésticos para el hogar.

### Información que maneja el negocio
La tienda necesita almacenar información sobre:
- clientes
- productos
- categorías de productos
- pedidos
- detalle de cada pedido
- pagos
- stock

### Entidades principales

#### 1. Clientes
Guarda la información de las personas que compran en la tienda.

| Clientes |
| ------------- |
| id_cliente (PK) |
| nombre |
| apellidos |
| email |
| telefono |
| direccion |
| fecha_registro |

#### 2. Categorias
Guarda las distintas clasificaciones de los productos de la tienda.

| Categorias |
| ------------- |
| id_categoria (PK) |
| nombre |
| descripcion |

#### 3. Productos
Guarda la información de los productos que se venden en la tienda.

| Productos |
| ------------- |
| id_producto (PK) |
| id_categoria (FK) |
| nombre |
| descripcion |
| precio |
| stock |

#### 4. Pedidos
Guarda los pedidos realizados por los clientes.

| Pedidos |
| ------------- |
| id_pedido (PK) |
| id_cliente (FK) |
| fecha_pedido |
| estado |
| total |

#### 5. Detalle_Pedido
Relaciona cada pedido con los productos comprados.

| Detalle_Pedido |
| ------------- |
| id_pedido (FK), id_producto (FK) -> (PK) |
| cantidad |
| precio_unitario |
| subtotal |

#### 6. Pagos
Registra el pago asociado a un pedido.

| Pagos |
| ------------- |
| id_pago (PK) |
| id_pedido (FK) |
| fecha_pago |
| metodo_pago |
| importe |
| estado_pago |
---

## Relaciones entre entidades

Las relaciones principales de la base de datos son las siguientes:

- Un **cliente** puede realizar **varios pedidos**, pero cada **pedido** pertenece a un único cliente.
- Una **categoria** puede incluir **varios productos**, pero cada **producto** pertenece a una sola categoria.
- Un **pedido** puede contener **varios productos**, y un **producto** puede aparecer en **varios pedidos**.  
  De esta relación nace **Detalle_Pedido**, que resuelve la relación N:M y además guarda información adicional como la cantidad, el precio unitario y el subtotal.
- Un **pedido** puede tener asociado **un pago**, y cada **pago** corresponde a un único pedido.

---

## Justificación del diseño
He elegido estas tablas porque creo que son las necesarias para que una tienda de electrodomésticos funcione de forma básica.

La tabla de **clientes** es importante porque ahí se guardan los datos de las personas que compran en la tienda. La tabla de **productos** también es necesaria, ya que en ella se guarda la información de los artículos que se venden, como el nombre, el precio o el stock disponible.

He añadido también **categorias** para poder organizar mejor los productos, por ejemplo separando lavadoras, frigoríficos o microondas. Así la base de datos queda más ordenada.

La tabla de **pedidos** sirve para registrar las compras que hace cada cliente. Como en un mismo pedido puede haber varios productos, hace falta otra tabla llamada **detalle_pedido**, que es la que relaciona los pedidos con los productos y guarda la cantidad de cada uno.

Por último, he añadido **pagos** para tener guardada la información de si un pedido se ha pagado o no, cuánto se ha pagado y el método de pago.

He hecho el diseño de esta forma porque me ha parecido la manera más simple y lógica de representar una tienda online sin complicarlo demasiado.

---

## Estructura de la base de datos
La base de datos está formada por las siguientes tablas:
- clientes
- categorias
- productos
- pedidos
- detalle_pedido
- pagos

---

## Archivos incluidos
Este proyecto incluye:
- diagrama E/R
- modelo relacional
- script SQL de creación de tablas
- script SQL de inserción de datos
- script SQL de consultas

---

## Tecnologías utilizadas
- SQL
- MariaDB / MySQL
- DBeaver 26.0.3

---

## Cómo ejecutar el proyecto
1. Crear la base de datos `electrohogar`.
2. Ejecutar el script de creación de tablas.
3. Ejecutar el script de inserción de datos.
4. Ejecutar las consultas SQL para comprobar el funcionamiento.

---
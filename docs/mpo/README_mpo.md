# MPO - Ampliación de Programación

## Objetivo

En el MPO se ha mejorado la estructura de la aplicación para que no sea solo un programa que funciona, sino un proyecto más ordenado y mantenible.

La mejora principal ha sido separar el código en capas y aplicar programación orientada a objetos de forma sencilla.

## Estructura aplicada

El código se ha organizado en varios paquetes:

### model

Contiene las clases que representan los datos principales del proyecto:

- `Cliente`
- `Producto`
- `Pedido`
- `DetallePedido`
- `Pago`

Estas clases tienen atributos privados, constructores, getters, setters y métodos `toString()`.

### dao

Contiene las clases que hablan directamente con la base de datos.

Aquí se escriben las consultas SQL y se usan `PreparedStatement` y `ResultSet`.

### service

Contiene la lógica intermedia y las validaciones básicas.

Por ejemplo:

- comprobar que un cliente tenga nombre y email
- comprobar que el precio de un producto sea correcto
- comprobar que un pedido tenga productos
- comprobar que los ids sean válidos

### view

Contiene el menú de consola.

El usuario no trabaja directamente con los DAO, sino con un menú simple que llama a los servicios.

### util

Contiene la clase de conexión a la base de datos.

## Mejora MPO realizada

La mejora elegida para el MPO ha sido:

> Refactorizar el proyecto para separar la lógica en capas y añadir validaciones de datos.

Esto permite que el código sea más claro y que cada clase tenga una responsabilidad concreta.

## Por qué mejora el proyecto

Si todo el código estuviera dentro del `main`, sería difícil de leer y de ampliar.

Con esta estructura:

- el menú solo muestra opciones
- los servicios validan datos
- los DAO trabajan con SQL
- los modelos representan entidades
- la conexión queda centralizada

Esto hace que el proyecto sea más parecido a una aplicación real, pero sin complicarlo más de lo necesario.

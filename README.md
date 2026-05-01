# ElectroHogar - Proyecto Intermodular DAW 1º

## Descripción del proyecto

ElectroHogar es un proyecto intermodular realizado para 1º de Desarrollo de Aplicaciones Web.

El proyecto simula una tienda de electrodomésticos. La idea principal es tener una web corporativa donde se muestra la empresa, sus productos y su información de contacto, junto con una base de datos que representa la parte interna del negocio.

Además, se ha desarrollado una aplicación en Java por consola conectada a la base de datos mediante JDBC. Esta aplicación permite gestionar datos reales de la tienda, como productos, clientes, pedidos y pagos.

El objetivo del proyecto es unir varios módulos del curso en un mismo trabajo práctico.

---

## Módulos incluidos

El proyecto incluye trabajo de los siguientes módulos:

- Lenguajes de Marcas
- Bases de Datos
- Programación
- MPO / Ampliación de Programación
- Sistemas Informáticos
- Entornos de Desarrollo

La parte de Itinerario Personal para la Empleabilidad no se incluye porque está convalidada.

---

## Tecnologías utilizadas

- HTML5
- CSS3
- Java
- JDBC
- MariaDB
- Maven
- Git y GitHub
- DBeaver
- XAMPP
- IntelliJ IDEA
- Ubuntu en máquina virtual

---

## Estructura del proyecto

```text
Proyecto-Intermodular-DAW/
│
├── docs/
│   ├── bbdd/
│   ├── mpo/
│   ├── prog/
│   └── sistemas/
│
├── java/
│   └── src/
│   └── target/
|   └── pom.xml
|
├── web/
│   ├── assets/
│   ├── index.html
│   ├── productos.html
│   ├── nosotros.html
│   ├── contacto.html
│   └── style.css
│
├── .gitignore
└── README.md
```

---

## Parte web

La carpeta `web` contiene la página corporativa de ElectroHogar.

Incluye:

- Página de inicio.
- Catálogo de productos.
- Página sobre la empresa.
- Página de contacto.
- Formulario básico.
- Mapa de localización.
- Diseño responsive básico.

Para abrir la web solo hay que entrar en la carpeta `web` y ejecutar el archivo:

```text
index.html
```

---

## Base de datos

La parte de base de datos está dentro de:

```text
docs/bbdd/
```

Incluye los archivos necesarios para crear y probar la base de datos:

```text
Backup_BBDD.sql
Consulta.sql
Creacion_BBDD.sql
Introduccion_Datos.sql
```

La base de datos se llama:

```text
electrohogar
```

Tablas principales:

- categorias
- productos
- clientes
- pedidos
- detalle_pedido
- pagos

La base de datos representa el funcionamiento básico de una tienda de electrodomésticos, con clientes que realizan pedidos formados por productos.

---

## Aplicación Java

La aplicación Java está dentro de la carpeta:

```text
java/
```

Es una aplicación por consola conectada a MariaDB mediante JDBC.

Permite realizar operaciones sobre la base de datos, como:

- Listar productos.
- Crear productos.
- Modificar productos.
- Eliminar productos.
- Gestionar clientes.
- Crear pedidos.
- Consultar pedidos.
- Gestionar pagos.

La aplicación está organizada por paquetes para que el código sea más claro y fácil de mantener.

---

## Conexión con la base de datos

La conexión JDBC se configura en la clase de conexión del proyecto Java.

Los datos usados por defecto son:

```text
Base de datos: electrohogar
Usuario: root
Contraseña:
Servidor: localhost
Puerto: 3306
```

Para que funcione correctamente, primero debe estar iniciada la base de datos en XAMPP o en el servidor MariaDB correspondiente.

---

## Organización del código Java

El código Java está separado en varias partes:

- `model`: clases que representan los datos del proyecto.
- `dao`: clases encargadas de acceder a la base de datos.
- `service`: clases con la lógica principal del programa.
- `view`: menú de consola e interacción con el usuario.
- `util`: conexión con la base de datos.

Esta separación se ha hecho para que el proyecto no esté todo mezclado en el `main` y sea más fácil de entender.

---

## MPO - Mejora de programación

La parte de MPO se ha trabajado mejorando la estructura del código Java.

La mejora principal ha sido separar el proyecto por capas:

```text
model - dao - service - view - util
```

También se han usado clases, objetos, constructores, métodos y encapsulación mediante atributos privados y getters/setters.

---

## Sistemas Informáticos

La documentación de Sistemas Informáticos está en:

```text
docs/sistemas/
```

En esta parte se explica el entorno donde podría ejecutarse el proyecto:

- Sistema operativo recomendado.
- Requisitos mínimos.
- Instalación del entorno.
- Uso de XAMPP, DBeaver y Java.
- Organización de carpetas.
- Mantenimiento básico.

---

## Cómo ejecutar el proyecto

### 1. Importar la base de datos

Abrir DBeaver, phpMyAdmin o cualquier gestor compatible con MariaDB y ejecutar los scripts SQL de la carpeta:

```text
docs/bbdd/
```

Orden recomendado:

```text
Creacion_BBDD.sql
Introduccion_Datos.sql
Consulta.sql
```

También se puede usar directamente:

```text
Backup_BBDD.sql
```

---

### 2. Ejecutar la web

Abrir el archivo:

```text
web/index.html
```

desde el navegador.

---

### 3. Ejecutar la aplicación Java

Abrir el proyecto Java desde IntelliJ IDEA.

Comprobar que MariaDB está iniciado y que la base de datos `electrohogar` existe.

Después ejecutar la clase principal del proyecto.

---

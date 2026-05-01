# Sistemas Informáticos - ElectroHogar

## Informe técnico del entorno de ejecución

### 1. Tipo de sistema donde se ejecuta

Para este proyecto he decidido usar una **máquina virtual en VMware**. Dentro de esa máquina virtual se utilizará un sistema operativo **Linux**, donde se instalarán las herramientas necesarias para probar y ejecutar el proyecto.

He elegido esta opción porque permite trabajar en un entorno separado del sistema principal. De esta forma, si hay algún problema instalando programas o configurando servicios, no afecta directamente al ordenador principal.

También me parece una opción adecuada para un proyecto académico, porque permite tener el entorno más controlado y ordenado.

---

### 2. Sistema operativo recomendado

El sistema operativo elegido es **Ubuntu 26.04 LTS**.

Lo he elegido porque es un sistema bastante utilizado, tiene buena documentación y es compatible con las herramientas que se usan en el proyecto, como Java, Maven, XAMPP y DBeaver.

No he usado una distribución más compleja porque para este proyecto no hace falta. La idea es tener un entorno sencillo, estable y fácil de mantener.

---

### 3. Requisitos de hardware

Como el proyecto se ejecuta dentro de una máquina virtual, hay que reservar recursos suficientes para que Ubuntu y las herramientas funcionen correctamente.

#### Requisitos mínimos

- **Procesador:** 2 núcleos
- **Memoria RAM:** 4 GB
- **Almacenamiento libre:** 25 GB
- **Conexión a internet:** necesaria para descargar programas y dependencias
- **Pantalla:** resolución mínima de 1366x768

#### Requisitos recomendados

- **Procesador:** 4 núcleos
- **Memoria RAM:** 8 GB o más
- **Almacenamiento libre:** 40 GB o más
- **Conexión a internet:** recomendable para instalación y actualizaciones
- **Pantalla:** resolución 1920x1080

#### Periféricos

- Teclado
- Ratón
- Monitor

Con estos requisitos es suficiente para ejecutar la máquina virtual, la base de datos, la aplicación Java y revisar la web del proyecto.

---

### 4. Herramientas utilizadas

Para preparar el entorno del proyecto se utilizan las siguientes herramientas:

- **VMware:** para crear y ejecutar la máquina virtual.
- **Ubuntu 26.04 LTS:** sistema operativo usado dentro de la máquina virtual.
- **XAMPP 8.0.30:** para disponer de MariaDB y poder trabajar con la base de datos.
- **DBeaver 26.0.3:** para gestionar la base de datos de forma visual.
- **Java JDK:** para ejecutar la aplicación de programación.
- **Maven:** para gestionar y ejecutar el proyecto Java.
- **Visual Studio Code o IntelliJ IDEA:** para editar el código.
- **Git:** para controlar versiones del proyecto.

---

### 5. Instalación del entorno

La instalación del entorno se haría en este orden:

#### 1. Instalar VMware

Primero se instala VMware en el ordenador principal.

#### 2. Crear la máquina virtual

Después se crea una nueva máquina virtual, asignando memoria RAM, procesador y espacio en disco.

#### 3. Instalar Ubuntu 26.04 LTS

Una vez creada la máquina virtual, se instala Ubuntu como sistema operativo.

#### 4. Actualizar el sistema

Después de instalar Ubuntu, conviene actualizar el sistema con las actualizaciones disponibles.

#### 5. Instalar XAMPP

Se instala XAMPP para poder usar MariaDB en local. En este proyecto se usa principalmente para la base de datos.

#### 6. Instalar DBeaver

Se instala DBeaver para poder crear, consultar y revisar la base de datos del proyecto de forma más cómoda.

#### 7. Instalar Java y Maven

Se instala Java para poder ejecutar la aplicación de consola, y Maven para gestionar las dependencias del proyecto.

#### 8. Copiar el proyecto

Después se copia el proyecto dentro de la máquina virtual o se clona desde GitHub.

#### 9. Importar la base de datos

Se ejecutan los scripts SQL incluidos en el proyecto para crear la base de datos `electrohogar`, sus tablas y los datos de prueba.

---

### 6. Cómo se ejecuta el proyecto

Para ejecutar el proyecto habría que hacer lo siguiente:

1. Iniciar VMware.
2. Arrancar la máquina virtual con Ubuntu.
3. Iniciar XAMPP y activar MariaDB.
4. Abrir DBeaver y comprobar que la base de datos `electrohogar` existe.
5. Importar los scripts SQL si todavía no se han ejecutado.
6. Abrir la carpeta `web` y ejecutar `index.html` en el navegador.
7. Abrir el proyecto Java.
8. Ejecutar la aplicación Java por consola.
9. Comprobar que la aplicación se conecta correctamente a la base de datos.

La web no necesita un servidor complejo, porque está realizada con HTML y CSS. Se puede abrir directamente desde el navegador.

La parte Java sí necesita que MariaDB esté funcionando, porque usa JDBC para acceder a la base de datos.

---

### 7. Usuarios, permisos y estructura

#### Usuarios

En este proyecto se utiliza un usuario principal dentro de Ubuntu. Ese usuario se encarga de instalar programas, configurar el entorno y ejecutar el proyecto.

Como es un proyecto académico, no se ha planteado una gestión avanzada de usuarios.

#### Permisos

El usuario principal tendrá permisos para:

- Instalar programas.
- Modificar archivos del proyecto.
- Ejecutar scripts SQL.
- Iniciar y detener MariaDB.
- Ejecutar la aplicación Java.
- Editar la documentación.

#### Estructura de carpetas

La estructura principal del proyecto es la siguiente:

```text
Proyecto-Intermodular-DAW/
│
├── docs/
│   ├── bbdd/
│   │   ├── diagramas/
│   │   ├── Backup_BBDD.sql
│   │   ├── Consulta.sql
│   │   ├── Creacion_BBDD.sql
│   │   ├── Introduccion_Datos.sql
│   │   └── README_BBDD.md
│   │
│   ├── mpo/
│   │   └── README_mpo.md
│   │
│   ├── prog/
│   │   └── README_programacion.md
│   │
│   └── sistemas/
│       └── README_sistemas.md
│
├── java/
│   ├── src/
│   ├── pom.xml
│   └── README.md
│
├── web/
│   ├── assets/
│   ├── index.html
│   ├── productos.html
│   ├── nosotros.html
│   ├── contacto.html
│   ├── style.css
│   └── README.md
│
├── .gitignore
└── README.md
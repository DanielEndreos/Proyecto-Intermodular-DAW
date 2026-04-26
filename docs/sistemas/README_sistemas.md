# Sistemas Informáticos - ElectroHogar

## Informe técnico del entorno de ejecución

### 1. Tipo de sistema donde se ejecuta

Para este proyecto he decidido usar una **máquina virtual en VMware**. Dentro de esa máquina virtual voy a instalar un sistema operativo **Linux**, y ahí montaré todo el entorno del proyecto.

He elegido esta opción porque me parece más cómoda para trabajar y también porque así no mezclo todo con mi sistema principal. Si algo falla o se rompe algo al instalar programas, no afecta directamente al ordenador principal.

Además, para un proyecto de este tipo me parece una opción bastante buena, porque permite tener todo más ordenado y hacer pruebas sin liarla demasiado.

---

### 2. Sistema operativo recomendado

El sistema operativo que voy a usar es **Ubuntu 26.04 LTS**.

Lo he elegido porque es bastante conocido, tiene mucha documentación y suele usarse bastante en entornos de desarrollo. También me viene bien porque es compatible con las herramientas que voy a usar en el proyecto, como **XAMPP** y **DBeaver**.

No he querido complicarme con otros sistemas más raros porque la idea era tener algo estable, simple y que funcione.

---

### 3. Requisitos de hardware

Como el proyecto se va a ejecutar dentro de una máquina virtual, hay que tener en cuenta tanto el sistema operativo como los programas que se van a utilizar.

#### Requisitos mínimos
- **Procesador:** 2 núcleos
- **Memoria RAM:** 4 GB
- **Almacenamiento libre:** 25 GB
- **Conexión a internet:** necesaria para descargar programas
- **Pantalla:** resolución mínima de 1366x768

#### Requisitos recomendados
- **Procesador:** 4 núcleos
- **Memoria RAM:** 8 GB o más
- **Almacenamiento libre:** 40 GB o más
- **Conexión a internet:** recomendable para instalación y actualizaciones
- **Pantalla:** resolución 1920x1080

#### Periféricos
- teclado
- ratón
- monitor

Con esto debería ser suficiente para mover la máquina virtual, Ubuntu y los programas del proyecto sin demasiados problemas.

---

### 4. Instalación del entorno

La instalación del entorno se haría en este orden:

#### 1. Instalar VMware
Primero hay que instalar **VMware**, que será el programa que permitirá crear y arrancar la máquina virtual.

#### 2. Crear la máquina virtual
Después se crea una máquina virtual nueva, asignándole procesador, memoria RAM y espacio en disco.

#### 3. Instalar Ubuntu 26.04 LTS
Una vez creada la máquina virtual, se instala **Ubuntu 26.04 LTS** dentro de ella.

#### 4. Actualizar el sistema
Después de instalar Ubuntu, conviene actualizar el sistema para evitar problemas y tener todo más al día.

#### 5. Instalar XAMPP 8.0.30
Luego se instala **XAMPP 8.0.30**, que servirá para tener un entorno local con:
- Apache
- MariaDB
- PHP
- Perl

Esto será útil para poder ejecutar la parte web en local y también para trabajar con la base de datos.

#### 6. Instalar DBeaver 26.0.3
Después se instala **DBeaver 26.0.3**, que será el programa que usaré para gestionar la base de datos del proyecto.

Con DBeaver podré:
- crear tablas
- insertar datos
- ejecutar consultas
- revisar la base de datos

#### 7. Instalar un editor de código
También hará falta instalar un editor de código, como por ejemplo **Visual Studio Code**, para poder trabajar con los archivos del proyecto.

#### 8. Copiar el proyecto
Después se copia el proyecto dentro de la máquina virtual, manteniendo la estructura de carpetas correspondiente.

#### 9. Ejecutar los scripts SQL
Por último, se ejecutan los scripts SQL para:
- crear la base de datos
- crear las tablas
- insertar datos
- probar consultas

---

### 5. Cómo se ejecuta

Para ejecutar el proyecto habría que hacer lo siguiente:

1. Iniciar VMware  
2. Arrancar la máquina virtual  
3. Iniciar Ubuntu  
4. Abrir XAMPP y arrancar los servicios necesarios  
5. Abrir DBeaver para trabajar con la base de datos  
6. Abrir el proyecto en el editor de código  
7. Ejecutar la parte web en local  
8. Comprobar que la base de datos funciona correctamente  

De esta forma todo el proyecto queda montado dentro de la máquina virtual y no depende del sistema principal.

---

### 6. Usuarios, permisos y estructura

#### Usuarios
En este proyecto se trabajará con un usuario principal dentro del sistema Linux. Ese usuario será el encargado de instalar programas, configurar el entorno y ejecutar el proyecto.

Como es un proyecto académico, no he planteado varios usuarios distintos ni una gestión compleja de permisos, porque para este caso no hace falta tanto.

#### Permisos
El usuario principal tendrá permisos para:
- instalar programas
- modificar archivos del proyecto
- ejecutar scripts SQL
- iniciar o detener servicios

#### Estructura de carpetas
La estructura del proyecto es la siguiente:

```text
PROYECTO-INTERMODULAR-DAW
│── .vscode
│── docs
│   ├── bbdd
│   │   ├── diagramas
│   │   │   ├── BBDD - ER.drawio
│   │   │   ├── BBDD - ER.webp
│   │   │   └── BBDD - Relacional.bmp
│   │   ├── sql
│   │   │   ├── Backup BBDD.sql
│   │   │   ├── Consultas.sql
│   │   │   ├── Creación BBDD.sql
│   │   │   └── Introducción Datos.sql
│   │   └── README_BBDD.md
│   └── sistemas
│       └── README_sistemas.md
│── src
│── tienda
│── web
│   ├── assets
│   │   └── images
│   │       ├── aspiradora.png
│   │       ├── cafetera.png
│   │       ├── frigorifico.png
│   │       ├── lavadora.png
│   │       ├── logo.png
│   │       ├── microondas.png
│   │       └── tienda.png
│   ├── contacto.html
│   ├── index.html
│   ├── nosotros.html
│   ├── productos.html
│   ├── README.md
│   └── style.css
│── .gitattributes
│── .gitignore
│── README.md
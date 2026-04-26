# Sistemas Informáticos - ElectroHogar

## Informe técnico del entorno de ejecución

### 1. Tipo de sistema donde se ejecuta

Para este proyecto he decidido usar una **máquina virtual en VMware**. Dentro de esa máquina virtual voy a instalar un sistema operativo **Linux**, y ahí es donde se montará todo el entorno del proyecto.

---

### 2. Sistema operativo recomendado

El sistema operativo que voy a usar es **Ubuntu 26.04 LTS**.

Lo he elegido porque es compatible con las herramientas que voy a utilizar en el proyecto, como **XAMPP** y **DBeaver**, y porque Linux se usa bastante en entornos de desarrollo, ya que es un sistema operativo de código abierto.

---

### 3. Requisitos de hardware

Como el proyecto se va a ejecutar dentro de una máquina virtual, hay que tener en cuenta tanto el sistema operativo como los programas que se van a usar.

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

Con esto sería suficiente para mover la máquina virtual, el sistema operativo y los programas del proyecto sin demasiados problemas.

---

### 4. Instalación del entorno

La instalación del entorno se haría en este orden:

#### 1. Instalar VMware
Primero hay que instalar **VMware**, que será el programa que me permitirá crear la máquina virtual.

#### 2. Crear la máquina virtual
Después se crea una nueva máquina virtual, asignándole memoria RAM, procesador y espacio en disco.

#### 3. Instalar Ubuntu 26.04 LTS
Una vez creada la máquina virtual, se instala **Ubuntu 26.04 LTS** dentro de ella.

#### 4. Actualizar el sistema
Después de instalar Ubuntu, conviene actualizar el sistema para que todo esté al día y evitar problemas.

#### 5. Instalar XAMPP 8.0.30
Luego se instala **XAMPP 8.0.30**, que servirá para tener un entorno local con:
- Apache
- MariaDB
- PHP
- Perl

Esto será útil para la parte web y para trabajar en local.

#### 6. Instalar DBeaver 26.0.3
Después se instala **DBeaver 26.0.3**, que será el programa que usaré para gestionar la base de datos del proyecto.

Con DBeaver podré:
- crear tablas
- insertar datos
- ejecutar consultas
- revisar la base de datos

#### 7. Instalar un editor de código
También hará falta instalar un editor de código, como por ejemplo **Visual Studio Code**, para trabajar con los archivos del proyecto.

#### 8. Copiar el proyecto
Después se copiará el proyecto dentro de la máquina virtual, manteniendo la estructura de carpetas correspondiente.

#### 9. Ejecutar los scripts SQL
Por último, se ejecutarán los scripts SQL para:
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
En este proyecto se trabajará con un usuario principal dentro del sistema Linux, que sería el usuario encargado de instalar programas, configurar el entorno y ejecutar el proyecto.

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
│── bbdd
│── src
│── tienda
│── web
│── .gitattributes
│── .gitignore
│── README.md
```
### 7. Mantenimiento básico

Para que el entorno del proyecto siga funcionando correctamente, conviene hacer un mantenimiento básico de vez en cuando.

#### Qué se debería actualizar
- Ubuntu 26.04 LTS
- VMware
- XAMPP 8.0.30
- DBeaver 26.0.3
- Visual Studio Code

#### Cada cuánto
No hace falta estar actualizando constantemente, pero sí es recomendable revisar actualizaciones de vez en cuando, por ejemplo una vez al mes o cuando algún programa dé problemas.

#### Qué se debería revisar
- que la máquina virtual arranque bien
- que Ubuntu funcione correctamente
- que XAMPP inicie Apache y MariaDB sin errores
- que DBeaver se conecte a la base de datos
- que los archivos del proyecto sigan bien organizados
- que los scripts SQL funcionen correctamente

#### Qué hacer si falla
Si el entorno falla, lo primero sería revisar el error concreto. Después se podría:
- reiniciar la máquina virtual
- comprobar si los servicios de XAMPP están activos
- revisar la conexión con la base de datos
- comprobar si hay errores en los scripts SQL
- restaurar una copia de seguridad del proyecto si hiciese falta

También sería recomendable guardar copias del proyecto en GitHub para no perder el trabajo realizado.

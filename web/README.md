# ElectroHogar - Parte web

## Descripción

ElectroHogar es una web ficticia de una tienda de electrodomésticos para el hogar.  
La idea de esta parte del proyecto era hacer una web sencilla, clara y fácil de navegar, donde se pudiera ver un poco la imagen de la tienda, algunos productos y una forma de contacto.

Esta parte corresponde al módulo de **Lenguajes de Marcas**, así que está hecha con **HTML y CSS**.

---

## Qué he querido hacer

La idea era montar una web simple, sin complicarla demasiado, pero que se vea ordenada y con sentido.

La web permite:

- ver una página principal
- consultar productos
- leer una pequeña explicación sobre la tienda
- contactar mediante formulario
- ver la ubicación en un mapa

---

## Estructura de la web

La web tiene estas páginas:

- `index.html` → página principal
- `productos.html` → catálogo de productos
- `nosotros.html` → información sobre la tienda
- `contacto.html` → datos de contacto, formulario y mapa

También hay un archivo de estilos común:

- `style.css`

Y una carpeta de imágenes:

- `assets/images`

---

## Qué hay en cada página

### Inicio
En la página principal se presenta la tienda y se muestran algunos productos destacados.  
También hay botones para ir directamente a productos o contacto.

### Productos
En esta página aparece un catálogo básico dividido por categorías:

- Frigoríficos
- Lavadoras
- Microondas
- Pequeño electrodoméstico

Cada producto aparece en una tarjeta con imagen, nombre, descripción y precio.

### Sobre nosotros
Aquí se explica qué es ElectroHogar y cuál es la idea general del proyecto.  
También se comenta que la web está relacionada con la base de datos que se ha hecho en otra parte del trabajo.

### Contacto
En esta página he incluido:

- dirección
- teléfono
- email
- horario
- un mapa de Google Maps
- un formulario de contacto

---

## Parte técnica

### HTML
He usado una estructura bastante normal:

- `header`
- `nav`
- `main`
- `section`
- `footer`

También he usado listas, formularios, imágenes y enlaces entre páginas.

### CSS
Todo el diseño está en un único archivo `style.css`.  
Ahí se controlan:

- colores
- tipografía
- distribución de la página
- estilo del menú
- tarjetas de productos
- formulario
- mapa
- responsive básico

No he querido meter cosas raras ni complicarlo más de la cuenta.

---

## Diseño y navegación

Todas las páginas tienen el mismo menú arriba, así que se puede pasar de una a otra sin problema.

He intentado que toda la web mantenga el mismo estilo:
- mismo header
- mismo footer
- mismos colores
- misma forma de organizar el contenido

La idea era que todo se viera uniforme y no pareciera cada página de su padre y de su madre.

---

## Responsive

La web tiene una adaptación básica para pantallas más pequeñas usando `media queries`.

Se cambian sobre todo:
- el header
- el formulario
- la sección de sobre nosotros
- la parte del contacto con el mapa

No es una obra maestra del responsive, pero cumple y se sigue viendo bien.

---

## Tecnologías usadas

- HTML5
- CSS3

---

## Archivos principales

- `index.html`
- `productos.html`
- `nosotros.html`
- `contacto.html`
- `style.css`

---

## Cómo abrir la web

1. Abrir la carpeta del proyecto.
2. Entrar en la carpeta de la web.
3. Abrir `index.html` en el navegador.
4. Navegar por las distintas páginas desde el menú superior.

---

## Comentario personal

He intentado hacer una web sencilla pero bastante clara, sin meter cosas demasiado complejas porque la idea era que quedara bien, fuese entendible y estuviera relacionada con el resto del proyecto.

Seguramente se podrían añadir más cosas, pero para el nivel del proyecto he preferido hacer algo simple, funcional y que se entienda bien.

---
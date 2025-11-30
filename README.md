# API REST para Sistema de Gestión de Biblioteca

## Índice
1. [Descripción del Proyecto](#descripción-del-proyecto)
2. [Integrantes del Equipo](#integrantes-del-equipo)
3. [Estructura del Proyecto](#estructura-del-proyecto)
4. [¿Como utilizar esta api?](#como-utilizar-esta-api)
5. [Configuración](#configuración)
6. [Conexión con Postman](#conexión-con-postman)
7. [Guía de Uso de Endpoints (Rutas)](#guía-de-uso-de-endpoints-rutas)
8. [Tablas de Comandos para Postman](#tablas-de-comandos-para-postman)

---

## Descripción del Proyecto

Este es el proyecto de ciclo para la asignatura de Programación Orientada a Objetos (POO) en la carrera de Ingeniería en Desarrollo de Software

El objetivo de este proyecto es desarrollar una **API REST** utilizando **Java** para gestionar un sistema de biblioteca. La API permitirá a la aplicación cliente realizar operaciones CRUD (Crear, Leer, Actualizar, Eliminar) sobre las siguientes entidades principales:


## Integrantes del Equipo

La API será desarrollada por el siguiente equipo:

| Nombre Completo                 | Usuario GitHub   | CARNET  |
|:--------------------------------|:-----------------|:--------|
| Diana Judith Ventura Erazo      | dianaventura4    | ve24006 |
| Cristian Mauricio Molina Monzon | CristianMolina27 | mm18192 |
| Gerson Saul Jiménez Caceres     | JC21002          | jc21002 |
| Daniel Abraham Cerritos Rivera  | CR24054          | Cr24054 |

---

## Estructura del Proyecto

El proyecto sigue una arquitectura en capas típica de Spring Boot. A continuación se detalla la estructura de carpetas en `src/main/java/apiBiblioteca`:

```
apiBiblioteca
├── controller   # Controladores REST (Endpoints)
├── dto          # Objetos de Transferencia de Datos (si aplica)
├── exception    # Manejo de Excepciones Personalizadas
├── model        # Entidades JPA (Tablas de Base de Datos)
├── repository   # Interfaces de Repositorio (Acceso a Datos)
├── service      # Lógica de Negocio
└── Main.java    # Clase Principal (Punto de Entrada)
```

### Paquetes y su Propósito

- **`controller`**: Aquí se definen las rutas (endpoints) de la API. Las clases en este paquete reciben las peticiones HTTP (GET, POST, PUT, DELETE) y responden al cliente.
- **`model`**: Contiene las clases que representan las tablas de la base de datos (Entidades). Por ejemplo, `Libro`, `Usuario`, `Prestamo`.
- **`repository`**: Interfaces que extienden de `JpaRepository`. Se encargan de interactuar directamente con la base de datos (guardar, buscar, eliminar).
- **`service`**: Contiene la lógica de negocio. Los controladores llaman a los servicios, y los servicios usan los repositorios.
- **`exception`**: Manejo de errores para dar respuestas claras cuando algo falla.

### Clases Importantes

- **`Main.java`**: Es el corazón de la aplicación. La anotación `@SpringBootApplication` le dice a Spring que inicie todo el sistema.
- **`LibroController`, `UsuarioController`, `PrestamoController`**: Son los puntos de acceso para gestionar libros, usuarios y préstamos respectivamente.

---

## ¿Como utilizar esta api?
## Requerimientos
tienes que tener instalado postman, y postgresql, y java en su ultima version.
(notamos que en intelliJ idea no funcionaba en algunos dispositivos, en caso de que suceda, usa otro editor de codigo).

## Configuración

### Archivo `application.properties`

En el codigo veras un archivo llamado **application.properties** (`src/main/resources/application.properties`), alli veras un apartado donde te pide tu usuario de pgAdmin y tu contraseña.

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/sistemaBibliotecaAPI
spring.datasource.username=postgres
spring.datasource.password=TU_CONTRASEÑA_AQUI
spring.datasource.driver-class-name=org.postgresql.Driver

spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.PostgreSQLDialect
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

**Asegurate de que los datos sean correctos, de lo contrario no te conectara a la base de datos**

### Conexión con PostgreSQL

1.  **Instalar PostgreSQL y pgAdmin**: Asegúrate de tenerlos instalados y corriendo.
2.  **Crear Base de Datos**: Tienes que crear una base de datos en pgAdmin llamada **sistemaBibliotecaAPI**.
3.  **Configurar Credenciales**:
    - Abre el archivo `src/main/resources/application.properties`.
    - En `spring.datasource.username`, pon tu usuario de PostgreSQL (usualmente es `postgres`).
    - En `spring.datasource.password`, **escribe tu contraseña real** de PostgreSQL.
    - **IMPORTANTE**: Si tu contraseña es incorrecta, la aplicación fallará al iniciar.

## Funcionamiento
Para que la Api funcione tienes que ejecutar el main.java y luego irte a postman y poner la siguiente url
**http://localhost:8080/** y listo!!, ya podras hacer get post y otras cosas usando postman

---

## Conexión con Postman

Postman es la herramienta que usaremos para probar la API, ya que no tenemos una interfaz gráfica (frontend) todavía.

1.  **Iniciar la Aplicación**: Ejecuta la clase `Main.java` en tu IDE. Espera a que en la consola diga "Started Main in...".
2.  **Abrir Postman**: Crea una nueva colección o una nueva petición (Request).
3.  **Configurar Petición**:
    - Selecciona el método (GET, POST, PUT, DELETE).
    - Ingresa la URL: `http://localhost:8080/` seguido de la ruta (ej. `libros`).
    - Si es POST o PUT, ve a la pestaña **Body**, selecciona **raw** y luego **JSON**. Ahí pegarás los datos.
4.  **Enviar**: Dale clic a **Send**.

---

## Guía de Uso de Endpoints (Rutas)

La ruta base para todas las peticiones es: `http://localhost:8080`

### Usar GET (Recuperar Datos)
Para traer datos tienes que usar la URL y ponerle los datos que quieres, ejemplo: **/libros**, esto te dará todos los libros que has guardado en la base de datos. El método **GET** no modifica datos.

| Recurso | Ejemplo de Endpoint | Descripción |
| :--- | :--- | :--- |
| **Listar Todos los Libros** | `GET /libros` | Devuelve un listado completo de todos los libros. |
| **Buscar Libro por ID** | `GET /libros/5` | Busca y devuelve la información del libro con el ID `5`. |
| **Listar Todos los Usuarios** | `GET /usuarios` | Devuelve un listado de todos los usuarios registrados en el sistema. |
| **Listar Préstamos** | `GET /prestamos` | Devuelve un listado de todos los préstamos (activos e inactivos). |

### Usar POST (Crear Datos)
POST nos ayudará a subir información a la base de datos. Tienes que poner en la URL el link de lo que meterás, ejemplo: `http://localhost:8080/libros`. Debes incluir un cuerpo de petición (`Body`) en formato **JSON**.

| Recurso | Ejemplo de Endpoint | JSON Body Requerido (Ejemplo) | Descripción |
| :--- | :--- | :--- | :--- |
| **Crear Nuevo Libro** | `POST /libros` | `{ "titulo": "Cien Años de Soledad", "disponible": true }` | Crea un nuevo registro de libro. |
| **Crear Nuevo Usuario** | `POST /usuarios` | `{ "nombre": "Ana García", "correo": "ana@ejemplo.com", "carnet": "GZ24010" }` | Crea un nuevo registro de usuario. |
| **Crear Nuevo Préstamo** | `POST /prestamos/crear/2/1` | **N/A (Cuerpo Vacío)** | Crea un préstamo, asociando el libro ID `2` con el usuario ID `1`. Marca el libro como NO disponible. |

### Usar PUT (Actualizar Datos)
El método **PUT** se utiliza para **modificar o actualizar un recurso existente**. Requiere el ID en la URL y el cuerpo JSON (`Body`) con los datos a modificar.

| Recurso | Ejemplo de Endpoint | JSON Body Requerido (Ejemplo) | Descripción |
| :--- | :--- | :--- | :--- |
| **Actualizar Libro** | `PUT /libros/5` | `{ "titulo": "Cien Años de Soledad (Edición 2024)", "disponible": true }` | Actualiza toda la información del libro con ID `5`. |
| **Actualizar Usuario** | `PUT /usuarios/1` | `{ "nombre": "Daniel A. Rivera", "correo": "nuevo.email@ejemplo.com", "carnet": "CR24054" }` | Actualiza la información del usuario con ID `1`. |
| **Devolver Préstamo** | `PUT /prestamos/devolver/10` | **N/A (Cuerpo Vacío)** | **Finaliza el préstamo** con ID `10`. Marca el préstamo como "inactivo" y el libro asociado como disponible. |

### Usar DELETE (Eliminar Datos)
El método **DELETE** se utiliza para **eliminar permanentemente un recurso** de la base de datos. Solo requiere el ID del recurso en la URL.

| Recurso | Ejemplo de Endpoint | Descripción |
| :--- | :--- | :--- |
| **Eliminar Libro** | `DELETE /libros/7` | Elimina el registro del libro con ID `7`. |
| **Eliminar Usuario** | `DELETE /usuarios/3` | Elimina el registro del usuario con ID `3`. |

---

## Tablas de Comandos para Postman

Aquí tienes una guía rápida de todos los comandos disponibles.

### Libros (`/libros`)

| Método | URL | Descripción | Body (JSON) Ejemplo |
| :--- | :--- | :--- | :--- |
| **GET** | `http://localhost:8080/libros` | Ver todos los libros | N/A |
| **POST** | `http://localhost:8080/libros` | Crear un libro | `{ "titulo": "El Principito", "autor": "Antoine de Saint-Exupéry", "isbn": "978-3-16-148410-0", "genero": "Ficción", "disponible": true }` |
| **GET** | `http://localhost:8080/libros/{id}` | Buscar libro por ID (ej. `/libros/1`) | N/A |
| **PUT** | `http://localhost:8080/libros/{id}` | Actualizar libro (ej. `/libros/1`) | `{ "titulo": "El Principito (Ed. Especial)", "autor": "Antoine de Saint-Exupéry", "isbn": "978-3-16-148410-0", "genero": "Ficción", "disponible": true }` |
| **DELETE**| `http://localhost:8080/libros/{id}` | Eliminar libro (ej. `/libros/1`) | N/A |

### Usuarios (`/usuarios`)

| Método | URL | Descripción | Body (JSON) Ejemplo |
| :--- | :--- | :--- | :--- |
| **GET** | `http://localhost:8080/usuarios` | Ver todos los usuarios | N/A |
| **POST** | `http://localhost:8080/usuarios` | Crear un usuario | `{ "nombre": "Juan Perez", "correo": "juan@email.com", "carnet": "JP2024" }` |
| **GET** | `http://localhost:8080/usuarios/{id}`| Buscar usuario por ID | N/A |
| **PUT** | `http://localhost:8080/usuarios/{id}`| Actualizar usuario | `{ "nombre": "Juan P. Perez", "correo": "juan.nuevo@email.com", "carnet": "JP2024" }` |
| **DELETE**| `http://localhost:8080/usuarios/{id}`| Eliminar usuario | N/A |

### Préstamos (`/prestamos`)

| Método | URL | Descripción | Body (JSON) Ejemplo |
| :--- | :--- | :--- | :--- |
| **GET** | `http://localhost:8080/prestamos` | Ver todos los préstamos | N/A |
| **POST** | `http://localhost:8080/prestamos/crear/{idLibro}/{idUsuario}` | Crear préstamo (ej. `/prestamos/crear/1/2`) | N/A (Los IDs van en la URL) |
| **PUT** | `http://localhost:8080/prestamos/devolver/{idPrestamo}` | Devolver libro (ej. `/prestamos/devolver/5`) | N/A |

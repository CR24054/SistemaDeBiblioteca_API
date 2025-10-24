# API REST para Sistema de Gestión de Biblioteca

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
| Daniel Abraham Cerritos Rivera  | CR24054          | cr24054 |

---
## ¿Como utilizar esta api?
## Requerimientos
tienes que tener instalado postman, y postgresql, y java en su ultima version.
(notamos que en intelliJ idea no funcionaba en algunos dispositivos, en caso de que suceda, usa otro editor de codigo).

## Configurar datos
En el codigo veras un archivo llamado **application.properties**, alli veras un apartado donde te pide tu usuario de 
pgAdmin y tu contraseña, **Asegurate de que los datos sean correctos, de lo contrario no te conectara a la base de datos**

## Configurar Base de Datos
Tienes que crear una base de datos en pgAdmin llamada **sistemaBibliotecaAPI**

## Funcionamiento
Para que la Api funcione tienes que ejecutar el main.java y luego irte a postman y poner la siguiente url
**http://localhost:8080/** y listo!!, ya podras hacer get post y otras cosas usando postman


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



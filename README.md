# 🎬 Movie Management API

Proyecto desarrollado como **examen práctico del Módulo 3** del bootcamp, usando **Java + Spring Boot + MySQL**.

Esta API permite gestionar películas, directores, premios y reseñas a través de rutas RESTful. Está construida con Spring Data JPA y conectada a una base de datos relacional.

---

## 🧱 Entidades del sistema

### `Movie`
- `id` (Long)
- `title` (String)
- `genre` (String)
- `releaseYear` (int)
- Relación `ManyToOne` con `Director`
- Relación `OneToMany` con `Award` y `Review`

### `Director`
- `id` (Long)
- `name` (String)
- `birthYear` (int)
- Relación `OneToMany` con `Movie`

### `Award`
- `id` (Long)
- `name` (String)
- `year` (int)
- Relación `ManyToOne` con `Movie`

### `Review`
- `id` (Long)
- `reviewerName` (String)
- `rating` (int)
- `comment` (String)
- Relación `ManyToOne` con `Movie`

---

## 📦 Estructura del proyecto

```

src
└── main
└── java
└── com.example.movies
├── models
├── repositories
├── controllers
└── test
└── java
└── com.example.movies
└── MovieTests.java

````

---

## 🚀 Endpoints principales

### 🎥 Movies
- `GET /movies` → Obtener todas las películas
- `GET /movies/{id}` → Película por ID
- `POST /movies` → Crear nueva película
- `PUT /movies/{id}` → Actualizar película
- `DELETE /movies/{id}` → Eliminar película

### 🎬 Directors
- `GET /directors`
- `POST /directors`

### 🏆 Awards
- `GET /awards`
- `POST /awards`

### ✍️ Reviews
- `GET /reviews`
- `POST /reviews`

---

## 💻 Requisitos para ejecutar el proyecto

- Java 17 o superior
- Spring Boot 3.x
- MySQL corriendo localmente

Asegúrate de configurar tu base de datos en `application.properties`:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/movies_db
spring.datasource.username=TU_USUARIO
spring.datasource.password=TU_CONTRASEÑA
spring.jpa.hibernate.ddl-auto=update
````

---

## ✅ Funcionalidades cubiertas (Obligatorias)

* [x] CRUD completo de todas las entidades
* [x] Relaciones correctamente modeladas
* [x] Persistencia en base de datos MySQL
* [x] Al menos un test automático para `Movie`
* [x] Documentación clara en este README

---

## 🧪 Tests

Incluye prueba para creación de una película. Se puede ampliar con tests para directores, premios y reseñas.

---

## 📚 Tecnologías utilizadas

* Java 17
* Spring Boot
* Spring Data JPA
* MySQL
* Maven
* JUnit

---

## ✨ Autoría

Desarrollado por Mábel Martínez como parte del módulo 3 del bootcamp de Ironhack.




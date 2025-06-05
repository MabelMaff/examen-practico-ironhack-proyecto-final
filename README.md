# 🏥 Proyecto Backend - Examen Práctico Módulo 3

Este proyecto es una aplicación backend desarrollada con **Java + Spring Boot**, conectada a una base de datos **MySQL**, que modela un sistema de gestión para un centro médico.

## ✅ Objetivo

Implementar una aplicación completa con:

- Modelo de datos con relaciones
- Repositorios con JPA
- Controladores REST con rutas CRUD
- Capa de servicios
- Pruebas unitarias

---

## 🧱 Estructura del proyecto

```

src/
├── main/
│   ├── java/
│   │   └── com/example/clinic/
│   │       ├── controllers/
│   │       │   └── DoctorController.java
│   │       │   └── PatientController.java
│   │       ├── models/
│   │       │   └── Doctor.java
│   │       │   └── Patient.java
│   │       ├── repositories/
│   │       │   └── DoctorRepository.java
│   │       │   └── PatientRepository.java
│   │       ├── services/
│   │       │   └── DoctorService.java
│   │       │   └── PatientService.java
│   │       └── ClinicApplication.java
│   └── resources/
│       └── application.properties
│
├── test/
│   └── java/
│       └── com/example/clinic/
│           ├── DoctorRepositoryTest.java
│           └── PatientControllerTest.java

````

---

## 🧬 Entidades

### Doctor

```java
@Entity
public class Doctor {
    @Id
    private Long id;
    private String name;
    private String department;
    private String status;
    // Getters & Setters
}
````

### Patient

```java
@Entity
public class Patient {
    @Id
    private Long id;
    private String name;
    private LocalDate dateOfBirth;

    @ManyToOne
    @JoinColumn(name = "admitted_by")
    private Doctor admittedBy;
}
```

---

## 🔌 Repositorios

* `DoctorRepository`: con método personalizado `findByStatus(String status)`
* `PatientRepository`: con método `findByAdmittedByDepartment(String department)`

---

## 🔁 Controladores REST

Implementados con rutas para:

* `GET` – obtener pacientes y doctores
* `POST` – añadir pacientes y doctores
* `PUT` / `PATCH` – actualizar estado o departamento
* `DELETE` – eliminar registros

---

## 🧠 Servicio

La lógica entre los controladores y los repositorios está gestionada por `DoctorService` y `PatientService`.

---

## 🧪 Pruebas

Se han implementado:

* `DoctorRepositoryTest.java` – test unitario de método personalizado
* `PatientControllerTest.java` – test de endpoint `GET /patients`

---

## 💾 Configuración de Base de Datos

En `application.properties`:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/clinic_db
spring.datasource.username=TU_USUARIO
spring.datasource.password=TU_CONTRASEÑA
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

---

## 🛠 Cómo ejecutar el proyecto

1. Clona el repositorio:

```bash
git clone https://github.com/TU_USUARIO/NOMBRE_DEL_REPO.git
```

2. Configura `application.properties` con tu base de datos

3. Lanza la aplicación desde tu IDE o ejecuta:

```bash
./mvnw spring-boot:run
```

---

## 🔗 Enlace al repositorio

[🔗 Ver repositorio en GitHub](https://github.com/MabelMaff/examen-practico-ironhack-proyecto-final)

---

## 👤 Autora

Mábel Martínez Rodríguez

```

---




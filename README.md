# 🏥 Multi-City Hospital API – Spring Boot + JPA

Este proyecto es una API RESTful desarrollada con **Spring Boot** y **Spring Data JPA** para gestionar la información de **empleades** y **pacientes** en un hospital distribuido en varias ciudades. Permite realizar operaciones CRUD y consultas filtradas avanzadas.

## 📂 Estructura del Proyecto

```

src/
├── main/
│   ├── java/com/example/hospital/
│   │   ├── controllers/
│   │   │   ├── EmployeeController.java
│   │   │   └── PatientController.java
│   │   ├── entities/
│   │   │   ├── Employee.java
│   │   │   └── Patient.java
│   │   ├── enums/
│   │   │   └── EmployeeStatus.java
│   │   ├── repositories/
│   │   │   ├── EmployeeRepository.java
│   │   │   └── PatientRepository.java
│   │   └── HospitalApplication.java
│   └── resources/
│       └── application.properties
└── test/

````

---

## ⚙️ Tecnologías

- Java 17+
- Spring Boot 3.x
- Spring Data JPA
- MySQL (opcional: H2 en memoria para testing)
- Maven

---

## 🚀 Cómo ejecutar el proyecto

1. **Clona el repositorio:**

```bash
git clone https://github.com/tu_usuario/nombre-repo.git
cd nombre-repo
````

2. **Crea la base de datos en MySQL:**

```sql
CREATE DATABASE hospital_db;
```

3. **Configura `application.properties`:**

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/hospital_db
spring.datasource.username=TU_USUARIO
spring.datasource.password=TU_CONTRASEÑA

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true
```

4. **Ejecuta la aplicación desde tu IDE o consola:**

```bash
./mvnw spring-boot:run
```

---

## 🧪 Datos Semilla

### 🧑‍⚕️ Empleades (Employee)

| ID     | Departamento | Nombre          | Estado   |
| ------ | ------------ | --------------- | -------- |
| 356712 | cardiology   | Alonso Flores   | ON\_CALL |
| 564134 | immunology   | Sam Ortega      | ON       |
| 761527 | cardiology   | German Ruiz     | OFF      |
| 166552 | pulmonary    | Maria Lin       | ON       |
| 156545 | orthopaedic  | Paolo Rodriguez | ON\_CALL |
| 172456 | psychiatric  | John Paul Armes | OFF      |

### 🧍 Pacientes (Patient)

| ID | Nombre            | Fecha Nacimiento | Admitted\_By |
| -- | ----------------- | ---------------- | ------------ |
| 1  | Jaime Jordan      | 1984-03-02       | 564134       |
| 2  | Marian Garcia     | 1972-01-12       | 564134       |
| 3  | Julia Dusterdieck | 1954-06-11       | 356712       |
| 4  | Steve McDuck      | 1931-11-10       | 761527       |
| 5  | Marian Garcia     | 1999-02-15       | 172456       |

---

## 🌐 Endpoints REST

### 📋 Empleades

| Método | Ruta                          | Descripción                                 |
| ------ | ----------------------------- | ------------------------------------------- |
| GET    | `/employees`                  | Obtener todos los médicos                   |
| GET    | `/employees/{id}`             | Obtener médico por ID                       |
| GET    | `/employees/status/{status}`  | Filtrar por estado (`ON`, `OFF`, `ON_CALL`) |
| GET    | `/employees/department/{dep}` | Filtrar por departamento                    |
| POST   | `/employees`                  | Crear nuevo médico                          |
| PATCH  | `/employees/{id}/status`      | Cambiar el estado del médico                |
| PATCH  | `/employees/{id}/department`  | Actualizar el departamento                  |

---

### 👩 Pacientes

| Método | Ruta                                                  | Descripción                                     |
| ------ | ----------------------------------------------------- | ----------------------------------------------- |
| GET    | `/patients`                                           | Obtener todos los pacientes                     |
| GET    | `/patients/{id}`                                      | Obtener paciente por ID                         |
| GET    | `/patients/birth-range?from=YYYY-MM-DD&to=YYYY-MM-DD` | Pacientes nacides entre dos fechas              |
| GET    | `/patients/doctor-department/{dep}`                   | Pacientes por departamento de su médico admisor |
| GET    | `/patients/doctor-status/OFF`                         | Pacientes cuyo médico está OFF                  |
| POST   | `/patients`                                           | Crear nuevo paciente                            |
| PUT    | `/patients/{id}`                                      | Actualizar toda la información de un paciente   |

---

## ❓ Preguntas Requeridas

### ❓¿Usaste el mismo tipo de ruta para actualizar el departamento del doctor y la información del paciente?

No. Para el departamento del doctor usé `PATCH` (actualización parcial), y para el paciente usé `PUT` (actualización completa del recurso).

---

### 💭 ¿Por qué elegiste esa estrategia?

Porque cuando quiero actualizar solo un campo (como el estado o departamento), es más lógico usar `PATCH`. En cambio, para actualizar todos los datos de un paciente, usar `PUT` es más estándar.

---

### ⚖️ ¿Ventajas y desventajas de PUT y PATCH?

| Estrategia | Ventajas                                            | Desventajas                                |
| ---------- | --------------------------------------------------- | ------------------------------------------ |
| PUT        | Reemplaza el recurso completo, más fácil de validar | Menos eficiente si solo cambias 1 campo    |
| PATCH      | Solo actualiza lo que cambia, más liviano           | Más complejo de validar y menos predecible |

---

### 💡 Coste-beneficio entre PUT y PATCH

* `PATCH` es ideal para modificaciones rápidas y localizadas.
* `PUT` es más seguro cuando se quiere mantener integridad total en la estructura del recurso.

En este proyecto usamos ambos, según la situación.

---

## 📌 Notas Finales

* Este proyecto está preparado para escalar fácilmente añadiendo más roles, validaciones o filtros.
* Si lo prefieres, puedes usar una base de datos en memoria como **H2** para pruebas automáticas.

---

## 🧑‍💻 Autora

**Mábel Martínez Rodríguez**
Proyecto para prácticas de desarrollo backend con Spring Boot y JPA.
Por Mábel Martínez Rodríguez para Ironhack.



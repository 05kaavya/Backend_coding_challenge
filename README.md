# 🏏 Cricket Team Management System

A **Spring Boot** application to manage cricket players, their teams, and match statistics.  
This project demonstrates the use of **Spring Boot**, **Spring Data JPA**, **REST APIs**, **validation**, and **exception handling** in a clean, layered architecture.

---

## 📌 Features
- Add, update, delete players
- Fetch players by:
  - Player name
  - Role
  - Team name
  - Jersey number
  - Country
  - Name prefix (e.g., names starting with "D")
- Field validations using **Jakarta Bean Validation**
- Global exception handling
- Case-insensitive search
- JPQL custom queries

---

## 🛠 Tech Stack
- **Java** 17+
- **Spring Boot** 3.x
- **Spring Data JPA**
- **MySQL** (or any supported relational DB)
- **Maven**
- **Lombok** (optional, for reducing boilerplate)

---


---

## 📄 API Endpoints

| Method | Endpoint                         | Description |
|--------|-----------------------------------|-------------|
| GET    | `/players`                       | Get all players |
| GET    | `/players/{id}`                  | Get player by ID |
| GET    | `/players/name/{name}`           | Get players by name |
| GET    | `/players/role/{role}`           | Get players by role |
| GET    | `/players/team/{teamName}`       | Get players by team name |
| GET    | `/players/country/{country}`     | Get players by country |
| GET    | `/players/prefix/{prefix}`       | Get players whose names start with prefix |
| POST   | `/players`                       | Add new player |
| PUT    | `/players/{id}`                  | Update player |
| DELETE | `/players/{id}`                  | Delete player |

---

## 🗄 Database Configuration
In `application.properties`:
```properties
spring.datasource.url=jdbc:mysql://localhost:3306/cricket_db
spring.datasource.username=root
spring.datasource.password=your_password
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true


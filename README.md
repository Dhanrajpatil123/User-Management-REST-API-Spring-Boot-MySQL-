 

```markdown
# 🚀 User Management REST API

![Java](https://img.shields.io/badge/Java-17-blue)
![Spring Boot](https://img.shields.io/badge/SpringBoot-3.x-brightgreen)
![MySQL](https://img.shields.io/badge/MySQL-Database-orange)
![License](https://img.shields.io/badge/License-MIT-green)

---

## 📌 Project Overview

This project is a **User Management REST API** built using **Spring Boot** and **MySQL**.  
It provides complete CRUD operations along with authentication features such as **user registration and login**.

The application follows a clean layered architecture:
- Controller Layer
- Service Layer
- Repository Layer
- DTO-based data transfer

This API is designed to be easily integrated with frontend frameworks like **React.js**.

---

## 🧠 Key Features

- 🔐 User Registration
- 🔑 User Login (Basic Authentication)
- 📄 Get All Users
- 🔍 Get User by ID
- ✏️ Update User
- ❌ Delete User
- 🧩 Filter Users by Category
- 🔎 Get User Names by Category
- 📦 DTO-based architecture (secure data handling)
- ⚡ Exception handling with meaningful responses

---

## 🛠️ Tech Stack

| Technology | Usage |
|----------|------|
| Java | Programming Language |
| Spring Boot | Backend Framework |
| Spring Data JPA | ORM |
| Hibernate | Persistence Provider |
| MySQL | Database |
| Maven | Build Tool |

---

## 📂 Project Structure

```

com.dhanraj
│
├── controller        # REST Controllers
├── dto               # Data Transfer Objects
├── model             # Entity Classes
├── repository        # JPA Repositories
├── service           # Interfaces
├── serviceImplementation # Service Logic

````

---

## ⚙️ API Endpoints

| Method | Endpoint | Description |
|--------|--------|-------------|
| POST | `/api/users/register` | Register new user |
| POST | `/api/users/login` | User login |
| GET | `/api/users` | Get all users |
| GET | `/api/users/{id}` | Get user by ID |
| PUT | `/api/users/{id}` | Update user |
| DELETE | `/api/users/{id}` | Delete user |
| GET | `/api/users/category/{category}` | Get user names by category |

---

## 🧪 Sample API Request

### 🔐 Register User

```json
{
  "name": "Dhanraj",
  "email": "dhanraj@gmail.com",
  "password": "12345678",
  "category": "Electronics"
}
````

---

## ▶️ How to Run the Project

### 1️⃣ Clone Repository

```bash
git clone https://github.com/your-username/user-api.git
```

### 2️⃣ Navigate to Project

```bash
cd user-api
```

### 3️⃣ Configure Database

Update `application.properties`:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/usercredentials
spring.datasource.username=root
spring.datasource.password=your_password
```

### 4️⃣ Run Application

```bash
mvn spring-boot:run
```

---

## 🧪 API Testing

Use:

* Postman
* Thunder Client
* Swagger (optional)

---

## ⚠️ Important Notes

* ❗ Passwords are stored in **plain text** (for learning purpose only)
* ❗ No authentication/authorization implemented yet

---

## 🔮 Future Enhancements

 
* 📄 Pagination & Sorting
* 🔍 Search Functionality
* 👥 Role-Based Access Control (Admin/User)
* 🌐 React Frontend Integration

---

---

## 👨‍💻 Author

**Dhanraj Patil**

---
 

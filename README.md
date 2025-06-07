# 🛒 E-commerce Backend (Spring Boot + H2)

This project is a backend e-commerce application built with **Spring Boot** that simulates a basic product purchasing system. It uses an **in-memory H2 database**, perfect for testing and rapid development.

---

## 🚀 Features

- 🔍 View available products.
- 🛍️ Simulate product purchases (stock reduction).
- 🧾 Register new products (POST).
- 🧹 In-memory H2 database (resets on every restart).

---

## 🧑‍💻 Technologies Used

- Java 21+
- Spring Boot
- Spring Web
- Spring Data JPA
- H2 Database
- Maven

---

## 🗃️ Project Structure

```
src
└── main
    ├── java
    │   └── com.project.ecommerce
    │       ├── controller
    │       ├── model
    │       ├── repository
    │       └── service
    └── resources
        └── application.properties
```

---

## ⚙️ Database Configuration (H2)

The app is pre-configured to use an in-memory H2 database. You can access the web console at:

📍 `http://localhost:8080/h2-console`

**Connection Parameters:**

| Field        | Value                |
|--------------|----------------------|
| JDBC URL     | `jdbc:h2:mem:testdb` |
| User Name    | `sa`                 |
| Password     | (leave empty)        |

---

## 📦 Available Endpoints (Examples)

| Method | Endpoint                  | Description                                         |
|--------|---------------------------|-----------------------------------------------------|
| GET    | `/api/items`              | List all items                                      |
| GET    | `/api/items/{id}`         | Get an item by its ID                              |
| POST   | `/api/items/create`       | Create a new item                                  |
| POST   | `/api/items/create-items` | Create multiple items                              |
| PUT    | `/api/items/update/{id}`  | Update an item by its ID                           |
| DELETE | `/api/items/delete/{id}`  | Delete an item by its ID                           |
| POST   | `/api/buy`                | Simulate a purchase of products (creates an order) |

---

## 📋 Example JSON to Create a Product

```json
{
  "name": "Keyboard",
  "description": "Electronic device",
  "quantity": 10,
  "price": 49.99
}
```

---

▶️ How to Run the Project

```bash
# Clone the repository
git clone https://github.com/ferranGimeno/ecommerce-springboot.git
cd ecommerce-springboot

# Run with Maven
./mvnw spring-boot:run
```

---

🛠 Upcoming Improvements

- 🔐 Authentication and roles (admin / customer)
- 🛒 Shopping cart feature
- 🧾 Order management system

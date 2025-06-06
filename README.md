# 🛒 E-commerce Backend (Spring Boot + H2)

Este proyecto es una aplicación backend de e-commerce desarrollada con **Spring Boot** que simula un sistema básico de compra de productos. Está conectada a una base de datos **H2 en memoria**, ideal para pruebas y desarrollo rápido.

## 🚀 Funcionalidades

- 🔍 Consultar productos disponibles.
- 🛍️ Simular la compra de productos (reduce el stock).
- 🧾 Registrar productos (POST).
- 🧹 Base de datos H2 en memoria, se resetea en cada reinicio.

---

## 🧑‍💻 Tecnologías utilizadas

- Java 21+
- Spring Boot
- Spring Web
- Spring Data JPA
- H2 Database
- Maven
  
---

## 🗃️ Estructura del proyecto
src
└── main
├── java
│ └── com.project.ecommerce
│ ├── controller
│ ├── model
│ ├── repository
│ └── service
└── resources
└── application.properties

---

## ⚙️ Configuración de base de datos (H2)

La app está preconfigurada para usar H2 en memoria. Puedes acceder a la consola web en:

📍 `http://localhost:8080/h2-console`

**Parámetros de conexión:**

| Campo        | Valor               |
|--------------|---------------------|
| JDBC URL     | `jdbc:h2:mem:testdb`|
| User Name    | `sa`                |
| Password     |                     |

---

## 📦 Endpoints disponibles (ejemplos)

| Método | Endpoint              | Descripción                        |
|--------|------------------------|------------------------------------|
| GET    | `/api/products`        | Listar todos los productos         |
| POST   | `/api/products`        | Crear un nuevo producto            |
| POST   | `/api/purchase/{id}`   | Simular compra de un producto (stock -1) |

---

## 📋 Ejemplo de JSON para crear un producto

{
  "nombre": "Teclado mecánico",
  "categoria": "Electrónica",
  "precio": 49.99,
  "stock": 10
}

---

▶️ Cómo ejecutar el proyecto

# Clonar el repositorio
git clone https://github.com/tu-usuario/ecommerce-springboot.git
cd ecommerce-springboot

# Ejecutar con Maven
./mvnw spring-boot:run

---

🛠 Próximas mejoras
🔐 Autenticación y roles (admin / cliente)
🛒 Carrito de compras
🧾 Gestión de pedidos



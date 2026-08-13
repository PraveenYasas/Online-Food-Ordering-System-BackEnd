# 🍔 BiteDash - Online Food Ordering System (Backend API)

Welcome to the backend REST API repository for **BiteDash**! This Spring Boot application serves as the core engine powering the BiteDash food delivery platform, handling secure user authentication, order processing, menu management, and real-time cart validation.

## ✨ Key Features

* **🔐 Secure Authentication:** JWT (JSON Web Token) based authentication with Spring Security.
* **👥 Role-Based Access Control (RBAC):** Distinct access levels for `CUSTOMER`, `RESTURANT_OWNER`, and `ADMIN`.
* **🛒 Smart Cart Validation:** Backend logic to prevent multi-restaurant cart mixing, ensuring delivery feasibility.
* **📦 Order Management System:** Comprehensive API endpoints to place, track, update status, and cancel orders.
* **🏬 Restaurant & Menu APIs:** Endpoints for restaurant owners to manage their food catalogs, categories, and track daily revenue.
* **❤️ Favorites Management:** Allow users to save and retrieve their favorite food items and restaurants.
* **🗄️ Automated Schema Generation:** Utilizes Spring Data JPA (Hibernate) to automatically generate and update the database schema.

## 🛠️ Tech Stack

* **Framework:** Java 17+, Spring Boot
* **Security:** Spring Security, JWT (JSON Web Tokens)
* **Database:** MySQL, Spring Data JPA / Hibernate
* **Tools & Libraries:** Lombok, Maven, ModelMapper
* **API Architecture:** RESTful APIs

## 🚀 Getting Started

Follow these steps to set up the backend server on your local machine.

### Prerequisites
* [Java JDK 17](https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html) or higher installed.
* [MySQL Server](https://dev.mysql.com/downloads/mysql/) installed and running.
* [Maven](https://maven.apache.org/) installed (or simply use the provided wrapper).

### 1️⃣ Database Configuration
Before running the application, you need to create a blank MySQL database.

1. Open your MySQL client or terminal and run:
   ```sql
   CREATE DATABASE food_ordering_db;

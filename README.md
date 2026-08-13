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

### 2️⃣ Clone, Setup Database, and Run

1. **Clone the repository:**
   ```bash
   git clone [https://github.com/PraveenYasas/Online-Food-Ordering-System-BackEnd.git](https://github.com/PraveenYasas/Online-Food-Ordering-System-BackEnd.git)
   cd Online-Food-Ordering-System-BackEnd

### 3️⃣ Demo / Test Accounts 🔑

To make it easy for examiners or developers to test the application, you can use the following pre-configured test accounts. *(Note: Make sure to import the provided SQL dump file into your MySQL database to use these exact accounts).*

| User Role | Email Address | Password |
| :--- | :--- | :--- |
| **Admin** | `admin@bitedash.com` | `12345678` |
| **Restaurant Owner (C Foods)** | `owner@cfoods.com` | `12345678` |
| **Restaurant Owner (Kottu Labs)** | `owner@kottulabs.com` | `12345678` |
| **Customer** | `praveen@gmail.com` | `12345678` |
| **Customer** | `sakith71@gmail.com` | `12345678` |

Simply enter these credentials on the Login Modal in the frontend, and the system will automatically redirect you to the appropriate dashboard based on the user's role!

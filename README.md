# Blogera

Blogera is a lightweight, Spring Boot-based blogging REST API with JWT authentication and role-based access control. It enables users to securely create, manage, and view blog posts through a set of well-defined endpoints for user registration, login, and blog management.

## Features

- **User Authentication**: Secure signup and login with JWT token generation.
- **Blog Creation**: Authenticated users can create blog posts.
- **Author-Specific Control**: Only the post author can edit or delete their blogs.
- **User Blogs**: View all blogs by a specific user via `/{username}`.
- **Persistent Storage**: Uses PostgreSQL for reliable data storage.
- **Role-Based Access**: Ensures secure access to endpoints with appropriate permissions.

## API Endpoints

| Method | Endpoint                  | Description                                    |
|--------|---------------------------|------------------------------------------------|
| `POST` | `/auth/signup`           | Register a new user                            |
| `POST` | `/auth/login`            | Log in and receive a JWT token                |
| `GET`  | `/blogs`                 | Retrieve all blog posts                        |
| `POST` | `/blogs/post`            | Create a new blog post (requires JWT, USER role) |
| `PUT`  | `/blogs/update/{id}`     | Update a blog post (requires JWT, author only) |
| `DELETE` | `/blogs/delete/{id}`    | Delete a blog post (requires JWT, author only) |
| `GET`  | `/{username}`            | Get all blog posts by a specific user          |

## Prerequisites

- Java 17 or higher
- Maven
- PostgreSQL
- Git

## Setup Instructions

1. **Clone the Repository**:

   ```bash
   git clone https://github.com/Ghanshyam32/blogera.git
   cd blogera
   ```

2. **Create a PostgreSQL Database**:

   Create a database named `blogera` in PostgreSQL:

   ```sql
   CREATE DATABASE blogera;
   ```

3. **Configure Database Credentials**:

   Update the `application.properties` file in `src/main/resources` with your PostgreSQL credentials:

   ```properties
   spring.datasource.url=jdbc:postgresql://localhost:5432/blogera
   spring.datasource.username=your_username
   spring.datasource.password=your_password
   spring.datasource.driver-class-name=org.postgresql.Driver

   spring.jpa.hibernate.ddl-auto=update
   spring.jpa.show-sql=true
   spring.jpa.database-platform=org.hibernate.dialect.PostgreSQLDialect
   spring.h2.console.enabled=false
   ```

4. **Run the Application**:

   Use Maven to start the Spring Boot application:

   ```bash
   mvn spring-boot:run
   ```

## Usage

1. **Register and Authenticate**:
   - Use the `/auth/signup` endpoint to create a new user account.
   - Use the `/auth/login` endpoint to log in and receive a JWT token.

2. **Access Secured Endpoints**:
   - Include the JWT token in the `Authorization` header as `Bearer <token>` for protected routes (e.g., creating, updating, or deleting blog posts).

3. **Blog Management**:
   - Create, update, or delete blog posts using the respective endpoints.
   - Only the author of a blog post can modify or delete it.
   - View all blogs or blogs by a specific user using the provided endpoints.

## Tech Stack

- **Spring Boot**: Backend framework for building the REST API.
- **Spring Security + JWT**: For authentication and authorization.
- **PostgreSQL**: Relational database for persistent storage.
- **Maven**: Dependency management and build tool.

## Contributing

Contributions are welcome! Please fork the repository, create a feature branch, and submit a pull request with your changes.
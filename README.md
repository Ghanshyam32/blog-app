# Blogera 
Blogera is a simple Spring Boot-based blogging REST API featuring JWT authentication and role-based access control. It enables users to create, manage, and view blogs securely, with endpoints for registration, login, and blog management.

## Features

- User signup and login with JWT token
- Authenticated blog creation
- Blogs linked to author accounts
- Only author can edit or delete their posts
- View any user's blogs at `/username`
- H2 database with console support

## Endpoints

| Method | URL                     | Description                                    |
|--------|--------------------------|------------------------------------------------|
| POST   | `/auth/signup`          | Register a new user                            |
| POST   | `/auth/login`           | Login and receive token                        |
| GET    | `/blogs`                | View all blogs                                 |
| POST   | `/blogs/post`           | Create a blog (USER only, requires JWT token)  |
| PUT    | `/blogs/update/{id}`    | Update blog (author only, requires JWT token)  |
| DELETE | `/blogs/delete/{id}`    | Delete blog (author only, requires JWT token)  |
| GET    | `/{username}`           | Get all blogs by username                      |

## Setup

1. Clone the repository
   ```bash
   git clone https://github.com/Ghanshyam32/blogera.git
2. Run with:

   ```bash
   mvn spring-boot:run
3. Access H2 Console at:

    ```bash
    http://localhost:8080/h2-console
4. Default DB: **`jdbc:h2:mem:blogdb`**

## Usage

- Use `/auth/signup` and `/auth/login` to register and obtain a JWT token.
- Pass the JWT token in the `Authorization: Bearer <token>` header for protected endpoints.

## Tech Stack
- Spring Boot

- Spring Security + JWT

- H2 Database

- Maven

## Author
Created by [Ghanshyam Mishra](https://github.com/Ghanshyam32)
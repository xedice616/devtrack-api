# DevTrack API

DevTrack is a secure REST API built with Java and Spring Boot for managing developer learning goals and progress.

Users can register, log in, receive a JWT token, and manage their own development goals.

## Features

- User registration
- User login
- BCrypt password hashing
- JWT authentication
- Protected endpoints
- User-specific goal management
- Create, read, update, and delete goals
- PostgreSQL persistence
- Input validation
- Global exception handling

## Technologies

- Java 17
- Spring Boot
- Spring Web
- Spring Data JPA
- Spring Security
- JWT
- BCrypt
- PostgreSQL
- Hibernate
- Maven
- Postman

## Authentication

### Register

POST `/api/auth/register`

Example request:

```json
{
  "name": "Khadija",
  "email": "khadija@example.com",
  "password": "12345678"
}

```

---


## Project Structure


```
com.xadice.devtrack
├── config
├── controller
├── dto
├── exception
├── model
├── repository
├── security
├── service
└── DevTrackApplication.java



```


---




## Goal Endpoints
```
Method	Endpoint	Description
POST	/api/goals	Create a goal
GET	/api/goals	Get user's goals
GET	/api/goals/{id}	Get a goal by ID
PUT	/api/goals/{id}	Update a goal
DELETE	/api/goals/{id}	Delete a goal
```

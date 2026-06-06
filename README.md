# Todo Management API

A REST API for managing todos with status tracking and due dates.

## Tech Stack
- Java 25
- Spring Boot
- Spring Data JPA
- MySQL
- Lombok
- Bean Validation
- Pageable

## Endpoints

| Method | Endpoint | Description |
|--------|----------|-------------|
| POST | /api/todos | Create new todo |
| GET | /api/todos | Get all todos |
| GET | /api/todos/{id} | Get todo by ID |
| PUT | /api/todos/{id} | Update todo |
| DELETE | /api/todos/{id} | Delete todo |
| GET | /api/todos/status/completed | Get completed todos |
| GET | /api/todos/status/pending | Get pending todos |
| GET | /api/todos?page=0&size=5 |Get number of todos in first page |
| GET | /api/todos?page=0&size=5&sort=dueDate,desc | Get todos by sorting with dueDate in descending order |
| GET | /api/todos?page=1&size=10&sort=id,asc | Get todos by sorting with id in ascending order | 
## Setup
1. Create MySQL database: `todo_management`
2. Configure `application.properties` with DB credentials
3. Run: `mvn spring-boot:run`

## Features
- CRUD operations for todos
- Filter todos by status (PENDING/COMPLETED)
- Bean validation
- Global exception handling
- Automatic timestamps on creation
- Using Pageable
- Sort by date

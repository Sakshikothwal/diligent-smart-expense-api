# Smart Expense Tracker API

A RESTful API built using Spring Boot to manage personal expenses.

## Features

- Add a new expense
- View all expenses
- Filter expenses by category
- Calculate total expenses
- Calculate total expenses by category
- Delete an expense
- Input validation
- Global exception handling
- Swagger/OpenAPI documentation
- Unit tests using JUnit 5

---

## Tech Stack

- Java 24
- Spring Boot 4.0.7
- Maven
- Lombok
- Spring Validation
- SpringDoc OpenAPI (Swagger)
- JUnit 5

---

## Installation

Clone the repository

```bash
git clone <repository-url>
```

Go to the project directory

```bash
cd expense-tracker
```

Install dependencies

```bash
mvn clean install
```

Run the application

```bash
mvn spring-boot:run
```

The application will start on:

```
http://localhost:8080
```

---

## Running Tests

```bash
mvn test
```

---

## Swagger Documentation

```
http://localhost:8080/swagger-ui/index.html
```

---

## API Endpoints

| Method | Endpoint | Description |
|---------|----------|-------------|
| POST | /expenses | Add a new expense |
| GET | /expenses | Get all expenses |
| GET | /expenses/category/{category} | Get expenses by category |
| GET | /expenses/total | Get total expenses |
| GET | /expenses/total/{category} | Get total by category |
| DELETE | /expenses/{id} | Delete an expense |

---

## Sample Request

```json
{
  "title": "Lunch",
  "amount": 250,
  "category": "Food",
  "date": "2026-07-31"
}
```

## Sample Response

```json
{
  "id": 1,
  "title": "Lunch",
  "amount": 250,
  "category": "Food",
  "date": "2026-07-31"
}
```

# Flight App Backend

This is the backend service for the Flight App, developed using Kotlin and Spring Boot. It provides APIs for managing flights, users, transactions, and payments. The backend is deployed on Render.com, and the database is hosted on AlwaysData using MySQL.

## Features

- User management (Create, Retrieve, Update, Delete users)
- Flight management (Search and Register flights)
- Payment management
- Transaction management
- Dockerized for easy deployment

## Technologies Used

- Kotlin (Spring Boot framework)
- MySQL (Database hosted on AlwaysData)
- Docker (Containerization)
- Render.com (Deployment platform)

## Installation & Setup

### Prerequisites

Ensure you have the following installed:

- Docker
- JDK
- Gradle

### Clone the Repository

```bash
git clone https://github.com/Ziraddin/flightappbackend.git
cd flight-app-backend
```

### Set Up Environment Variables

Create a `.env` file and configure your database connection:

```env
DB_HOST=your-alwaysdata-host
DB_PORT=your-db-port
DB_NAME=your-db-name
DB_USER=your-db-username
DB_PASSWORD=your-db-password
```

### Run with Docker

```bash
docker build -t flight-app-backend .
docker run -p 8080:8080 --env-file .env flight-app-backend
```

### Run Without Docker

```bash
./gradlew bootRun
```

## API Endpoints

### User Management

| Method | Endpoint                  | Description                                   |
|--------|---------------------------|-----------------------------------------------|
| GET    | /users/getAllUsers        | Retrieve all users                            |
| GET    | /users/getUser            | Get user by firstname, lastname, and email    |
| POST   | /users/addUser            | Create a new user                             |
| PUT    | /users/updateUser?id={id} | Update user details                           |
| DELETE | /users/deleteUser?id={id} | Delete a user                                 |

### Flight Management

| Method | Endpoint                      | Description                           |
|--------|-------------------------------|---------------------------------------|
| GET    | /flights/getAllFlights         | Retrieve all flights                  |
| GET    | /flights/getFlightById?id={id}  | Get flight by ID                      |
| POST   | /flights/addFlight             | Register a new flight                 |
| PUT    | /flights/updateFlight?id={id}   | Update flight details                 |
| DELETE | /flights/deleteFlight?id={id}   | Delete a flight                       |

### Payment Management

| Method | Endpoint                          | Description                           |
|--------|-----------------------------------|---------------------------------------|
| GET    | /payments/getAllPayments           | Retrieve all payment types            |
| GET    | /payments/getPaymentById?id={id}    | Get payment by ID                    |
| POST   | /payments/addPaymentType           | Add a new payment type                |
| PUT    | /payments/updatePaymentType?id={id} | Update a payment type                |
| DELETE | /payments/deletePaymentType?id={id} | Delete a payment type                |

### Transaction Management

| Method | Endpoint                                    | Description                           |
|--------|---------------------------------------------|---------------------------------------|
| GET    | /transactions/getAllTransactions            | Retrieve all transactions             |
| GET    | /transactions/getTransactionById?id={id}      | Get transaction by ID                |
| GET    | /transactions/getTransactionsByUserId?userid={userid} | Get transactions by user ID |
| POST   | /transactions/addTransaction                | Create a new transaction              |
| PUT    | /transactions/updateTransaction?id={id}     | Update a transaction                  |
| DELETE | /transactions/deleteTransaction?id={id}     | Delete a transaction                  |

## Deployment

The backend is deployed on Render.com, and the MySQL database is hosted on AlwaysData.

Render.com will automatically detect the push and redeploy the service.

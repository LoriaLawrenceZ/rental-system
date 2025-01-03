# Rental Service Application

This repository contains a rental service application with a Java back end and a React front end.

## Prerequisites

- Java 11 or higher
- Node.js and npm
- PostgreSQL database

## Setting up the Database

1. Install PostgreSQL and create a database named `rentaldb`.
2. Update the database configuration in `src/main/resources/application.properties` with your PostgreSQL username and password.
3. Run the SQL script located at `src/main/resources/db/migration/V1__create_rentaldb.sql` to create the database schema.

## Running the Back End

1. Navigate to the root directory of the project.
2. Run the following command to build the project:
   ```
   ./gradlew build
   ```
3. Run the following command to start the back end:
   ```
   ./gradlew bootRun
   ```

The back end will be running at `http://localhost:8080`.

## Running the Front End

1. Navigate to the `frontend` directory.
2. Run the following command to install the dependencies:
   ```
   npm install
   ```
3. Run the following command to start the front end:
   ```
   npm start
   ```

The front end will be running at `http://localhost:3000`.

## Deploying the Front End on Vercel

1. Install the Vercel CLI by running the following command:
   ```
   npm install -g vercel
   ```
2. Navigate to the `frontend` directory.
3. Run the following command to deploy the front end:
   ```
   vercel
   ```
4. Follow the prompts to complete the deployment.

The front end will be deployed on Vercel and accessible via the generated URL.

![Deployment](https://media.giphy.com/media/3o7aD2saalBwwftBIY/giphy.gif)

## API Endpoints

### Rentals

- `GET /api/rentals` - Get all rentals
- `GET /api/rentals/{id}` - Get rental by ID
- `POST /api/rentals` - Create a new rental
- `PUT /api/rentals/{id}` - Update a rental
- `DELETE /api/rentals/{id}` - Delete a rental

### Users

- `GET /api/users` - Get all users
- `GET /api/users/{id}` - Get user by ID
- `POST /api/users` - Create a new user
- `PUT /api/users/{id}` - Update a user
- `DELETE /api/users/{id}` - Delete a user

### Women

- `GET /api/women` - Get all women
- `GET /api/women/{id}` - Get woman by ID
- `POST /api/women` - Create a new woman
- `PUT /api/women/{id}` - Update a woman
- `DELETE /api/women/{id}` - Delete a woman

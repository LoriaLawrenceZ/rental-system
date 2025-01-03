CREATE DATABASE rentaldb;

\c rentaldb;

CREATE TABLE users (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL
);

CREATE TABLE women (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    mood VARCHAR(255),
    breast_size DOUBLE PRECISION,
    waist_size DOUBLE PRECISION,
    hip_size DOUBLE PRECISION
);

CREATE TABLE rentals (
    id SERIAL PRIMARY KEY,
    user_id INT NOT NULL,
    woman_id INT NOT NULL,
    rental_date TIMESTAMP NOT NULL,
    FOREIGN KEY (user_id) REFERENCES users(id),
    FOREIGN KEY (woman_id) REFERENCES women(id)
);

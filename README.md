# User Login and Registration Backend

[![License](https://img.shields.io/badge/license-MIT-blue.svg)](https://opensource.org/licenses/MIT)
[![Java](https://img.shields.io/badge/java-8-blue.svg)](https://www.oracle.com/java/technologies/javase-jdk8-downloads.html)
[![Spring Boot](https://img.shields.io/badge/spring%20boot-2.5.4-brightgreen.svg)](https://spring.io/projects/spring-boot)
[![Build Status](https://travis-ci.com/your-username/user-login-registration-backend.svg?branch=main)](https://travis-ci.com/your-username/user-login-registration-backend)

This project provides a secure backend implementation for user registration, login, email verification, and JWT token-based authentication.

## Table of Contents

- [Technologies](#technologies)
- [Features](#features)
- [Installation](#installation)
- [Configuration](#configuration)
- [Usage](#usage)
- [License](#license)

## Technologies

- Java 8
- Spring Boot 2.5.4
- Spring Security
- Spring Data JPA
- Maildev (SMTP server for testing email)
- JSON Web Tokens (JWT)
- Maven

## Features

- User registration with email verification
- User login with JWT token generation
- Password hashing for secure storage
- API endpoints for user management
- Integration with Maildev for testing email functionality
- Exception handling and error responses

## Installation
1. Clone the repository to your local machine:

```shell
git clone https://github.com/oussama-gadria/Signup-and-Signin-using-spring-

```
2. Navigate to the project directory:

```shell
cd Signup-and-Signin-using-spring-

```
3. Build the project using Maven:

```shell
mvn clean package

```
# Database Configuration
spring.datasource.url=jdbc:mysql://localhost:3306/your-database-name
spring.datasource.username=your-database-username
spring.datasource.password=your-database-password

# Maildev Configuration
spring.mail.host=localhost
spring.mail.port=1025

# JWT Configuration
jwt.secret=your-jwt-secret-key

## Usage
jwt.secret=your-jwt-secret-key

1. Start the Maildev server:

```shell
maildev

```

2. Start the backend server:

```shell
java -jar localisation-To-Your-JarFle.jar

```
3. The backend server will be running at http://localhost:8080.

## License

This project is licensed under the MIT License.

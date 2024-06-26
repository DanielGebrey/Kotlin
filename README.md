# Orders Service

## Overview
Orders Service is a Kotlin-based RESTful API developed using Spring Boot.

## Features
- Create orders with apples and oranges, applying special offers:
  - Buy one get one free on apples.
  - Three for the price of two on oranges.
- Retrieve orders by their unique identifier.
- List all orders stored in the system.

## Technologies
- **Kotlin** - Main programming language.
- **Spring Boot** - Application framework.
- **H2 Database** - In-memory database for storing orders.
- **JUnit** - For running unit and integration tests.
- **Mockito** - For mocking dependencies in tests.
- **Gradle** - Build and dependency management.

## Getting Started

### Prerequisites
Ensure you have the following installed:
- JDK 1.8 or later
- Gradle 6.3 or later

### Installation

1. **Clone the repository**
   ```bash
   git clone https://github.com/DanielGebrey/Kotlin.git
   cd orders-service

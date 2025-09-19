# Rick and Morty API Client (Spring Boot)

This project is a small Spring Boot backend that fetches data from the [Rick and Morty API](https://rickandmortyapi.com/) and exposes custom endpoints.  
It was built as a practice project for working with REST clients in Spring Boot 3.

---

## Features

- 🔍 Fetch all characters
- 👤 Fetch a character by ID
- 🧬 Filter by status (alive, dead, unknown)
- 🧑‍🤝‍🧑 Filter by species
- 📊 **Species Statistics Endpoint**: get the number of living characters of a given species

---

## Endpoints

### All characters
> GET http://localhost:8080/api/characters

### Character by ID
> GET http://localhost:8080/api/characters/{id}

### Characters by status
> GET http://localhost:8080/api/characters?status=alive

### Living characters by species (returns only a number)
> GET http://localhost:8080/api/species-statistics?species=Human

---

## Installation & Run

Clone repository 
> git clone <repo-url>

Build with Maven
> mvn clean install

Start Spring Boot
> mvn spring-boot:run

Test with Postman or in your browser.

## Tech Stack
- Java 21
- Spring Boot 3.x
- Spring Web (RestClient)
- Maven 

## Note
All data comes directly from the official Rick and Morty API.
This project is for learning and demonstration purposes only.
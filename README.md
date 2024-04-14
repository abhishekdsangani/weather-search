# Weather Search API Integration

This is a simple Spring Boot application that integrates with the Weather Search API using RapidAPI. It provides RESTful APIs to retrieve weather forecast data for any city.

## Getting Started

### Prerequisites

- Java 11
- Maven

### Used Libraries

This application utilizes Java's built-in HttpClient for making HTTP requests, eliminating the need for additional dependencies.

### Error Handling

The application handles 429 (Too Many Requests) errors gracefully. If the API rate limit is reached, the SDK automatically retries the request up to 10 times with a timeout of 15 seconds between attempts.

### Installation

1. Clone the repository:

    ```bash
    git clone https://github.com/abhishekdsangani/weather-search.git
    ```

2. Navigate to the project directory:

    ```bash
    cd weather-search
    ```

3. Build the project:

    ```bash
    mvn clean compile install
    ```

4. Run the application:

    ```bash
    java -jar target/weather-search-1.0.0.jar
    ```

### Usage

Once the application is running, you can access the following endpoints:

#### API 1: Get Weather Forecast Summary

- **Endpoint:** `/weather/summary/{cityName}`
- **Method:** GET
- **Headers:**
    - `X-RapidAPI-Key`: Your RapidAPI Key
- **Description:** Retrieves the weather forecast summary for the specified city.

Example:
```bash
curl -X GET http://localhost:8080/weather/summary/London -H "X-RapidAPI-Key: YOUR_RAPIDAPI_KEY"
```

#### API 2: Get Hourly Weather Forecast

- **Endpoint:** `/weather/hourly/{cityName}`
- **Method:** GET
- **Headers:**
    - `X-RapidAPI-Key`: Your RapidAPI Key
- **Description:** Retrieves the hourly weather forecast for the specified city.

Example:
```bash
curl -X GET http://localhost:8080/weather/hourly/NewYork -H "X-RapidAPI-Key: YOUR_RAPIDAPI_KEY"
```

### Authentication

This application uses header-based authentication with a RapidAPI Key (`X-RapidAPI-Key`). You need to obtain a RapidAPI Key from RapidAPI ([https://rapidapi.com/](https://rapidapi.com/)) and include it in the request headers for authentication.

### Built With

- [Spring Boot](https://spring.io/projects/spring-boot) - Framework for building Java applications
- [RapidAPI](https://rapidapi.com/) - Platform for accessing APIs

### Authors

- Abhishek Sangani - [GitHub Profile](https://github.com/abhishekdsangani)

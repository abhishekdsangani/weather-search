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

### Authentication

Authentication is performed using header-based mechanisms:
- **RapidAPI Key**: Include your RapidAPI Key (`X-RapidAPI-Key`) in the request headers.
- **Basic Authentication**: For accessing weather forecast endpoints, provide Basic Authentication with your client credentials (clientId and clientSecret) encoded in base64 format in the `Authorization` header.

### Usage

Once the application is running, you can access the following endpoints:

#### API 1: Generate Access Token

- **Endpoint:** `/generateToken`
- **Method:** POST
- **Body:** 
```bash
  {
    "clientId": "your_client_id",
    "clientSecret": "your_client_secret"
  }
```
- **Description:** Generates an access token for API authentication.

Example:
```bash
curl -X POST http://localhost:8080/generateToken -H "Content-Type: application/json" -d '{"clientId": "your_client_id", "clientSecret": "your_client_secret"}'
```

#### API 2: Get Weather Forecast Summary

- **Endpoint:** `/weather/summary/{cityName}`
- **Method:** GET
- **Headers:**
    - `X-RapidAPI-Key`: Your RapidAPI Key
    - `Authorization`: Basic {base64_encoded(clientId:clientSecret)}
- **Description:** Retrieves the weather forecast summary for the specified city.

Example:
```bash
curl -X GET http://localhost:8080/weather/summary/London -H "X-RapidAPI-Key: YOUR_RAPIDAPI_KEY" -H "Authorization: Basic base64_encoded(clientId:clientSecret)"
```

#### API 3: Get Hourly Weather Forecast

- **Endpoint:** `/weather/hourly/{cityName}`
- **Method:** GET
- **Headers:**
    - `X-RapidAPI-Key`: Your RapidAPI Key
    - `Authorization`: Basic {base64_encoded(clientId:clientSecret)}
- **Description:** Retrieves the hourly weather forecast for the specified city.

Example:
```bash
curl -X GET http://localhost:8080/weather/hourly/NewYork -H "X-RapidAPI-Key: YOUR_RAPIDAPI_KEY" -H "Authorization: Basic base64_encoded(clientId:clientSecret)"
```

### Built With

- [Spring Boot](https://spring.io/projects/spring-boot) - Framework for building Java applications
- [RapidAPI](https://rapidapi.com/) - Platform for accessing APIs

### Authors

- Abhishek Sangani - [GitHub Profile](https://github.com/abhishekdsangani)

FROM openjdk:11
WORKDIR /app
COPY target/weather-search-api-integration.jar /app/weather-search-api-integration.jar
EXPOSE 8080
CMD ["java", "-jar", "weather-search-api-integration.jar"]

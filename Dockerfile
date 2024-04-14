FROM openjdk:11
WORKDIR /app
COPY target/weather-search.jar /app/weather-search.jar
EXPOSE 8080
CMD ["java", "-jar", "weather-search.jar"]

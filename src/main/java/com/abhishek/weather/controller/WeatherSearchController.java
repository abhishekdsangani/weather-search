package com.abhishek.weather.controller;

import com.abhishek.weather.api.model.LocationWrapper;
import com.abhishek.weather.service.WeatherService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import java.util.Base64;

import static com.abhishek.weather.api.constant.RapidAPIConstantCodes.AUTH_HEADER_RAPID_API_KEY;

@RestController
@RequiredArgsConstructor
public class WeatherSearchController {

    private static final String AUTH_TYPE_BASIC = "Basic";

    private final WeatherService weatherService;

    @Value("${rapid.api.token}")
    private String rapidAPIHeader;

    @Value("${weather.search.clientId}")
    private String clientId;

    @Value("${weather.search.clientSecret}")
    private String clientSecret;

    @GetMapping("/weather/{forecastType}/{cityName}")
    public LocationWrapper getWeatherForecast(@PathVariable String forecastType,
                                              @PathVariable String cityName,
                                              //@RequestHeader(AUTH_HEADER_RAPID_API_KEY) String rapidAPIHeader,
                                              @RequestHeader(HttpHeaders.AUTHORIZATION) String accessToken) {

        LocationWrapper response = new LocationWrapper();
        if (accessToken == null || !accessToken.startsWith(AUTH_TYPE_BASIC)) {
            response.setMessage("Unauthorized access");
            return response;
        }

        String decodedToken = new String(Base64.getDecoder().decode(accessToken.substring(6)));
        String[] credentialsArray = decodedToken.split(":");
        if (credentialsArray.length != 2) {
            response.setMessage("Invalid credentials");
            return response;
        }

        if (!credentialsArray[0].equals(clientId) || !credentialsArray[1].equals(clientSecret)) {
            response.setMessage("Invalid credentials");
            return response;
        }

        if (forecastType.equalsIgnoreCase("summary") || forecastType.equalsIgnoreCase("hourly")) {
            return weatherService.getForecast(cityName, forecastType, rapidAPIHeader);

        } else {
            response.setMessage("Invalid forecast type. Please provide either 'summary' or 'hourly'.");
            return response;
        }
    }

    static class UnauthorizedException extends RuntimeException {
        public UnauthorizedException(String message) {
            super(message);
        }
    }

    static class InvalidCredentialsException extends RuntimeException {
        public InvalidCredentialsException(String message) {
            super(message);
        }
    }
}
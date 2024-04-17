package com.abhishek.weather.controller;

import com.abhishek.weather.api.model.LocationWrapper;
import com.abhishek.weather.service.WeatherService;
import lombok.RequiredArgsConstructor;
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

    @GetMapping("/weather/{forecastType}/{cityName}")
    public LocationWrapper getWeatherForecast(@PathVariable String forecastType,
                                              @PathVariable String cityName,
                                              @RequestHeader(AUTH_HEADER_RAPID_API_KEY) String rapidAPIHeader,
                                              @RequestHeader(HttpHeaders.AUTHORIZATION) String accessToken) {

        if (accessToken == null || !accessToken.startsWith(AUTH_TYPE_BASIC)) {
            throw new UnauthorizedException("Unauthorized access");
        }

        String decodedToken = new String(Base64.getDecoder().decode(accessToken.substring(6)));
        String[] credentialsArray = decodedToken.split(":");
        if (credentialsArray.length != 2) {
            throw new InvalidCredentialsException("Invalid credentials");
        }

        if (forecastType.equalsIgnoreCase("summary") || forecastType.equalsIgnoreCase("hourly")) {
            return weatherService.getForecast(cityName, forecastType, rapidAPIHeader);

        } else {
            LocationWrapper response = new LocationWrapper();
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
package com.abhishek.weather.controller;

import com.abhishek.weather.api.model.LocationWrapper;
import com.abhishek.weather.service.WeatherService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import static com.abhishek.weather.api.constant.RapidAPIConstantCodes.AUTH_HEADER_RAPID_API_KEY;

@RestController
@RequiredArgsConstructor
public class WeatherSearchController {

    private final WeatherService weatherService;

    @GetMapping("/weather/{forecastType}/{cityName}")
    public LocationWrapper getWeatherForecast(@PathVariable String forecastType,
                                              @PathVariable String cityName,
                                              @RequestHeader(AUTH_HEADER_RAPID_API_KEY) String authHeader) {

        if (forecastType.equalsIgnoreCase("summary") || forecastType.equalsIgnoreCase("hourly")) {
            return weatherService.getForecast(cityName, forecastType, authHeader);

        } else {
            LocationWrapper response = new LocationWrapper();
            response.setMessage("Invalid forecast type. Please provide either 'summary' or 'hourly'.");
            return response;
        }
    }
}
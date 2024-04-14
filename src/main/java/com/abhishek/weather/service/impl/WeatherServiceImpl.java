package com.abhishek.weather.service.impl;

import com.abhishek.weather.api.RapidWeatherAPI;
import com.abhishek.weather.api.RapidWeatherCredentials;
import com.abhishek.weather.api.model.LocationWrapper;
import com.abhishek.weather.service.WeatherService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class WeatherServiceImpl implements WeatherService {

    private final RapidWeatherAPI rapidWeatherAPI;
    private final RapidWeatherCredentials rapidWeatherCredentials;

    @Override
    public LocationWrapper getForecast(String city, String forecastType, String authHeader) {
        rapidWeatherCredentials.setApiKey(authHeader);
        return rapidWeatherAPI.getForecastByLocationName(city, forecastType);
    }
}
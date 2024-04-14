package com.abhishek.weather.service;

import com.abhishek.weather.api.model.LocationWrapper;

public interface WeatherService {

    LocationWrapper getForecast(String city, String forecastType, String authHeader);
}

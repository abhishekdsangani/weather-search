package com.abhishek.weather.dto;

import lombok.Data;

@Data
public class WeatherSearchCredentials {
    private String clientId;
    private String clientSecret;
}
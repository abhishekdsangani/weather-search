package com.abhishek.weather.api;

import lombok.Data;

import static com.abhishek.weather.api.constant.RapidAPIConstantCodes.RAPID_API_DOMAIN;

@Data
public class RapidWeatherCredentials {
    private String domain = RAPID_API_DOMAIN;
    private String apiKey;
}

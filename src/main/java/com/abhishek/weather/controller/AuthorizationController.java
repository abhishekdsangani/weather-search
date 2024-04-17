package com.abhishek.weather.controller;

import com.abhishek.weather.dto.WeatherSearchAccessTokenResponse;
import com.abhishek.weather.dto.WeatherSearchCredentials;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Base64;

@RestController
public class AuthorizationController {

    @PostMapping("/generateToken")
    public WeatherSearchAccessTokenResponse generateToken(@RequestBody WeatherSearchCredentials client) {

        WeatherSearchAccessTokenResponse weatherSearchAccessTokenResponse = new WeatherSearchAccessTokenResponse();
        weatherSearchAccessTokenResponse.setAccessToken(generateToken(client.getClientId(), client.getClientSecret()));
        return weatherSearchAccessTokenResponse;
    }

    public static String generateToken(String clientId, String clientSecret) {
        String credentials = clientId + ":" + clientSecret;
        String encodedCredentials = Base64.getEncoder().encodeToString(credentials.getBytes());
        return "Basic " + encodedCredentials;
    }
}
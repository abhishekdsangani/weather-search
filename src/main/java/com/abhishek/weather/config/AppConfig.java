package com.abhishek.weather.config;

import com.abhishek.weather.api.RapidWeatherAPI;
import com.abhishek.weather.api.RapidWeatherCredentials;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    RapidWeatherCredentials rapidWeatherCredentials(){
        return new RapidWeatherCredentials();
    }

    @Bean
    RapidWeatherAPI rapidWeatherAPI(){
        return new RapidWeatherAPI(rapidWeatherCredentials());
    }
}

package com.abhishek.weather;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.ApplicationPidFileWriter;

@SpringBootApplication
public class WeatherSearchApplication {

    public static void main(String[] args) {
        SpringApplication springApplication = new SpringApplication(WeatherSearchApplication.class);
        springApplication.addListeners(new ApplicationPidFileWriter());
        springApplication.run(args);
    }

}

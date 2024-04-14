package com.abhishek.weather.api.model;

import com.abhishek.weather.api.serializer.DateTimeDeserializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class Forecast {
    private List<Item> items;

    @JsonDeserialize(using = DateTimeDeserializer.class)
    private LocalDateTime forecastDate;

    @JsonDeserialize(using = DateTimeDeserializer.class)
    private LocalDateTime nextUpdate;

    private String source;
    private String point;
    private String fingerprint;
}

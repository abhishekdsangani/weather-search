package com.abhishek.weather.api.model;

import com.abhishek.weather.api.serializer.DateTimeDeserializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Astronomy {

    @JsonDeserialize(using = DateTimeDeserializer.class)
    private LocalDateTime dawn;

    @JsonDeserialize(using = DateTimeDeserializer.class)
    private LocalDateTime sunrise;

    @JsonDeserialize(using = DateTimeDeserializer.class)
    private LocalDateTime suntransit;

    @JsonDeserialize(using = DateTimeDeserializer.class)
    private LocalDateTime sunset;

    @JsonDeserialize(using = DateTimeDeserializer.class)
    private LocalDateTime dusk;

    @JsonDeserialize(using = DateTimeDeserializer.class)
    private LocalDateTime moonrise;

    @JsonDeserialize(using = DateTimeDeserializer.class)
    private LocalDateTime moontransit;

    @JsonDeserialize(using = DateTimeDeserializer.class)
    private LocalDateTime moonset;

    private Integer moonphase;
    private Integer moonzodiac;
}

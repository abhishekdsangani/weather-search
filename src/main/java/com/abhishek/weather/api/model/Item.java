package com.abhishek.weather.api.model;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Item {
    private String date;
    private String period;
    private String pressure;
    private Boolean isNight;
    private String relativeHumidity;
    private Clouds clouds;

    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    private LocalDateTime dateWithTimezone;
    private Integer freshSnow;
    private Integer snowHeight;
    private Weather weather;
    private Prec prec;
    private Integer sunHours;
    private Integer rainHours;
    private Temperature temperature;
    private Wind wind;
    private Windchill windchill;
    private SnowLine snowLine;
    private Astronomy astronomy;
}

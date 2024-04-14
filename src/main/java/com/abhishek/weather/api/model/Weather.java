package com.abhishek.weather.api.model;

import lombok.Data;

@Data
public class Weather {
    private Integer state;
    private String text;
    private String icon;
}

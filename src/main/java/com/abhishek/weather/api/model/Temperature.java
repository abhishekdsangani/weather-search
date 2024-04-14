package com.abhishek.weather.api.model;

import lombok.Data;

@Data
public class Temperature {
    private Integer min;
    private Integer max;
    private Integer avg;
}

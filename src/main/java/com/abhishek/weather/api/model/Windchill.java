package com.abhishek.weather.api.model;

import lombok.Data;

@Data
public class Windchill {
    private Integer avg;
    private Integer min;
    private Integer max;
}

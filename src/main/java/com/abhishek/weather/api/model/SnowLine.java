package com.abhishek.weather.api.model;

import lombok.Data;

@Data
public class SnowLine {
    public Integer avg;
    public Integer min;
    public Integer max;
    public String unit;
}

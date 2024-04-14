package com.abhishek.weather.api.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Prec {
    private Integer sum;
    private Integer probability;
    private Integer sumAsRain;

    @JsonProperty("class")
    private Integer myclass;
}

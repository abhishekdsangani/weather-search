package com.abhishek.weather.api.model;

import lombok.Data;


@Data
/*@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)*/
public class Wind {
    private String unit;
    private String direction;
    private String text;
    private Double avg;
    private Integer min;
    private Integer max;
    private Gusts gusts;
    private Boolean significationWind;
}

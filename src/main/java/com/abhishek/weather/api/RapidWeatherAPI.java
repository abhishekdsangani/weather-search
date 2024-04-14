package com.abhishek.weather.api;

import com.abhishek.weather.api.model.LocationWrapper;

import java.net.URI;
import java.net.http.HttpRequest;

import static com.abhishek.weather.api.constant.RapidAPIConstantCodes.FORWARD_SLASH;
import static com.abhishek.weather.api.constant.RapidAPIConstantCodes.RAPID_API_FORECAST_ENDPOINT;

public class RapidWeatherAPI extends RapidWeatherSDK {

    public RapidWeatherAPI(RapidWeatherCredentials rapidWeatherCredentials) {
        super(rapidWeatherCredentials);
    }

    public LocationWrapper getForecastByLocationName(String locationName, String forecastType) {
        URI uri = URI.create(RAPID_API_FORECAST_ENDPOINT + locationName + FORWARD_SLASH + forecastType + FORWARD_SLASH);
        HttpRequest request = get(uri);
        return getRequestWrapped(request, LocationWrapper.class);
    }
}

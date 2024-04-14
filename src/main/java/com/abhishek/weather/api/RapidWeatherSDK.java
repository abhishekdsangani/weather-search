package com.abhishek.weather.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;

import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

import static java.nio.charset.StandardCharsets.UTF_8;

public class RapidWeatherSDK {

    int MAX_ATTEMPTS = 10;
    int TIME_OUT_DURATION = 15000;
    public RapidWeatherCredentials rapidWeatherCredentials;
    protected HttpClient client;
    private final ObjectMapper objectMapper;
    protected String baseUrl;

    public RapidWeatherSDK(RapidWeatherCredentials rapidWeatherCredentials) {
        this.rapidWeatherCredentials = rapidWeatherCredentials;
        this.objectMapper = new ObjectMapper();
        client = HttpClient.newHttpClient();
    }

    @SneakyThrows
    protected <T> T getRequestWrapped(HttpRequest request, Class<T> tclass) {

        return client.sendAsync(request, HttpResponse.BodyHandlers.ofString())
                .thenComposeAsync(response -> tryResend(client, request, HttpResponse.BodyHandlers.ofString(), response, 1))
                .thenApplyAsync(HttpResponse::body)
                .thenApplyAsync(responseBody -> convertBody(responseBody, tclass))
                .get();
    }

    @SneakyThrows
    private <T> T convertBody(String body, Class<T> tClass) {
        return objectMapper.readValue(body, tClass);
    }

    protected HttpRequest get(URI uri) {
        return HttpRequest.newBuilder(baseUrl(uri))
                .header("X-RapidAPI-Host", rapidWeatherCredentials.getDomain())
                .header("X-RapidAPI-Key", rapidWeatherCredentials.getApiKey())
                .GET()
                .build();
    }

    public URI baseUrl(URI path) {
        baseUrl = "https://" + rapidWeatherCredentials.getDomain();
        return URI.create(baseUrl + path);
    }

    @SneakyThrows
    public <T> CompletableFuture<HttpResponse<T>> tryResend(HttpClient client,
                                                            HttpRequest request,
                                                            HttpResponse.BodyHandler<T> handler,
                                                            HttpResponse<T> resp, int count) {

        if (resp.statusCode() == 429 && count < MAX_ATTEMPTS) {
            Thread.sleep(TIME_OUT_DURATION);
            return client.sendAsync(request, handler)
                    .thenComposeAsync(response -> tryResend(client, request, handler, response, count + 1));
        }
        return CompletableFuture.completedFuture(resp);
    }
}

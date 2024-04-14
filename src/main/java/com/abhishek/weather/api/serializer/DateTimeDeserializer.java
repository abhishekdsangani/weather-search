package com.abhishek.weather.api.serializer;


import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import lombok.SneakyThrows;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

import static java.time.format.DateTimeFormatter.ISO_OFFSET_DATE_TIME;

public class DateTimeDeserializer extends JsonDeserializer<LocalDateTime> {

    private static final DateTimeFormatter ISO_8601_TIMESTAMP_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");

    @Override
    @SneakyThrows
    public LocalDateTime deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) {
        String timestamp = jsonParser.getText().trim();
        try {
            return LocalDateTime.parse(timestamp, ISO_8601_TIMESTAMP_FORMATTER);
        } catch (DateTimeParseException exception) {
            return LocalDateTime.parse(timestamp, ISO_OFFSET_DATE_TIME);
        }
    }
}
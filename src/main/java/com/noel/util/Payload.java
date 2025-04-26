package com.noel.util;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Payload {
    @JsonProperty("sub")
    private String userId;

    // This is how we parse the payload and get the user id
    public static Payload generate(String json) {
        try {
            return new ObjectMapper().readValue(json, Payload.class);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}


package com.noel.proxy;

import com.noel.model.User;
import java.util.Map;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

// This is a class that transmits all http requests from the user to user service
@Component
public class UserProxy {
    private final RestTemplate restTemplate;
    private final String url;

    public UserProxy(@Value("${url.user}") String url, RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
        this.url = url;
    }

    public User getUser(String userId) {
        return restTemplate.getForObject(url + "users/{userId}", User.class, Map.of("userId", userId));
    }
}

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

    public User create(User user) {
        System.out.println((url + "users"));
        return restTemplate.postForObject(url + "users", user, User.class);
    }

    public User[] getAllUsers() {
        return restTemplate.getForObject(url + "users", User[].class);
    }

    public User getUser(String userId) {
        return restTemplate.getForObject(url + "users/{userId}", User.class, Map.of("userId", userId));
    }
}

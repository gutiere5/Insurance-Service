package com.noel.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class User {
    private String login;
    private String password;
    private String phone;
    private String email;

    private Profile profile;
}

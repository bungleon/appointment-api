package com.appointment.api.security.login;


import javax.validation.constraints.NotEmpty;

public class LoginRequest {

    @NotEmpty
    private String email;

    @NotEmpty
    private String password;

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
}

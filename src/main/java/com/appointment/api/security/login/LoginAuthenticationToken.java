package com.appointment.api.security.login;

import org.springframework.security.authentication.AbstractAuthenticationToken;


public class LoginAuthenticationToken extends AbstractAuthenticationToken {

    private String email;

    private String password;

    public LoginAuthenticationToken(String email, String password) {
        super(null);
        this.email = email;
        this.password = password;
    }

    @Override
    public Object getCredentials() {
        return null;
    }

    @Override
    public Object getPrincipal() {
        return null;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
}

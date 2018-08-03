package com.appointment.api.security.jwt;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class JwtConfig {
    @Value("${jwt.expiration}")
    private String expiration;

    @Value("${jwt.secretKey}")
    private String secretKey;

    public Integer getExpiration() {
        return Integer.parseInt(expiration);
    }

    public String getSecretKey() {
        return secretKey;
    }
}

package com.appointment.api.component;

import com.appointment.api.domain.user.User;
import com.appointment.api.security.jwt.JwtService;
import com.appointment.api.service.user.UserService;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.UUID;

@Component
public class AuthUser {
    private final JwtService jwtService;
    private final UserService userService;

    public AuthUser(JwtService jwtService, UserService userService) {
        this.jwtService = jwtService;
        this.userService = userService;
    }

    public User getUser() {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        String token = request.getHeader("Authorization");
        token = token.substring(7);
        return userService.getUserById(jwtService.getUserIdFromJwt(token));
    }

    public UUID getUserId() {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        String token = request.getHeader("Authorization");
        token = token.substring(7);
        return jwtService.getUserIdFromJwt(token);
    }
}

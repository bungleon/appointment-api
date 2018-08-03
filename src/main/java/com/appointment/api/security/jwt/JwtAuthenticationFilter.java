package com.appointment.api.security.jwt;

import com.appointment.api.exception.ResponseCode;
import com.appointment.api.security.AbstractSystemAuthenticationFilter;
import com.appointment.api.security.SystemAuthenticationException;
import com.appointment.api.service.user.UserService;
import com.appointment.api.service.user.UserServiceImpl;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class JwtAuthenticationFilter extends AbstractSystemAuthenticationFilter {
    private final JwtService jwtService;


    public JwtAuthenticationFilter(Gson gson, JwtService jwtService) {
        super(gson);
        this.jwtService = jwtService;
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException, IOException, ServletException {
        try {
            String jwtToken = jwtService.jwtExtractor(request);
            JwtAuthenticationToken authenticationToken = new JwtAuthenticationToken(jwtToken);
            return super.getAuthenticationManager().authenticate(authenticationToken);

        } catch (org.springframework.security.core.AuthenticationException authException) {
            throw authException;
        } catch (Exception exception) {
        }

        throw new SystemAuthenticationException("System Error", ResponseCode.UNDEFINED_ERROR);
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authResult) throws IOException, ServletException {
        SecurityContextHolder.getContext().setAuthentication(authResult);
        chain.doFilter(request, response);
        SecurityContextHolder.getContext().setAuthentication(null);
    }
}

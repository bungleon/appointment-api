package com.appointment.api.security;

import com.appointment.api.exception.ResponseCode;
import com.appointment.api.message.response.BaseResponse;
import com.appointment.api.security.login.LoginRequest;
import com.google.gson.Gson;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Reader;

public abstract class AbstractSystemAuthenticationFilter extends AbstractAuthenticationProcessingFilter {
    private final Gson gson;

    protected AbstractSystemAuthenticationFilter(Gson gson) {
        super(new AntPathRequestMatcher(SecurityConfig.AUTH_URL, HttpMethod.POST.name()));
        this.gson = gson;
    }

    public LoginRequest getRequestFromBody(Reader reader) {
        try {
            return gson.fromJson(reader, LoginRequest.class);
        } catch (Exception e) {

        }
        return null;
    }

    @Override
    protected void unsuccessfulAuthentication(HttpServletRequest request, HttpServletResponse response, org.springframework.security.core.AuthenticationException failed) throws IOException, ServletException {
        BaseResponse baseResponse = new BaseResponse(ResponseCode.ACCESS_DENIED);
        if (failed instanceof SystemAuthenticationException) {
            SystemAuthenticationException authException = (SystemAuthenticationException) failed;
            baseResponse = new BaseResponse(authException.getResponseCode());
        }
        response.setStatus(HttpStatus.UNAUTHORIZED.value());
        flushResponse(response, baseResponse);
    }

    public void flushResponse(HttpServletResponse servletResponse, Object response) throws IOException {
        servletResponse.setContentType(MediaType.APPLICATION_JSON_UTF8_VALUE);
        servletResponse.getWriter().write(gson.toJson(response));
        servletResponse.flushBuffer();
        SecurityContextHolder.getContext().setAuthentication(null);
    }
}

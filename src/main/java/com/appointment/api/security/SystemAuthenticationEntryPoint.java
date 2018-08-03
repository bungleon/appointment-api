package com.appointment.api.security;

import com.appointment.api.exception.ResponseCode;
import com.appointment.api.message.response.BaseResponse;
import com.google.gson.Gson;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class SystemAuthenticationEntryPoint implements AuthenticationEntryPoint {
    private final Gson gson;

    public SystemAuthenticationEntryPoint(Gson gson) {
        this.gson = gson;
    }

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException, ServletException {
        flushResponse(response);
    }

    private void flushResponse(HttpServletResponse servletResponse) throws IOException {
        servletResponse.setStatus(HttpStatus.UNAUTHORIZED.value());
        servletResponse.setContentType(MediaType.APPLICATION_JSON_UTF8_VALUE);
        servletResponse.getWriter().write(gson.toJson(new BaseResponse(ResponseCode.ACCESS_DENIED)));
        servletResponse.flushBuffer();
    }
}

package com.appointment.api.security.login;

import com.appointment.api.exception.ResponseCode;
import com.appointment.api.security.AbstractSystemAuthenticationFilter;
import com.appointment.api.security.AuthenticatedUserToken;
import com.appointment.api.security.SystemAuthenticationException;
import com.appointment.api.security.jwt.JwtConfig;
import com.google.gson.Gson;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.ConstraintViolation;
import javax.validation.ValidatorFactory;
import java.io.IOException;
import java.util.Set;

public class LoginAuthenticationFilter extends AbstractSystemAuthenticationFilter {
    private final ValidatorFactory validatorFactory;
    private final JwtConfig jwtConfig;

    public LoginAuthenticationFilter(Gson gson, ValidatorFactory validatorFactory, JwtConfig jwtConfig) {
        super(gson);
        this.validatorFactory = validatorFactory;
        this.jwtConfig = jwtConfig;
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException, IOException, ServletException {
        try {
            LoginRequest loginRequest = getRequestFromBody(request.getReader());
            if (loginRequest == null || !isValidRequest(loginRequest)) {
                throw new SystemAuthenticationException("Invalid Login Request", ResponseCode.INVALID_REQUEST);
            }

            LoginAuthenticationToken authenticationToken = new LoginAuthenticationToken(loginRequest.getEmail(), loginRequest.getPassword());
            Authentication authenticate = super.getAuthenticationManager().authenticate(authenticationToken);
            return authenticate;
        } catch (org.springframework.security.core.AuthenticationException authException) {

            throw authException;
        } catch (Exception exception) {

        }

        throw new SystemAuthenticationException("System Error", ResponseCode.UNDEFINED_ERROR);
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authResult) throws IOException, ServletException {
        AuthenticatedUserToken user = (AuthenticatedUserToken) authResult;
        LoginResponse loginResponse = new LoginResponse(ResponseCode.SUCCESS, user.getToken(), jwtConfig.getExpiration(), getRoles(user.getUser().getRole()));
        flushResponse(response, loginResponse);
    }


    boolean isValidRequest(LoginRequest request) {
        Set<ConstraintViolation<LoginRequest>> validate = validatorFactory.getValidator().validate(request);
        return validate.size() == 0;
    }

    private String[] getRoles(String role) {
        return role.split(",");
    }
}

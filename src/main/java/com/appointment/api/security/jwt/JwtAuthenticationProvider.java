package com.appointment.api.security.jwt;

import com.appointment.api.domain.user.User;
import com.appointment.api.domain.user.UserRepository;
import com.appointment.api.exception.ResponseCode;
import com.appointment.api.security.AuthenticatedUserToken;
import com.appointment.api.security.SystemAuthenticationException;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.UUID;

@Component
public class JwtAuthenticationProvider implements AuthenticationProvider {

    private final JwtService jwtService;

    private final UserRepository userRepository;

    public JwtAuthenticationProvider(JwtService jwtService, UserRepository userRepository) {
        this.jwtService = jwtService;
        this.userRepository = userRepository;
    }

    @Override
    public Authentication authenticate(Authentication authentication) throws org.springframework.security.core.AuthenticationException {
        JwtAuthenticationToken jwtToken = (JwtAuthenticationToken) authentication;
        UUID userId = Optional.ofNullable(jwtService.getUserIdFromJwt(jwtToken.getToken()))
                .orElseThrow(() -> new SystemAuthenticationException(jwtToken.getToken(), ResponseCode.INVALID_CREDENTIALS));

        if (jwtService.checkIp(jwtToken.getToken())) {
            throw new SystemAuthenticationException(jwtToken.getToken(), ResponseCode.INVALID_IP);

        }

        User user = userRepository.findById(userId)
                .orElseThrow(() -> new SystemAuthenticationException(userId.toString(), ResponseCode.INVALID_CREDENTIALS));

        String userRole = Optional.ofNullable(user.getRole())
                .orElseThrow(() -> new SystemAuthenticationException(String.format("Not granted any authorities. Email : %s, Role : %s", user.getEmail(), user.getRole()), ResponseCode.AUTHORITIES_NOT_FOUND));

        return new AuthenticatedUserToken(jwtToken.getToken(), user, AuthorityUtils.commaSeparatedStringToAuthorityList(userRole));
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(JwtAuthenticationToken.class);
    }
}

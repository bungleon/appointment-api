package com.appointment.api.security.jwt;

import com.appointment.api.domain.user.User;
import com.appointment.api.exception.ResponseCode;
import com.appointment.api.helper.Helper;
import com.appointment.api.security.SystemAuthenticationException;
import io.jsonwebtoken.*;
import org.apache.commons.lang3.time.DateUtils;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

@Service
public class JwtService {
    private static final String AUTHORIZATION = "Authorization";

    private static final String AUTH_TAG = "Bearer ";

    private final JwtConfig jwtConfig;

    private final String encodedSecret;

    public JwtService(JwtConfig jwtConfig) {
        this.jwtConfig = jwtConfig;
        this.encodedSecret = Base64.getEncoder().encodeToString(jwtConfig.getSecretKey().getBytes());
    }

    public String jwtExtractor(HttpServletRequest request) {
        String authorization = request.getHeader(AUTHORIZATION);
        if (StringUtils.isEmpty(authorization) || !authorization.startsWith(AUTH_TAG)) {
            throw new SystemAuthenticationException("Authorization key missing", ResponseCode.AUTHORIZATION_KEY_MISSING);
        }

        String bearer = authorization.replace(AUTH_TAG, "");
        if (StringUtils.isEmpty(bearer)) {
            throw new SystemAuthenticationException("Bearer missing", ResponseCode.BEARER_MISSING);
        }
        return bearer;
    }

    public String jwtTokenGenerator(User user) {
        Map<String, Object> claims = new HashMap<>();
        claims.put("userId", user.getId());
        claims.put("roles", AuthorityUtils.createAuthorityList(user.getRole()));
        claims.put("name", String.format("%s", user.getEmail()));
        claims.put("ip", String.format("%s", Helper.getIpAddress()));
        return Jwts.builder()
                .setClaims(claims)
                .setExpiration(DateUtils.addMinutes(new Date(), jwtConfig.getExpiration()))
                .signWith(SignatureAlgorithm.HS512, encodedSecret)
                .compact();
    }

    public UUID getUserIdFromJwt(String token) {
        try {
            Jws<Claims> claimsJws = Jwts.parser().setSigningKey(encodedSecret).parseClaimsJws(token);
            Claims claims = claimsJws.getBody();
            String userId = (String) claims.get("userId");
            return UUID.fromString(userId);
        } catch (ExpiredJwtException jwtException) {
            throw new SystemAuthenticationException(String.format("Token Expired. Token : %s", token), ResponseCode.TOKEN_EXPIRED);
        } catch (Exception e) {
            throw new InsufficientAuthenticationException(String.format("UserId missing. Token : %s", token));
        }
    }

    public boolean checkIp(String token) {
        try {
            Jws<Claims> claimsJws = Jwts.parser().setSigningKey(encodedSecret).parseClaimsJws(token);
            Claims claims = claimsJws.getBody();
            String ip = (String) claims.get("ip");
            return !ip.equals(Helper.getIpAddress());
        } catch (Exception e) {
            return true;
        }
    }
}

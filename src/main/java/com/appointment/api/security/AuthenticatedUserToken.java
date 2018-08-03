package com.appointment.api.security;

import com.appointment.api.domain.user.User;
import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

public class AuthenticatedUserToken extends AbstractAuthenticationToken {

    private String token;

    private User user;

    public AuthenticatedUserToken(String token, User user, Collection<? extends GrantedAuthority> authorities) {
        super(authorities);
        super.setAuthenticated(true);
        this.token = token;
        this.user = user;
    }

    @Override
    public Object getCredentials() {
        return this.user.getId();
    }

    @Override
    public Object getPrincipal() {
        return this.user;
    }

    public String getToken() {
        return token;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}

package com.appointment.api.handler.user;

import com.appointment.api.component.AuthUser;
import com.appointment.api.domain.user.User;
import com.appointment.api.exception.ResponseCode;
import com.appointment.api.handler.Handler;
import com.appointment.api.message.request.user.UserCreateRequest;
import com.appointment.api.message.response.user.UserCreateResponse;
import com.appointment.api.service.user.UserService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class UserCreateHandler implements Handler<UserCreateRequest, UserCreateResponse> {
    private final UserService userService;
    private final PasswordEncoder passwordEncoder;
    private final AuthUser authUser;

    public UserCreateHandler(UserService userService, AuthUser authUser) {
        this.userService = userService;
        this.authUser = authUser;
        this.passwordEncoder = new BCryptPasswordEncoder();
    }

    @Override
    public UserCreateResponse execute(UserCreateRequest request) {
        User user = new User();
        user.setEmail(request.getEmail());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setFirstName(request.getFirstName());
        user.setLastName(request.getLastName());
        user.setRole(request.getRole());
        user.setCreatedUserId(authUser.getUserId());
        userService.add(user);

        return UserCreateResponse
                .builder()
                .responseCode(ResponseCode.SUCCESS)
                .build();
    }
}

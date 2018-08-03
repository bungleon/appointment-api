package com.appointment.api.handler.user;

import com.appointment.api.component.AuthUser;
import com.appointment.api.domain.user.User;
import com.appointment.api.exception.ResponseCode;
import com.appointment.api.handler.Handler;
import com.appointment.api.message.request.user.UserUpdateRequest;
import com.appointment.api.message.response.user.UserUpdateResponse;
import com.appointment.api.service.user.UserService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class UserUpdateHandler implements Handler<UserUpdateRequest, UserUpdateResponse> {
    private final UserService userService;
    private final PasswordEncoder passwordEncoder;
    private final AuthUser authUser;

    public UserUpdateHandler(UserService userService, AuthUser authUser) {
        this.userService = userService;
        this.authUser = authUser;
        this.passwordEncoder = new BCryptPasswordEncoder();
    }

    @Override
    public UserUpdateResponse execute(UserUpdateRequest request) {
        User user = userService.getUserById(request.getId());
        user.setEmail(request.getEmail());
        user.setCreatedUserId(authUser.getUserId());
        if (request.getPassword() != null) {
            user.setPassword(passwordEncoder.encode(request.getPassword()));
        }
        user.setFirstName(request.getFirstName());
        user.setLastName(request.getLastName());
        user.setRole(request.getRole());
        userService.update(user);

        return UserUpdateResponse.builder()
                .responseCode(ResponseCode.SUCCESS)
                .build();
    }
}

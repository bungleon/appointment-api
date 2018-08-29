package com.appointment.api.handler.user;

import com.appointment.api.domain.user.User;
import com.appointment.api.exception.ResponseCode;
import com.appointment.api.handler.Handler;
import com.appointment.api.message.request.user.UserDeleteRequest;
import com.appointment.api.message.response.user.UserDeleteResponse;
import com.appointment.api.service.user.UserService;
import org.springframework.stereotype.Component;

@Component
public class UserDeleteHandler implements Handler<UserDeleteRequest, UserDeleteResponse> {
    private final UserService userService;

    public UserDeleteHandler(UserService userService) {
        this.userService = userService;
    }

    @Override
    public UserDeleteResponse execute(UserDeleteRequest request) {
        User user = userService.getUserById(request.getId());
        user.markAsDeleted();
        userService.update(user);

        return UserDeleteResponse.builder()
                .responseCode(ResponseCode.SUCCESS)
                .build();
    }
}

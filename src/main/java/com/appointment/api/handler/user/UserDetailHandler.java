package com.appointment.api.handler.user;

import com.appointment.api.exception.ResponseCode;
import com.appointment.api.handler.Handler;
import com.appointment.api.message.dto.UserDto;
import com.appointment.api.message.request.user.UserDetailRequest;
import com.appointment.api.message.response.user.UserDetailResponse;
import com.appointment.api.service.user.UserService;
import org.springframework.stereotype.Component;

@Component
public class UserDetailHandler implements Handler<UserDetailRequest, UserDetailResponse> {
    private final UserService userService;

    public UserDetailHandler(UserService userService) {
        this.userService = userService;
    }

    @Override
    public UserDetailResponse execute(UserDetailRequest request) {
        UserDto userDto = new UserDto(userService.getUserById(request.getId()));

        return UserDetailResponse.builder()
                .responseCode(ResponseCode.SUCCESS)
                .user(userDto)
                .build();
    }
}

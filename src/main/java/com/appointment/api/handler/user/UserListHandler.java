package com.appointment.api.handler.user;

import com.appointment.api.exception.ResponseCode;
import com.appointment.api.handler.Handler;
import com.appointment.api.message.dto.UserDto;
import com.appointment.api.message.request.user.UserListRequest;
import com.appointment.api.message.response.user.UserListResponse;
import com.appointment.api.service.user.UserService;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class UserListHandler implements Handler<UserListRequest, UserListResponse> {
    private final UserService userService;

    public UserListHandler(UserService userService) {
        this.userService = userService;
    }

    @Override
    public UserListResponse execute(UserListRequest request) {
        List<UserDto> userList = userService.getUserList().stream()
                .map(UserDto::new)
                .collect(Collectors.toList());

        return UserListResponse.builder()
                .responseCode(ResponseCode.SUCCESS)
                .users(userList)
                .build();
    }
}

package com.appointment.api.controller;

import com.appointment.api.component.AuthUser;
import com.appointment.api.domain.user.User;
import com.appointment.api.handler.user.UserCreateHandler;
import com.appointment.api.handler.user.UserDetailHandler;
import com.appointment.api.handler.user.UserListHandler;
import com.appointment.api.handler.user.UserUpdateHandler;
import com.appointment.api.message.request.user.UserCreateRequest;
import com.appointment.api.message.request.user.UserDetailRequest;
import com.appointment.api.message.request.user.UserListRequest;
import com.appointment.api.message.request.user.UserUpdateRequest;
import com.appointment.api.message.response.user.UserCreateResponse;
import com.appointment.api.message.response.user.UserDetailResponse;
import com.appointment.api.message.response.user.UserListResponse;
import com.appointment.api.message.response.user.UserUpdateResponse;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user")
public class UserController {
    private final UserCreateHandler userCreateHandler;
    private final UserUpdateHandler userUpdateHandler;
    private final UserListHandler userListHandler;
    private final UserDetailHandler userDetailHandler;
    private final AuthUser authUser;

    public UserController(UserCreateHandler userCreateHandler, UserUpdateHandler userUpdateHandler, UserListHandler userListHandler, UserDetailHandler userDetailHandler, AuthUser authUser) {
        this.userCreateHandler = userCreateHandler;
        this.userUpdateHandler = userUpdateHandler;
        this.userListHandler = userListHandler;
        this.userDetailHandler = userDetailHandler;
        this.authUser = authUser;
    }

    @PostMapping("/create")
    public UserCreateResponse userCreate(@RequestBody UserCreateRequest request) {
        return userCreateHandler.execute(request);
    }

    @PostMapping("/update")
    public UserUpdateResponse userUpdate(@RequestBody UserUpdateRequest request) {
        return userUpdateHandler.execute(request);
    }

    @PostMapping("/list")
    public UserListResponse userList(@RequestBody UserListRequest request) {
        return userListHandler.execute(request);
    }

    @PostMapping("/detail")
    public UserDetailResponse userDetail(@RequestBody UserDetailRequest request) {
        return userDetailHandler.execute(request);
    }

    @PostMapping("/token")
    public User fafafa() {
        return authUser.getUser();
    }
}

package com.appointment.api.message.response.user;

import com.appointment.api.exception.ResponseCode;
import com.appointment.api.message.dto.UserDto;
import com.appointment.api.message.response.BaseResponse;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class UserListResponse extends BaseResponse {
    List<UserDto> users;

    @Builder
    public UserListResponse(ResponseCode responseCode, List<UserDto> users) {
        super(responseCode);
        this.users = users;
    }
}

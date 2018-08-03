package com.appointment.api.message.response.user;

import com.appointment.api.exception.ResponseCode;
import com.appointment.api.message.dto.UserDto;
import com.appointment.api.message.response.BaseResponse;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDetailResponse extends BaseResponse {
    UserDto user;

    @Builder
    public UserDetailResponse(ResponseCode responseCode, UserDto user) {
        super(responseCode);
        this.user = user;
    }
}

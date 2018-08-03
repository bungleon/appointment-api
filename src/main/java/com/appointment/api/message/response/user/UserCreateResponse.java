package com.appointment.api.message.response.user;

import com.appointment.api.exception.ResponseCode;
import com.appointment.api.message.response.BaseResponse;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserCreateResponse extends BaseResponse {
    @Builder
    public UserCreateResponse(ResponseCode responseCode) {
        super(responseCode);
    }
}

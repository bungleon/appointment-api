package com.appointment.api.message.response.user;

import com.appointment.api.exception.ResponseCode;
import com.appointment.api.message.response.BaseResponse;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDeleteResponse extends BaseResponse {
    @Builder
    public UserDeleteResponse(ResponseCode responseCode) {
        super(responseCode);
    }
}

package com.appointment.api.message.response.appointment;

import com.appointment.api.exception.ResponseCode;
import com.appointment.api.message.response.BaseResponse;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AppointeeResponse extends BaseResponse {
    @Builder
    public AppointeeResponse(ResponseCode responseCode) {
        super(responseCode);
    }
}

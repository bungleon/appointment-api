package com.appointment.api.message.response.error;

import com.appointment.api.exception.ResponseCode;
import com.appointment.api.message.response.BaseResponse;
import lombok.Builder;

public class ErrorResponse extends BaseResponse {

    @Builder
    public ErrorResponse(ResponseCode responseCode) {
        super(responseCode);
    }
}

package com.appointment.api.message.response.feedback;

import com.appointment.api.exception.ResponseCode;
import com.appointment.api.message.response.BaseResponse;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FeedBackCreateResponse extends BaseResponse {
    @Builder
    public FeedBackCreateResponse(ResponseCode responseCode) {
        super(responseCode);
    }
}

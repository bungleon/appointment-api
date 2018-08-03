package com.appointment.api.message.response.feedback;

import com.appointment.api.exception.ResponseCode;
import com.appointment.api.message.response.BaseResponse;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FeedBackConfirmationResponse extends BaseResponse {
    @Builder
    public FeedBackConfirmationResponse(ResponseCode responseCode) {
        super(responseCode);
    }
}

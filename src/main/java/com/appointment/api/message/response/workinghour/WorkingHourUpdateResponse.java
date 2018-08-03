package com.appointment.api.message.response.workinghour;

import com.appointment.api.exception.ResponseCode;
import com.appointment.api.message.response.BaseResponse;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class WorkingHourUpdateResponse extends BaseResponse {
    @Builder
    public WorkingHourUpdateResponse(ResponseCode responseCode) {
        super(responseCode);
    }
}

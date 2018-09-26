package com.appointment.api.message.response.province;

import com.appointment.api.exception.ResponseCode;
import com.appointment.api.message.response.BaseResponse;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProvinceUpdateResponse extends BaseResponse {
    @Builder
    public ProvinceUpdateResponse(ResponseCode responseCode) {
        super(responseCode);
    }
}

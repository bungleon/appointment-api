package com.appointment.api.message.response.merchant;

import com.appointment.api.exception.ResponseCode;
import com.appointment.api.message.response.BaseResponse;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SetMerchantHolidayResponse extends BaseResponse {
    @Builder
    public SetMerchantHolidayResponse(ResponseCode responseCode) {
        super(responseCode);
    }
}

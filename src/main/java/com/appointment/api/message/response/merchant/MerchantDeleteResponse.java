package com.appointment.api.message.response.merchant;

import com.appointment.api.exception.ResponseCode;
import com.appointment.api.message.response.BaseResponse;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class MerchantDeleteResponse extends BaseResponse {
    @Builder
    public MerchantDeleteResponse(ResponseCode responseCode) {
        super(responseCode);
    }
}

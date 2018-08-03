package com.appointment.api.message.response.merchant;

import com.appointment.api.exception.ResponseCode;
import com.appointment.api.message.dto.MerchantDto;
import com.appointment.api.message.response.BaseResponse;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class MerchantListResponse extends BaseResponse {
    List<MerchantDto> merchantList;

    @Builder
    public MerchantListResponse(ResponseCode responseCode, List<MerchantDto> merchantList) {
        super(responseCode);
        this.merchantList = merchantList;
    }

}

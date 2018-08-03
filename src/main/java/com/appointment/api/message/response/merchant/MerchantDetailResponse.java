package com.appointment.api.message.response.merchant;


import com.appointment.api.exception.ResponseCode;
import com.appointment.api.message.dto.HolidayDto;
import com.appointment.api.message.dto.MerchantDto;
import com.appointment.api.message.response.BaseResponse;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class MerchantDetailResponse extends BaseResponse {
    private MerchantDto merchant;
    private List<HolidayDto> holidays;

    @Builder
    public MerchantDetailResponse(ResponseCode responseCode, MerchantDto merchant, List<HolidayDto> holidays) {
        super(responseCode);
        this.merchant = merchant;
        this.holidays = holidays;
    }
}

package com.appointment.api.handler.merchant;

import com.appointment.api.exception.ResponseCode;
import com.appointment.api.handler.Handler;
import com.appointment.api.helper.Helper;
import com.appointment.api.message.request.merchant.SetMerchantHolidayRequest;
import com.appointment.api.message.response.merchant.SetMerchantHolidayResponse;
import com.appointment.api.service.merchant.MerchantService;
import org.springframework.stereotype.Component;

@Component
public class SetMerchantHoliday implements Handler<SetMerchantHolidayRequest, SetMerchantHolidayResponse> {
    private final MerchantService merchantService;

    public SetMerchantHoliday(MerchantService merchantService) {
        this.merchantService = merchantService;
    }

    @Override
    public SetMerchantHolidayResponse execute(SetMerchantHolidayRequest request) {
        merchantService.setHoliday(request.getDay(), request.getApiKey(),
                request.getDate() == null ? null : Helper.getToday(request.getDate()));

        return SetMerchantHolidayResponse.builder()
                .responseCode(ResponseCode.SUCCESS)
                .build();
    }
}

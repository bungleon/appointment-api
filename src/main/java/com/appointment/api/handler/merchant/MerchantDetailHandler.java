package com.appointment.api.handler.merchant;

import com.appointment.api.exception.ResponseCode;
import com.appointment.api.handler.Handler;
import com.appointment.api.message.dto.HolidayDto;
import com.appointment.api.message.dto.MerchantDto;
import com.appointment.api.message.request.merchant.MerchantDetailRequest;
import com.appointment.api.message.response.merchant.MerchantDetailResponse;
import com.appointment.api.service.merchant.MerchantService;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class MerchantDetailHandler implements Handler<MerchantDetailRequest, MerchantDetailResponse> {
    private final MerchantService merchantService;

    public MerchantDetailHandler(MerchantService merchantService) {
        this.merchantService = merchantService;
    }

    @Override
    public MerchantDetailResponse execute(MerchantDetailRequest request) {
        MerchantDto merchant = new MerchantDto(merchantService.getById(request.getId()));
        List<HolidayDto> holidays = merchantService.getHolidays(merchant.getId()).stream().map(HolidayDto::new)
                .collect(Collectors.toList());

        return MerchantDetailResponse.builder()
                .responseCode(ResponseCode.SUCCESS)
                .merchant(merchant)
                .holidays(holidays)
                .build();
    }
}

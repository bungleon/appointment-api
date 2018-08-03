package com.appointment.api.handler.merchant;

import com.appointment.api.exception.ResponseCode;
import com.appointment.api.handler.Handler;
import com.appointment.api.message.dto.MerchantDto;
import com.appointment.api.message.request.merchant.MerchantListRequest;
import com.appointment.api.message.response.merchant.MerchantListResponse;
import com.appointment.api.service.merchant.MerchantService;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class MerchantListHandler implements Handler<MerchantListRequest, MerchantListResponse> {
    private final MerchantService merchantService;

    public MerchantListHandler(MerchantService merchantService) {
        this.merchantService = merchantService;
    }

    @Override
    public MerchantListResponse execute(MerchantListRequest request) {
        List<MerchantDto> merchantList = merchantService.getMerchantList().stream()
                .map(MerchantDto::new)
                .collect(Collectors.toList());

        return MerchantListResponse.builder()
                .responseCode(ResponseCode.SUCCESS)
                .merchantList(merchantList)
                .build();
    }
}

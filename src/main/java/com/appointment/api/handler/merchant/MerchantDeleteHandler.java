package com.appointment.api.handler.merchant;

import com.appointment.api.domain.merchant.Merchant;
import com.appointment.api.exception.ResponseCode;
import com.appointment.api.handler.Handler;
import com.appointment.api.message.request.merchant.MerchantDeleteRequest;
import com.appointment.api.message.response.merchant.MerchantDeleteResponse;
import com.appointment.api.service.merchant.MerchantService;
import org.springframework.stereotype.Component;

@Component
public class MerchantDeleteHandler implements Handler<MerchantDeleteRequest, MerchantDeleteResponse> {
    private final MerchantService merchantService;

    public MerchantDeleteHandler(MerchantService merchantService) {
        this.merchantService = merchantService;
    }

    @Override
    public MerchantDeleteResponse execute(MerchantDeleteRequest request) {
        Merchant merchant = merchantService.getById(request.getId());
        merchant.markAsDeleted();
        merchantService.update(merchant);

        return MerchantDeleteResponse.builder()
                .responseCode(ResponseCode.SUCCESS)
                .build();
    }
}

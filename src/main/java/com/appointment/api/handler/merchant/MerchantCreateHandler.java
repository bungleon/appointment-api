package com.appointment.api.handler.merchant;

import com.appointment.api.component.AuthUser;
import com.appointment.api.domain.merchant.Merchant;
import com.appointment.api.exception.ResponseCode;
import com.appointment.api.handler.Handler;
import com.appointment.api.message.request.merchant.MerchantCreateRequest;
import com.appointment.api.message.response.merchant.MerchantCreateResponse;
import com.appointment.api.service.merchant.MerchantService;
import org.springframework.stereotype.Component;

@Component
public class MerchantCreateHandler implements Handler<MerchantCreateRequest, MerchantCreateResponse> {
    private final MerchantService merchantService;
    private final AuthUser authUser;

    public MerchantCreateHandler(MerchantService merchantService, AuthUser authUser) {
        this.merchantService = merchantService;
        this.authUser = authUser;
    }

    @Override
    public MerchantCreateResponse execute(MerchantCreateRequest request) {
        Merchant merchant = new Merchant();
        merchant.setApiKey(request.getApiKey());
        merchant.setSecretKey(request.getSecretKey());
        merchant.setName(request.getName());
        merchant.setEnabled(request.getEnabled());
        merchant.setUser(authUser.getUser());
        merchant.setWorkingRange(request.getWorkingRange());
        merchantService.add(merchant);

        return MerchantCreateResponse.builder()
                .responseCode(ResponseCode.SUCCESS)
                .build();
    }
}

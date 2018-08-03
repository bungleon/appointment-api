package com.appointment.api.handler.merchant;

import com.appointment.api.component.AuthUser;
import com.appointment.api.domain.merchant.Merchant;
import com.appointment.api.exception.ResponseCode;
import com.appointment.api.handler.Handler;
import com.appointment.api.message.request.merchant.MerchantUpdateRequest;
import com.appointment.api.message.response.merchant.MerchantUpdateResponse;
import com.appointment.api.service.merchant.MerchantService;
import org.springframework.stereotype.Component;

@Component
public class MerchantUpdateHandler implements Handler<MerchantUpdateRequest, MerchantUpdateResponse> {
    private final MerchantService merchantService;
    private final AuthUser authUser;

    public MerchantUpdateHandler(MerchantService merchantService, AuthUser authUser) {
        this.merchantService = merchantService;
        this.authUser = authUser;
    }

    @Override
    public MerchantUpdateResponse execute(MerchantUpdateRequest request) {
        Merchant merchant = merchantService.getById(request.getId());
        merchant.setApiKey(request.getApiKey());
        merchant.setSecretKey(request.getSecretKey());
        merchant.setName(request.getName());
        merchant.setEnabled(request.getEnabled());
        merchant.setWorkingRange(request.getWorkingRange());
        merchant.setUser(authUser.getUser());
        merchantService.update(merchant);

        return MerchantUpdateResponse.builder()
                .responseCode(ResponseCode.SUCCESS)
                .build();
    }
}

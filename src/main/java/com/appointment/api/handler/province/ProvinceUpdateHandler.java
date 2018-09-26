package com.appointment.api.handler.province;

import com.appointment.api.domain.province.Province;
import com.appointment.api.exception.ResponseCode;
import com.appointment.api.handler.Handler;
import com.appointment.api.message.request.province.ProvinceUpdateRequest;
import com.appointment.api.message.response.province.ProvinceUpdateResponse;
import com.appointment.api.service.province.ProvinceService;
import org.springframework.stereotype.Component;

@Component
public class ProvinceUpdateHandler implements Handler<ProvinceUpdateRequest, ProvinceUpdateResponse> {
    private final ProvinceService provinceService;

    public ProvinceUpdateHandler(ProvinceService provinceService) {
        this.provinceService = provinceService;
    }

    @Override
    public ProvinceUpdateResponse execute(ProvinceUpdateRequest request) {
        Province province = provinceService.getById(request.getId());
        province.setCode(request.getCode());
        province.setPhoneCode(request.getPhoneCode());
        province.setName(request.getName());
        provinceService.add(province);

        return ProvinceUpdateResponse.builder()
                .responseCode(ResponseCode.SUCCESS)
                .build();
    }
}

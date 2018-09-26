package com.appointment.api.controller;

import com.appointment.api.handler.province.ProvinceListHandler;
import com.appointment.api.handler.province.ProvinceUpdateHandler;
import com.appointment.api.message.request.province.ProvinceListRequest;
import com.appointment.api.message.request.province.ProvinceUpdateRequest;
import com.appointment.api.message.response.province.ProvinceListResponse;
import com.appointment.api.message.response.province.ProvinceUpdateResponse;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/province")
public class ProvinceController {
    private final ProvinceListHandler provinceListHandler;
    private final ProvinceUpdateHandler provinceUpdateHandler;

    public ProvinceController(ProvinceListHandler provinceListHandler, ProvinceUpdateHandler provinceUpdateHandler) {
        this.provinceListHandler = provinceListHandler;
        this.provinceUpdateHandler = provinceUpdateHandler;
    }

    @PostMapping("/list")
    public ProvinceListResponse getProvinceList(@RequestBody ProvinceListRequest request) {
        return provinceListHandler.execute(request);
    }

    @PostMapping("/update")
    public ProvinceUpdateResponse updateProvince(@RequestBody ProvinceUpdateRequest request) {
        return provinceUpdateHandler.execute(request);
    }
}

package com.appointment.api.controller;

import ProvinceListHandler;
import com.appointment.api.message.request.province.ProvinceListRequest;
import com.appointment.api.message.response.province.ProvinceListResponse;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/province")
public class ProvinceController {
    private final ProvinceListHandler provinceListHandler;

    public ProvinceController(ProvinceListHandler provinceListHandler) {
        this.provinceListHandler = provinceListHandler;
    }

    @PostMapping("/list")
    public ProvinceListResponse getProvinceList(@RequestBody ProvinceListRequest request) {
        return provinceListHandler.execute(request);
    }
}

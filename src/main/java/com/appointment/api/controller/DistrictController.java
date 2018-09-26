package com.appointment.api.controller;

import com.appointment.api.handler.district.DistrictListHandler;
import com.appointment.api.message.request.district.DistrictListRequest;
import com.appointment.api.message.response.district.DistrictListResponse;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/district")
public class DistrictController {
    private final DistrictListHandler districtListHandler;

    public DistrictController(DistrictListHandler districtListHandler) {
        this.districtListHandler = districtListHandler;
    }

    @PostMapping("/list")
    public DistrictListResponse getDistrictList(@RequestBody DistrictListRequest request) {
        return districtListHandler.execute(request);
    }
}

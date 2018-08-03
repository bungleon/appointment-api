package com.appointment.api.controller;

import com.appointment.api.handler.merchant.*;
import com.appointment.api.message.request.merchant.*;
import com.appointment.api.message.response.merchant.*;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/merchant")
public class MerchantController {
    private final MerchantCreateHandler merchantCreateHandler;
    private final MerchantUpdateHandler merchantUpdateHandler;
    private final MerchantListHandler merchantListHandler;
    private final MerchantDetailHandler merchantDetailHandler;
    private final SetMerchantHoliday setMerchantHoliday;

    public MerchantController(MerchantCreateHandler merchantCreateHandler, MerchantUpdateHandler merchantUpdateHandler,
                              MerchantListHandler merchantListHandler, MerchantDetailHandler merchantDetailHandler,
                              SetMerchantHoliday setMerchantHoliday) {
        this.merchantCreateHandler = merchantCreateHandler;
        this.merchantUpdateHandler = merchantUpdateHandler;
        this.merchantListHandler = merchantListHandler;
        this.merchantDetailHandler = merchantDetailHandler;
        this.setMerchantHoliday = setMerchantHoliday;
    }

    @PostMapping("/create")
    public MerchantCreateResponse create(@RequestBody MerchantCreateRequest request) {
        return merchantCreateHandler.execute(request);
    }

    @PostMapping("/update")
    public MerchantUpdateResponse update(@RequestBody MerchantUpdateRequest request) {
        return merchantUpdateHandler.execute(request);
    }

    @PostMapping("/list")
    public MerchantListResponse list(@RequestBody MerchantListRequest request) {
        return merchantListHandler.execute(request);
    }

    @PostMapping("/detail")
    public MerchantDetailResponse detail(@RequestBody MerchantDetailRequest request) {
        return merchantDetailHandler.execute(request);
    }

    @PostMapping("/set-holiday")
    public SetMerchantHolidayResponse setHoliday(@RequestBody SetMerchantHolidayRequest request) {
        return setMerchantHoliday.execute(request);
    }
}

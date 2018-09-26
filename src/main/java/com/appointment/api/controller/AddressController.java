package com.appointment.api.controller;

import com.appointment.api.handler.address.CountryListHandler;
import com.appointment.api.message.request.address.CountryListRequest;
import com.appointment.api.message.response.address.CountryListResponse;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/address")
public class AddressController {
    private final CountryListHandler countryListHandler;

    public AddressController(CountryListHandler countryListHandler) {
        this.countryListHandler = countryListHandler;
    }

    @PostMapping("/country-list")
    public CountryListResponse getCountryList(@RequestBody CountryListRequest request){
        return countryListHandler.execute(request);
    }
}

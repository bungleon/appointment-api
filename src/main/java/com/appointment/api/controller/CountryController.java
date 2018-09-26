package com.appointment.api.controller;

import com.appointment.api.handler.country.CountryListHandler;
import com.appointment.api.message.request.country.CountryListRequest;
import com.appointment.api.message.response.country.CountryListResponse;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/country")
public class CountryController {
    private final CountryListHandler countryListHandler;

    public CountryController(CountryListHandler countryListHandler) {
        this.countryListHandler = countryListHandler;
    }

    @PostMapping("/country-list")
    public CountryListResponse getCountryList(@RequestBody CountryListRequest request) {
        return countryListHandler.execute(request);
    }


}

package com.appointment.api.handler.address;

import com.appointment.api.exception.ResponseCode;
import com.appointment.api.handler.Handler;
import com.appointment.api.message.dto.CountryDto;
import com.appointment.api.message.request.address.CountryListRequest;
import com.appointment.api.message.response.address.CountryListResponse;
import com.appointment.api.service.address.CountryService;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CountryListHandler implements Handler<CountryListRequest, CountryListResponse> {
    private final CountryService countryService;

    public CountryListHandler(CountryService countryService) {
        this.countryService = countryService;
    }

    @Override
    public CountryListResponse execute(CountryListRequest request) {
        List<CountryDto> countryDtos = countryService.getCountryList().stream()
                .map(CountryDto::new)
                .collect(Collectors.toList());
        return CountryListResponse.builder()
                .responseCode(ResponseCode.SUCCESS)
                .countries(countryDtos)
                .build();
    }
}

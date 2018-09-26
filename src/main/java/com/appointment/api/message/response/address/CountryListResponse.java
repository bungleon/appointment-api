package com.appointment.api.message.response.address;


import com.appointment.api.exception.ResponseCode;
import com.appointment.api.message.dto.CountryDto;
import com.appointment.api.message.response.BaseResponse;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class CountryListResponse extends BaseResponse {
    private List<CountryDto> countries;

    @Builder
    public CountryListResponse(ResponseCode responseCode, List<CountryDto> countries) {
        super(responseCode);
        this.countries = countries;
    }
}

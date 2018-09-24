package com.appointment.api.service.address;

import com.appointment.api.domain.address.Country;

public interface CountryService {
    Country add(Country country);
    Boolean control();
}

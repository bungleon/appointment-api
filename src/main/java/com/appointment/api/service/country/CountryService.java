package com.appointment.api.service.country;

import com.appointment.api.domain.country.Country;

import java.util.List;

public interface CountryService {
    Country add(Country country);

    Country getCountryByBinaryCode(String binaryCode);

    List<Country> getCountryList();
}

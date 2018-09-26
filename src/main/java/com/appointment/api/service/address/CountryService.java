package com.appointment.api.service.address;

import com.appointment.api.domain.address.Country;

import javax.validation.constraints.Size;
import java.util.List;

public interface CountryService {
    Country add(Country country);

    Country getCountryByBinaryCode(String binaryCode);

    List<Country> getCountryList();
}

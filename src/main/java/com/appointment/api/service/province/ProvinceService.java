package com.appointment.api.service.province;

import com.appointment.api.domain.country.Country;
import com.appointment.api.domain.province.Province;

import java.util.List;
import java.util.UUID;

public interface ProvinceService {
    Province add(Province province);

    List<Province> getByCountry(Country country);

    List<Province> getByCountryId(UUID countryId);
}

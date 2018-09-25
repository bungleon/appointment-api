package com.appointment.api.service.address;

import com.appointment.api.domain.address.Country;
import com.appointment.api.domain.address.Province;

import java.util.List;

public interface ProvinceService {
    Province add(Province province);

    List<Province> getByCountry(Country country);
}

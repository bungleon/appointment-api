package com.appointment.api.service.address;

import com.appointment.api.domain.address.Town;

public interface TownService {
    Town add(Town town);
    Town getByNameAndProvinceCode(String name,String provinceCode);
}

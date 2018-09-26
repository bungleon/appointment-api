package com.appointment.api.service.town;

import com.appointment.api.domain.town.Town;

import java.util.List;
import java.util.UUID;

public interface TownService {
    Town add(Town town);
    Town getByNameAndProvinceCode(String name,String provinceCode);

    List<Town> getByProvinceId(UUID provinceId);
}

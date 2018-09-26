package com.appointment.api.service.district;

import com.appointment.api.domain.district.District;

import java.util.List;
import java.util.UUID;

public interface DistrictService {
    District add(District district);

    List<District> getByTownId(UUID townId);
}

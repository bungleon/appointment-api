package com.appointment.api.service.district;

import com.appointment.api.domain.district.District;
import com.appointment.api.domain.district.DistrictRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class DistrictServiceImpl implements DistrictService {
    private final DistrictRepository districtRepository;

    public DistrictServiceImpl(DistrictRepository districtRepository) {
        this.districtRepository = districtRepository;
    }

    @Override
    public District add(District district) {
        return districtRepository.save(district);
    }

    @Override
    public List<District> getByTownId(UUID townId) {
        return districtRepository.findAllByDeletedFalseAndTownId(townId);
    }
}

package com.appointment.api.service.town;

import com.appointment.api.domain.town.Town;
import com.appointment.api.domain.town.TownRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class TownServiceImpl implements TownService {
    private final TownRepository townRepository;

    public TownServiceImpl(TownRepository townRepository) {
        this.townRepository = townRepository;
    }

    @Override
    public Town add(Town town) {
        return townRepository.save(town);
    }

    @Override
    public Town getByNameAndProvinceCode(String name, String provinceCode) {
        return townRepository.getByNameAndProvinceCode(name, provinceCode);
    }

    @Override
    public List<Town> getByProvinceId(UUID provinceId) {
        return townRepository.findAllByDeletedFalseAndProvinceIdOrderByName(provinceId);
    }
}

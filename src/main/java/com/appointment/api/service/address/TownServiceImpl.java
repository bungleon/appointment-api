package com.appointment.api.service.address;

import com.appointment.api.domain.address.Town;
import com.appointment.api.domain.address.TownRepository;
import org.springframework.stereotype.Service;

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
}

package com.appointment.api.service.address;

import com.appointment.api.domain.address.Country;
import com.appointment.api.domain.address.Province;
import com.appointment.api.domain.address.ProvinceRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProvinceServiceImpl implements ProvinceService {
    private final ProvinceRepository provinceRepository;

    public ProvinceServiceImpl(ProvinceRepository provinceRepository) {
        this.provinceRepository = provinceRepository;
    }

    @Override
    public Province add(Province province) {
        return provinceRepository.save(province);
    }

    @Override
    public List<Province> getByCountry(Country country) {
        return provinceRepository.findAllByCountry(country);
    }


}

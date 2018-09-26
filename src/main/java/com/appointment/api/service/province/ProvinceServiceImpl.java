package com.appointment.api.service.province;

import com.appointment.api.domain.country.Country;
import com.appointment.api.domain.province.Province;
import com.appointment.api.domain.province.ProvinceRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

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
    public Province getById(UUID id) {
        return provinceRepository.findByIdAndDeletedFalse(id);
    }

    @Override
    public List<Province> getByCountry(Country country) {
        return provinceRepository.findAllByCountry(country);
    }

    @Override
    public List<Province> getByCountryId(UUID countryId) {
        return provinceRepository.findAllByDeletedFalseAndCountryId(countryId);
    }
}

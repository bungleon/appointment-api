package com.appointment.api.service.address;

import com.appointment.api.domain.address.Province;
import com.appointment.api.domain.address.ProvinceRepository;
import org.springframework.stereotype.Service;

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


}

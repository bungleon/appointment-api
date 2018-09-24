package com.appointment.api.service.address;

import com.appointment.api.domain.address.Country;
import com.appointment.api.domain.address.CountryRepository;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

@Service
public class CountryServiceImpl implements CountryService {
    private final CountryRepository countryRepository;

    public CountryServiceImpl(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    @Override
    public Country add(Country country) {
        return countryRepository.save(country);
    }

    @Override
    public Boolean control() {
        return CollectionUtils.isEmpty(countryRepository.findAll());
    }
}

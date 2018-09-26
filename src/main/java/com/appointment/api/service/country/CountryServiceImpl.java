package com.appointment.api.service.country;

import com.appointment.api.domain.country.Country;
import com.appointment.api.domain.country.CountryRepository;
import com.appointment.api.exception.domain_exception.CountryNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
    public Country getCountryByBinaryCode(String binaryCode) {
        return Optional.ofNullable(countryRepository.findByBinaryCode(binaryCode))
                .orElseThrow(CountryNotFoundException::new);
    }

    @Override
    public List<Country> getCountryList() {
        return countryRepository.findAllByDeletedFalse();
    }
}

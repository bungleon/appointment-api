package com.appointment.api.domain.province;

import com.appointment.api.domain.country.Country;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface ProvinceRepository extends JpaRepository<Province,UUID> {
    List<Province> findAllByCountry(Country country);
    List<Province> findAllByDeletedFalseAndCountryIdOrderByCodeAsc(UUID countryId);
}

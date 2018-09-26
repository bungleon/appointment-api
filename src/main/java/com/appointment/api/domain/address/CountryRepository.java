package com.appointment.api.domain.address;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface CountryRepository extends JpaRepository<Country, UUID> {
    Country findByBinaryCode(String binaryCode);

    List<Country> findAllByDeletedFalse();
}

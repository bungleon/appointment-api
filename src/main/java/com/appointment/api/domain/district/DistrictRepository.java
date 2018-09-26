package com.appointment.api.domain.district;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface DistrictRepository extends JpaRepository<District, UUID> {
    List<District> findAllByDeletedFalseAndTownId(UUID townId);
}

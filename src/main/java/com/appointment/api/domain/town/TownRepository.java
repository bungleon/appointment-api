package com.appointment.api.domain.town;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface TownRepository extends JpaRepository<Town, UUID> {
    Town getByNameAndProvinceCode(String name, String code);
    List<Town> findAllByDeletedFalseAndProvinceIdOrderByName(UUID provinceId);
}

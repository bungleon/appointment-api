package com.appointment.api.domain.address;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface TownRepository extends JpaRepository<Town, UUID> {
}

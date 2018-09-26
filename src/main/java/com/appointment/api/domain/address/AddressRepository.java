package com.appointment.api.domain.address;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface AddressRepository extends JpaRepository<Address, UUID> {
    Address findByNeighborhoodAndZipCode(String address,String code);
}

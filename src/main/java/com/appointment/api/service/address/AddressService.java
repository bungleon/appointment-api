package com.appointment.api.service.address;

import com.appointment.api.domain.address.Address;

import java.util.UUID;

public interface AddressService {
    Address add(Address address);

    Address getByNameAndZipCode(String name, String zipCode);
}

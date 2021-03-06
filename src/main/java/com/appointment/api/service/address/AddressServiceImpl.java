package com.appointment.api.service.address;

import com.appointment.api.domain.address.Address;
import com.appointment.api.domain.address.AddressRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class AddressServiceImpl implements AddressService {
    private final AddressRepository addressRepository;

    public AddressServiceImpl(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    @Override
    public Address add(Address address) {
        return addressRepository.save(address);
    }

    @Override
    public Address getByNameAndZipCode(String name, String zipCode) {
        return addressRepository.findByNeighborhoodAndZipCode(name, zipCode);
    }

    @Override
    public List<Address> getByDistrictId(UUID districtId) {
        return addressRepository.findAllByDeletedFalseAndDistrictId(districtId);
    }
}

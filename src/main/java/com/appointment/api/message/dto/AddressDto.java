package com.appointment.api.message.dto;

import com.appointment.api.domain.address.Address;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class AddressDto {
    private UUID id;
    private String address;

    public AddressDto(Address address) {
        this.id = address.getId();
        this.address = address.getNeighborhood();
    }
}

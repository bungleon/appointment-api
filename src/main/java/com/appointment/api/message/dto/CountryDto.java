package com.appointment.api.message.dto;

import com.appointment.api.domain.address.Country;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class CountryDto {
    private UUID id;
    private String binaryCode;
    private String name;

    public CountryDto(Country country) {
        this.id = country.getId();
        this.binaryCode = country.getBinaryCode();
        this.name = country.getName();
    }
}

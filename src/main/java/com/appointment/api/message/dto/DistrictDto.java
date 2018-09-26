package com.appointment.api.message.dto;

import com.appointment.api.domain.district.District;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class DistrictDto {
    private UUID id;
    private String name;

    public DistrictDto(District district) {
        this.id = district.getId();
        this.name = district.getName();
    }
}

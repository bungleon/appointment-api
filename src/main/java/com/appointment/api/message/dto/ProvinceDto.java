package com.appointment.api.message.dto;

import com.appointment.api.domain.province.Province;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class ProvinceDto {
    private UUID id;
    private String name;
    private String plateNumber;

    public ProvinceDto(Province province) {
        this.id = province.getId();
        this.name = province.getName();
        this.plateNumber = province.getCode();
    }
}

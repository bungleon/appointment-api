package com.appointment.api.message.dto;

import com.appointment.api.domain.town.Town;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class TownDto {
    private UUID id;
    private String name;

    public TownDto(Town town) {
        this.id = town.getId();
        this.name = town.getName();
    }
}

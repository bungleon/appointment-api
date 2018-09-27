package com.appointment.api.domain.district;

import com.appointment.api.domain.BaseEntity;
import com.appointment.api.domain.town.Town;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Getter
@Setter
@ToString
@Table(name = "district")
public class District extends BaseEntity {
    private String name;

    @Column(name = "original_name")
    private String originalName;

    private String code;

    private String latitude;

    private String longitude;

    @ManyToOne
    @JoinColumn(name = "town_id")
    private Town town;
}

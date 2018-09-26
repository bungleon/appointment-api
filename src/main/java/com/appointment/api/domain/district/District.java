package com.appointment.api.domain.district;

import com.appointment.api.domain.BaseEntity;
import com.appointment.api.domain.town.Town;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Getter
@Setter
@ToString
@Table(name = "district")
public class District extends BaseEntity {
    private String name;

    private String code;

    @ManyToOne
    @JoinColumn(name = "town_id")
    private Town town;
}

package com.appointment.api.domain.address;

import com.appointment.api.domain.BaseEntity;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Getter
@Setter
@ToString
@Table(name = "address")
public class Address extends BaseEntity {
    private String neighborhood;

    private String completeAddress;

    private Integer zipCode;

    @ManyToOne
    @JoinColumn(name = "district_id", nullable = false)
    private District district;
}

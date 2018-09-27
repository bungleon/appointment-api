package com.appointment.api.domain.address;

import com.appointment.api.domain.BaseEntity;
import com.appointment.api.domain.district.District;
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

    private String code;

    @Column(name = "zip_code")
    private String zipCode;

    @Column(name = "original_name")
    private String originalName;

    private String latitude;

    private String longitude;

    @ManyToOne
    @JoinColumn(name = "district_id")
    private District district;
}

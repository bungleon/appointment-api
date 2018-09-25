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
@Table(name = "province")
public class Province extends BaseEntity {
    private String name;
    private String code;
    @Column(name = "phone_code")
    private String phoneCode;

    @ManyToOne
    @JoinColumn(name = "country_id")
    private Country country;
}

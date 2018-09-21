package com.appointment.api.domain.address;

import com.appointment.api.domain.BaseEntity;
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
@Table(name = "province")
public class Province extends BaseEntity {
    private String name;
    private String code;

    @ManyToOne
    @JoinColumn(name = "country_id", nullable = false)
    private Country country;
}

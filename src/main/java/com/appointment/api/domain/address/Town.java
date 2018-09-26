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
@Table(name = "town")
public class Town extends BaseEntity {
    @Column(name = "name")
    private String name;

    private String code;

    @ManyToOne
    @JoinColumn(name = "province_id")
    private Province province;
}

package com.appointment.api.domain.country;

import com.appointment.api.domain.BaseEntity;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Index;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@ToString
@Table(name = "country", indexes = {
        @Index(name = "name_idx", columnList = "name"),
        @Index(name = "binary_code_idx", columnList = "binary_code"),
        @Index(name = "triple_code_idx", columnList = "triple_code"),
        @Index(name = "phone_code_idx", columnList = "phone_code")
})
public class Country extends BaseEntity {
    @Column(name = "name")
    private String name;

    @Column(name = "binary_code")
    private String binaryCode;

    @Column(name = "triple_code")
    private String tripleCode;

    @Column(name = "phone_code")
    private String phoneCode;

    private String latitude;

    private String longitude;
}

package com.appointment.api.domain.merchant;

import com.appointment.api.domain.BaseEntity;
import com.appointment.api.domain.user.User;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.List;

@Entity
@Table(name = "merchants", indexes = {
        @Index(name = "merchant_apikey_idx", columnList = "api_key")
}, uniqueConstraints = {
        @UniqueConstraint(columnNames = {"api_key"}),
        @UniqueConstraint(columnNames = {"secret_key"}),
        @UniqueConstraint(columnNames = {"name"})
})
@Getter
@Setter
@ToString
public class Merchant extends BaseEntity {
    @Column(name = "api_key")
    private String apiKey;

    @Column(name = "secret_key")
    private String secretKey;

    @Column(name = "name")
    private String name;

    @Column(name = "enabled")
    private boolean enabled;

    @Column(name = "working_range")
    private Integer workingRange;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

}

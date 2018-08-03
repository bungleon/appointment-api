package com.appointment.api.domain.merchant;

import com.appointment.api.domain.BaseEntity;
import com.appointment.api.domain.user.User;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.DayOfWeek;
import java.time.LocalDateTime;

@Entity
@Table(name = "holidays", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"specific_day"})
})
@Getter
@Setter
public class Holiday extends BaseEntity {
    @Enumerated(value = EnumType.STRING)
    private DayOfWeek day;

    @Column(name = "specific_day")
    private LocalDateTime specificDay;

    private Boolean enabled;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "merchant_id", nullable = false)
    private Merchant merchant;

}

package com.appointment.api.domain.workinghour;

import com.appointment.api.domain.BaseEntity;
import com.appointment.api.domain.LocalDateTimeConverter;
import com.appointment.api.domain.merchant.Merchant;
import com.appointment.api.domain.user.User;
import com.appointment.api.message.TimePeriod;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "working_hours", indexes = {
        @Index(name = "working_hours_time_period_idx", columnList = "time_period")
})
@Getter
@Setter
@ToString
public class WorkingHour extends BaseEntity {
    @Column(name = "time_period")
    @Enumerated(EnumType.STRING)
    private TimePeriod timePeriod;

    @Convert(converter = LocalDateTimeConverter.class)
    @Column(name = "start_time")
    private LocalDateTime startTime;

    @Convert(converter = LocalDateTimeConverter.class)
    @Column(name = "today")
    private LocalDateTime today;

    @Convert(converter = LocalDateTimeConverter.class)
    @Column(name = "finish_time")
    private LocalDateTime finishTime;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "merchant_id", nullable = false)
    private Merchant merchant;

}

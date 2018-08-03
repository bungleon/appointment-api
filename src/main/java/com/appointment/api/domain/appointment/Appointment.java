package com.appointment.api.domain.appointment;

import com.appointment.api.domain.BaseEntity;
import com.appointment.api.domain.user.User;
import com.appointment.api.domain.workinghour.WorkingHour;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "appointment", indexes = {
        @Index(name = "appointment_working_hour_idx", columnList = "working_hour_id"),
        @Index(name = "appointment_user_idx", columnList = "user_id")
})
@Getter
@Setter
@ToString
public class Appointment extends BaseEntity {

    @Column(name = "start_time")
    private LocalDateTime startTime;

    @Column(name = "finish_time")
    private LocalDateTime finishTime;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "working_hour_id", nullable = false)
    private WorkingHour workingHour;

    @ManyToOne
    @JoinColumn(name = "appointee")
    private User appointee;
}

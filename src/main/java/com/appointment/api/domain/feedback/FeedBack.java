package com.appointment.api.domain.feedback;

import com.appointment.api.domain.BaseEntity;
import com.appointment.api.domain.appointment.Appointment;
import com.appointment.api.domain.merchant.Merchant;
import com.appointment.api.domain.user.User;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "feed_back", indexes = {
        @Index(name = "feed_back_user_idx", columnList = "user_id"),
        @Index(name = "feed_back_appointment_idx", columnList = "appointment_id"),
})
@Getter
@Setter
public class FeedBack extends BaseEntity {
    private String header;

    private String content;

    private Boolean confirmation = false;

    private Boolean enabled = false;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "appointment_id")
    private Appointment appointment;

    @ManyToOne
    @JoinColumn(name = "merchant_id", nullable = false)
    private Merchant merchant;
}

package com.appointment.api.domain.user;

import com.appointment.api.domain.BaseEntity;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "users", indexes = {
        @Index(name = "user_email_idx", columnList = "email")
}, uniqueConstraints = {
        @UniqueConstraint(columnNames = {"email"})
})

@Getter
@Setter
@ToString
public class User extends BaseEntity {
    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "role")
    private String role;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "enabled")
    private boolean enabled = true;

    @Column(name = "created_user_id")
    private UUID createdUserId;
}

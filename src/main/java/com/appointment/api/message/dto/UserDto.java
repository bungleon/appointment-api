package com.appointment.api.message.dto;

import com.appointment.api.domain.user.User;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
public class UserDto {
    private UUID id;
    private String email;
    private String role;
    private String firstName;
    private String lastName;
    private boolean enabled;
    private UUID whoCreatedId;
    private LocalDateTime created;
    private LocalDateTime updated;

    public UserDto(User user) {
        this.id = user.getId();
        this.email = user.getEmail();
        this.role = user.getRole();
        this.firstName = user.getFirstName();
        this.lastName = user.getLastName();
        this.enabled = user.isEnabled();
        this.created = user.getCreateDate();
        this.updated = user.getUpdateDate();
        this.whoCreatedId = user.getCreatedUserId();
    }
}

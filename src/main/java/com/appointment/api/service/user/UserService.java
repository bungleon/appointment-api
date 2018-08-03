package com.appointment.api.service.user;

import com.appointment.api.domain.user.User;

import java.util.List;
import java.util.UUID;

public interface UserService {
    User getUserById(UUID userId);

    User add(User user);

    User update(User user);

    List<User> getUserList();
}

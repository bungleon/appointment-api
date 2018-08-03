package com.appointment.api.service.user;

import com.appointment.api.domain.user.User;
import com.appointment.api.domain.user.UserRepository;
import com.appointment.api.exception.domain_exception.UserNotCreatedException;
import com.appointment.api.exception.domain_exception.UserNotFoundException;
import com.appointment.api.exception.domain_exception.UserNotUpdatedException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User getUserById(UUID userId) {
        return Optional.ofNullable(userRepository.findByIdAndDeletedFalseAndEnabledTrue(userId))
                .orElseThrow(UserNotFoundException::new);
    }

    @Override
    public User add(User user) {
        return Optional.ofNullable(userRepository.save(user))
                .orElseThrow(UserNotCreatedException::new);
    }

    @Override
    public User update(User user) {
        return Optional.ofNullable(userRepository.save(user))
                .orElseThrow(UserNotUpdatedException::new);
    }

    @Override
    public List<User> getUserList() {
        return Optional.ofNullable(userRepository.findAllByDeletedFalse())
                .orElseThrow(UserNotFoundException::new);
    }
}

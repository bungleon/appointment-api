package com.appointment.api.domain.user;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {
     User findByIdAndDeletedFalseAndEnabledTrue(UUID id);
     List<User> findAllByDeletedFalse();
     User findByEmail(String email);
}

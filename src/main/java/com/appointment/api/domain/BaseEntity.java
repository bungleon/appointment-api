package com.appointment.api.domain;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;

@MappedSuperclass
@Getter
public abstract class BaseEntity {
    @Id
    @GenericGenerator(name = "uuid-gen", strategy = "uuid2")
    @GeneratedValue(generator = "uuid-gen")
    @org.hibernate.annotations.Type(type = "pg-uuid")
    @Column(nullable = false, updatable = false)
    private UUID id;

    @Convert(converter = LocalDateTimeConverter.class)
    @Column(updatable = false, nullable = false, name = "created_at")
    private LocalDateTime createDate = LocalDateTime.now();

    @Convert(converter = LocalDateTimeConverter.class)
    @Column(name = "updated_at")
    private LocalDateTime updateDate;

    @Column(nullable = false)
    private Boolean deleted = false;

    @PrePersist
    private void onPersist() {
        createDate = LocalDateTime.now();
    }

    @PreUpdate
    private void onUpdate() {
        updateDate = LocalDateTime.now();
    }

    public void markAsDeleted() {
        this.deleted = true;
    }
}

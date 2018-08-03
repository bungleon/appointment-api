package com.appointment.api.exception;

import lombok.Getter;

@Getter
public enum ResponseCode {
    SUCCESS(100, "Success"),
    USER_NOT_CREATED(301, "User not created"),
    USER_NOT_UPDATED(302, "User not updated"),
    USER_NOT_FOUND(303, "User not found"),
    MERCHANT_NOT_CREATED(304, "Merchant not created"),
    MERCHANT_NOT_UPDATED(305, "Merchant not updated"),
    MERCHANT_NOT_FOUND(306, "Merchant not found"),
    WORKING_HOUR_NOT_SAVED(307, "Merchant hour not saved"),
    WORKING_HOUR_NOT_FOUND(308, "Working hour not found"),
    APPOINTMENTS_ALREADY_EXIST(309, "Appointments already exist"),
    TIME_IS_NOT_VALID(310, "Time is not valid"),
    APPOINTMENT_TAKEN_BEFORE(311, "Appointment taken before"),
    FEED_BACK_CANNOT_CREATED(312, "Feed back cannot created"),
    FEED_BACK_NOT_FOUND(313, "Feed back not found"),

    INVALID_IP(991, "Invalid ip"),
    ACCESS_DENIED(992, "Access denied"),
    INVALID_CREDENTIALS(993, "Invalid credentials"),
    TOKEN_EXPIRED(994, "Token expired"),
    AUTHORITIES_NOT_FOUND(995, "Not granted any authorities"),
    AUTHORIZATION_KEY_MISSING(996, "Authorization key missing"),
    BEARER_MISSING(997, "Bearer missing"),
    INVALID_REQUEST(998, "Invalid request"),
    UNDEFINED_ERROR(999, "Undefined error");
    private Integer code;
    private String message;

    ResponseCode(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}

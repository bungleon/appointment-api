package com.appointment.api.exception.domain_exception;

import com.appointment.api.exception.DomainException;
import com.appointment.api.exception.ExceptionMessage;
import com.appointment.api.exception.ResponseCode;

@ExceptionMessage(responseCode = ResponseCode.USER_NOT_CREATED)
public class UserNotCreatedException extends DomainException {
}

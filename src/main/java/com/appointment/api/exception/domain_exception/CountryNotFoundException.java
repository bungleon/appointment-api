package com.appointment.api.exception.domain_exception;

import com.appointment.api.exception.DomainException;
import com.appointment.api.exception.ExceptionMessage;
import com.appointment.api.exception.ResponseCode;

@ExceptionMessage(responseCode = ResponseCode.COUNTRY_NOT_FOUND)
public class CountryNotFoundException extends DomainException {
}

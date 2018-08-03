package com.appointment.api.exception.domain_exception;

import com.appointment.api.exception.DomainException;
import com.appointment.api.exception.ExceptionMessage;
import com.appointment.api.exception.ResponseCode;

@ExceptionMessage(responseCode = ResponseCode.FEED_BACK_CANNOT_CREATED)
public class FeedBackCannotCreatedException extends DomainException {
}

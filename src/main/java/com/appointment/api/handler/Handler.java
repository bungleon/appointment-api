package com.appointment.api.handler;

public interface Handler<T, R> {
    R execute(T request);
}

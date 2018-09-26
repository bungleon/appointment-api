package com.appointment.api.handler;

import java.io.IOException;

public interface Handler<T, R> {
    R execute(T request);
}

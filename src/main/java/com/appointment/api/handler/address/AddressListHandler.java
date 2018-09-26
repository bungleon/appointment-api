package com.appointment.api.handler.address;

import com.appointment.api.handler.Handler;
import com.appointment.api.message.request.address.AddressListRequest;
import com.appointment.api.message.response.address.AddressListResponse;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class AddressListHandler implements Handler<AddressListRequest, AddressListResponse> {
    @Override
    public AddressListResponse execute(AddressListRequest request){
        return null;
    }
}

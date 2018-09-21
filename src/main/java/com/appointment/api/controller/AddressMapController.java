package com.appointment.api.controller;

import com.appointment.api.handler.address.AddressMapHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/address")
public class AddressMapController {
    private final AddressMapHandler addressMapHandler;

    public AddressMapController(AddressMapHandler addressMapHandler) {
        this.addressMapHandler = addressMapHandler;
    }

    @PostMapping("/fill-all")
    public String fillAll() {
        return addressMapHandler.execute("OK");
    }
}

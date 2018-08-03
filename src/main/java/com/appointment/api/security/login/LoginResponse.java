package com.appointment.api.security.login;


import com.appointment.api.exception.ResponseCode;
import com.appointment.api.message.response.BaseResponse;

public class LoginResponse extends BaseResponse {

    private String token;

    private Integer expireTime;


    public LoginResponse(ResponseCode responseCode, String token, Integer expireTime) {
        super(responseCode);
        this.token = token;
        this.expireTime = expireTime;
    }
}

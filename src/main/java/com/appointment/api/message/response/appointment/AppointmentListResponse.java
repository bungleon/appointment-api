package com.appointment.api.message.response.appointment;

import com.appointment.api.exception.ResponseCode;
import com.appointment.api.message.dto.AppointmentDto;
import com.appointment.api.message.response.BaseResponse;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class AppointmentListResponse extends BaseResponse {

    private String merchantName;
    private String apiKey;
    private List<AppointmentDto> amAppointments;
    private List<AppointmentDto> pmAppointments;

    @Builder
    public AppointmentListResponse(ResponseCode responseCode, List<AppointmentDto> amAppointments,
                                   List<AppointmentDto> pmAppointments, String merchantName, String apiKey) {
        super(responseCode);
        this.amAppointments = amAppointments;
        this.pmAppointments = pmAppointments;
        this.merchantName = merchantName;
        this.apiKey = apiKey;
    }
}

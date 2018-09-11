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
    private List<AppointmentDto> nightAppointments;
    private List<AppointmentDto> morningAppointments;
    private List<AppointmentDto> afternoonAppointments;
    private List<AppointmentDto> eveningAppointments;

    @Builder

    public AppointmentListResponse(ResponseCode responseCode, String merchantName, String apiKey,
                                   List<AppointmentDto> nightAppointments, List<AppointmentDto> morningAppointments,
                                   List<AppointmentDto> afternoonAppointments,
                                   List<AppointmentDto> eveningAppointments) {
        super(responseCode);
        this.merchantName = merchantName;
        this.apiKey = apiKey;
        this.nightAppointments = nightAppointments;
        this.morningAppointments = morningAppointments;
        this.afternoonAppointments = afternoonAppointments;
        this.eveningAppointments = eveningAppointments;
    }
}

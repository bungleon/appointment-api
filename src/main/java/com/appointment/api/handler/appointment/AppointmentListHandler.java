package com.appointment.api.handler.appointment;

import com.appointment.api.domain.appointment.Appointment;
import com.appointment.api.domain.merchant.Merchant;
import com.appointment.api.domain.workinghour.WorkingHour;
import com.appointment.api.exception.ResponseCode;
import com.appointment.api.exception.domain_exception.WorkingHourNotFoundException;
import com.appointment.api.handler.Handler;
import com.appointment.api.helper.Helper;
import com.appointment.api.message.TimePeriod;
import com.appointment.api.message.dto.AppointmentDto;
import com.appointment.api.message.request.appointment.AppointmentListRequest;
import com.appointment.api.message.response.appointment.AppointmentListResponse;
import com.appointment.api.service.appointment.AppointmentService;
import com.appointment.api.service.merchant.MerchantService;
import com.appointment.api.service.workinghour.WorkingHourService;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class AppointmentListHandler implements Handler<AppointmentListRequest, AppointmentListResponse> {
    private final MerchantService merchantService;
    private final WorkingHourService workingHourService;
    private final AppointmentService appointmentService;

    public AppointmentListHandler(MerchantService merchantService, WorkingHourService workingHourService, AppointmentService appointmentService) {
        this.merchantService = merchantService;
        this.workingHourService = workingHourService;
        this.appointmentService = appointmentService;
    }

    @Override
    public AppointmentListResponse execute(AppointmentListRequest request) {

        Merchant merchant = merchantService.getByApiKey(request.getApiKey());

        WorkingHour amWorkingHour = null;
        WorkingHour pmWorkingHour = null;

        try {
            amWorkingHour = workingHourService.getWorkingHourForSave(TimePeriod.AM, merchant.getId(),
                    Helper.getToday(request.getDate()));
        } catch (WorkingHourNotFoundException e) {
            //
        }

        try {
            pmWorkingHour = workingHourService.getWorkingHourForSave(TimePeriod.PM, merchant.getId(),
                    Helper.getToday(request.getDate()));
        } catch (WorkingHourNotFoundException e) {
            //
        }

        List<Appointment> amAppointments = null;
        List<Appointment> pmAppointments = null;

        if (amWorkingHour != null) {
            amAppointments = appointmentService.getByWorkingHours(amWorkingHour.getId());
        }
        if (pmWorkingHour != null) {
            pmAppointments = appointmentService.getByWorkingHours(pmWorkingHour.getId());
        }

        return AppointmentListResponse.builder()
                .responseCode(ResponseCode.SUCCESS)
                .merchantName(merchant.getName())
                .apiKey(merchant.getApiKey())
                .amAppointments(CollectionUtils.isEmpty(amAppointments) ? null :
                        amAppointments.stream().map(AppointmentDto::new).collect(Collectors.toList()))
                .pmAppointments(CollectionUtils.isEmpty(pmAppointments) ? null :
                        pmAppointments.stream().map(AppointmentDto::new).collect(Collectors.toList()))

                .build();
    }
}

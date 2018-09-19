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

        WorkingHour nightWorkingHour = null;
        WorkingHour morningWorkingHour = null;
        WorkingHour afternoonWorkingHour = null;
        WorkingHour eveningWorkingHour = null;

        try {
            nightWorkingHour = workingHourService.getWorkingHourForSave(TimePeriod.NIGHT, merchant.getId(),
                    Helper.getLocalDateTime(request.getDate()));
        } catch (WorkingHourNotFoundException e) {
            //
        }

        try {
            morningWorkingHour = workingHourService.getWorkingHourForSave(TimePeriod.MORNING, merchant.getId(),
                    Helper.getLocalDateTime(request.getDate()));
        } catch (WorkingHourNotFoundException e) {
            //
        }

        try {
            afternoonWorkingHour = workingHourService.getWorkingHourForSave(TimePeriod.AFTERNOON, merchant.getId(),
                    Helper.getLocalDateTime(request.getDate()));
        } catch (WorkingHourNotFoundException e) {
            //
        }

        try {
            eveningWorkingHour = workingHourService.getWorkingHourForSave(TimePeriod.EVENING, merchant.getId(),
                    Helper.getLocalDateTime(request.getDate()));
        } catch (WorkingHourNotFoundException e) {
            //
        }

        List<Appointment> nightAppointments = null;
        List<Appointment> morningAppointments = null;
        List<Appointment> afternoonAppointments = null;
        List<Appointment> eveningAppointments = null;

        if (nightWorkingHour != null) {
            nightAppointments = appointmentService.getByWorkingHours(nightWorkingHour.getId());
        }
        if (morningWorkingHour != null) {
            morningAppointments = appointmentService.getByWorkingHours(morningWorkingHour.getId());
        }
        if (afternoonWorkingHour != null) {
            afternoonAppointments = appointmentService.getByWorkingHours(afternoonWorkingHour.getId());
        }
        if (eveningWorkingHour != null) {
            eveningAppointments = appointmentService.getByWorkingHours(eveningWorkingHour.getId());
        }

        return AppointmentListResponse.builder()
                .responseCode(ResponseCode.SUCCESS)
                .merchantName(merchant.getName())
                .apiKey(merchant.getApiKey())
                .nightAppointments(CollectionUtils.isEmpty(nightAppointments) ? null :
                        nightAppointments.stream().map(AppointmentDto::new).collect(Collectors.toList()))
                .morningAppointments(CollectionUtils.isEmpty(morningAppointments) ? null :
                        morningAppointments.stream().map(AppointmentDto::new).collect(Collectors.toList()))
                .afternoonAppointments(CollectionUtils.isEmpty(afternoonAppointments) ? null :
                        afternoonAppointments.stream().map(AppointmentDto::new).collect(Collectors.toList()))
                .eveningAppointments(CollectionUtils.isEmpty(eveningAppointments) ? null :
                        eveningAppointments.stream().map(AppointmentDto::new).collect(Collectors.toList()))

                .build();
    }
}

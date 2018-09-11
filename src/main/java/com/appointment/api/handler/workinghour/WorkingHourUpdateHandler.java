package com.appointment.api.handler.workinghour;

import com.appointment.api.component.AuthUser;
import com.appointment.api.domain.merchant.Merchant;
import com.appointment.api.domain.workinghour.WorkingHour;
import com.appointment.api.exception.ResponseCode;
import com.appointment.api.exception.domain_exception.TimeException;
import com.appointment.api.exception.domain_exception.WorkingHourNotFoundException;
import com.appointment.api.handler.Handler;
import com.appointment.api.helper.Helper;
import com.appointment.api.message.TimePeriod;
import com.appointment.api.message.request.workinghour.WorkingHourUpdateRequest;
import com.appointment.api.message.response.workinghour.WorkingHourUpdateResponse;
import com.appointment.api.service.appointment.AppointmentService;
import com.appointment.api.service.merchant.MerchantService;
import com.appointment.api.service.workinghour.WorkingHourService;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class WorkingHourUpdateHandler implements Handler<WorkingHourUpdateRequest, WorkingHourUpdateResponse> {
    private final WorkingHourService workingHourService;
    private final MerchantService merchantService;
    private final AuthUser authUser;
    private final AppointmentService appointmentService;

    public WorkingHourUpdateHandler(WorkingHourService workingHourService, MerchantService merchantService, AuthUser authUser, AppointmentService appointmentService) {
        this.workingHourService = workingHourService;
        this.merchantService = merchantService;
        this.authUser = authUser;
        this.appointmentService = appointmentService;
    }

    @Override
    public WorkingHourUpdateResponse execute(WorkingHourUpdateRequest request) {
        Merchant merchant = merchantService.getByApiKey(request.getApiKey());
        LocalDateTime today = Helper.getToday(request.getDate());
        LocalDateTime startTime = Helper.getLocalDateTime(String.format("%s %s", request.getDate(), request.getStartTime()));
        LocalDateTime finishTime = Helper.getLocalDateTime(String.format("%s %s", request.getDate(), request.getFinishTime()));
        WorkingHour workingHour;

        if (today.plusDays(1).isBefore(LocalDateTime.now()) || startTime.plusMinutes(1).isAfter(finishTime)) {
            throw new TimeException();
        }

        try {
            if (TimePeriod.NIGHT.equals(request.getTimePeriod())) {
                // 00 - 06
            } else if (TimePeriod.MORNING.equals(request.getTimePeriod())) {
                // 06 - 12
            } else if (TimePeriod.AFTERNOON.equals(request.getTimePeriod())) {
                // 12 - 18
            } else if (TimePeriod.EVENING.equals(request.getTimePeriod())) {
                // 18 - 00
            }
        } catch (WorkingHourNotFoundException e) {
            //
        }


        try {
            workingHour = workingHourService.getWorkingHourForSave(request.getTimePeriod(), merchant.getId(), today);
            appointmentService.deleteAppointment(workingHour.getId());
        } catch (WorkingHourNotFoundException e) {
            workingHour = new WorkingHour();
        }


        workingHour.setMerchant(merchant);
        workingHour.setStartTime(startTime);
        workingHour.setFinishTime(finishTime);
        workingHour.setToday(today);
        workingHour.setUser(authUser.getUser());
        workingHour.setTimePeriod(request.getTimePeriod());
        WorkingHour saved = workingHourService.save(workingHour);


        appointmentService.createAppointment(merchant.getWorkingRange(), saved);
        return WorkingHourUpdateResponse.builder()
                .responseCode(ResponseCode.SUCCESS)
                .build();
    }
}

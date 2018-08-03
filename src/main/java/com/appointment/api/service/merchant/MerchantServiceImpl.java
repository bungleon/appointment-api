package com.appointment.api.service.merchant;

import com.appointment.api.component.AuthUser;
import com.appointment.api.domain.merchant.Holiday;
import com.appointment.api.domain.merchant.HolidayRepository;
import com.appointment.api.domain.merchant.Merchant;
import com.appointment.api.domain.merchant.MerchantRepository;
import com.appointment.api.exception.domain_exception.MerchantNotCreatedException;
import com.appointment.api.exception.domain_exception.MerchantNotFoundException;
import com.appointment.api.exception.domain_exception.MerchantNotUpdatedException;
import org.springframework.stereotype.Service;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class MerchantServiceImpl implements MerchantService {
    private final MerchantRepository merchantRepository;
    private final HolidayRepository holidayRepository;
    private final AuthUser authUser;

    public MerchantServiceImpl(MerchantRepository merchantRepository, HolidayRepository holidayRepository, AuthUser authUser) {
        this.merchantRepository = merchantRepository;
        this.holidayRepository = holidayRepository;
        this.authUser = authUser;
    }

    @Override
    public Merchant add(Merchant merchant) {
        return Optional.ofNullable(merchantRepository.save(merchant))
                .orElseThrow(MerchantNotCreatedException::new);
    }

    @Override
    public Merchant update(Merchant merchant) {
        return Optional.ofNullable(merchantRepository.save(merchant))
                .orElseThrow(MerchantNotUpdatedException::new);
    }

    @Override
    public Merchant getById(UUID id) {
        return Optional.ofNullable(merchantRepository.findByIdAndDeletedFalse(id))
                .orElseThrow(MerchantNotFoundException::new);
    }

    @Override
    public List<Merchant> getMerchantList() {
        return Optional.ofNullable(merchantRepository.findAllByDeletedFalseAndEnabledTrue())
                .orElseThrow(MerchantNotFoundException::new);
    }

    @Override
    public Merchant getByApiKey(String apiKey) {
        return Optional.ofNullable(merchantRepository.findByApiKey(apiKey))
                .orElseThrow(MerchantNotFoundException::new);
    }

    @Override
    public Merchant setHoliday(DayOfWeek day, String apiKey, LocalDateTime date) {
        Merchant merchant = getByApiKey(apiKey);
        Holiday holiday = new Holiday();
        if(date!=null){
            holiday.setDay(date.getDayOfWeek());
        }
        else {
            holiday.setDay(day);
        }
        holiday.setSpecificDay(date);
        holiday.setEnabled(true);
        holiday.setMerchant(merchant);
        holiday.setUser(authUser.getUser());
        holidayRepository.save(holiday);
        return update(merchant);
    }

    @Override
    public List<Holiday> getHolidays(UUID merchantId) {
        return holidayRepository.findAllByMerchantIdAndEnabledTrueAndDeletedFalse(merchantId);
    }


}

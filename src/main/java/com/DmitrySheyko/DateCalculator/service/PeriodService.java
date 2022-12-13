package com.DmitrySheyko.DateCalculator.service;

import com.DmitrySheyko.DateCalculator.dto.PeriodRequestDto;
import com.DmitrySheyko.DateCalculator.mapper.PeriodDtoMapper;
import com.DmitrySheyko.DateCalculator.model.TimePeriod;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.time.*;
import java.time.temporal.ChronoUnit;

@Service
@AllArgsConstructor
@Validated
public class PeriodService {
    private PeriodDtoMapper periodDtoMapper;

    public TimePeriod get(@Valid PeriodRequestDto requestDto) {

        Period period;
        Duration duration;
        long days = 0L;
        ZonedDateTime date1 = periodDtoMapper.toZonedDateTime(requestDto)[0];
        ZonedDateTime date2 = periodDtoMapper.toZonedDateTime(requestDto)[1];
        if (date1.isBefore(date2)) {
            period = Period.between(date1.toLocalDate(), date2.toLocalDate());
            if (date1.toLocalTime().equals(date2.toLocalTime()) || date1.toLocalTime().isBefore(date2.toLocalTime())) {
                duration = Duration.between(date1.toLocalTime(), date2.toLocalTime());
                days = ChronoUnit.DAYS.between(date1.toLocalDate(), date2.toLocalDate());
            } else {
                period = Period.between(date1.toLocalDate(), date2.toLocalDate().minusDays(1));
                duration = (Duration.parse("P1D")).minus(Duration.between(date2.toLocalTime(), date1.toLocalTime()));
                days = ChronoUnit.DAYS.between(date1.toLocalDate(), date2.toLocalDate().minusDays(1));
            }
        } else {
            period = Period.between(date2.toLocalDate(), date1.toLocalDate());
            if (date2.toLocalTime().equals(date1.toLocalTime()) || date2.toLocalTime().isBefore(date1.toLocalTime())) {
                duration = Duration.between(date2.toLocalTime(), date1.toLocalTime());
                days = ChronoUnit.DAYS.between(date2.toLocalDate(), date1.toLocalDate());
            } else {
                period = Period.between(date2.toLocalDate(), date1.toLocalDate().minusDays(1));
                duration = Duration.parse("P1D").minus(Duration.between(date1.toLocalTime(), date2.toLocalTime()));
                days = ChronoUnit.DAYS.between(date2.toLocalDate(), date1.toLocalDate().minusDays(1));
            }
        }
        return periodDtoMapper.periotToTimePeriod(period, duration, days);
    }
}

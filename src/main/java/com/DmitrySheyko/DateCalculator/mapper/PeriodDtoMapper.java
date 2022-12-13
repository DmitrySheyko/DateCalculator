package com.DmitrySheyko.DateCalculator.mapper;

import com.DmitrySheyko.DateCalculator.dto.PeriodRequestDto;
import com.DmitrySheyko.DateCalculator.model.TimePeriod;
import org.springframework.stereotype.Component;

import java.time.*;

@Component
public class PeriodDtoMapper {
    private final static int HOURS_IN_DAY = 24;
    private final static int MINUTES_IN_DAY = 24 * 60;
    private final static int SECONDS_IN_DAY = 24 * 60 * 60;


    public ZonedDateTime[] toZonedDateTime(PeriodRequestDto request) {
        ZonedDateTime date1 = ZonedDateTime.of(request.getYear1(), request.getMonth1(), request.getDay1(),
                request.getHour1(), request.getMinute1(), request.getSecond1(), 0, ZoneId.of(request.getZoneId1()));
        ZonedDateTime date2 = ZonedDateTime.of(request.getYear2(), request.getMonth2(), request.getDay2(),
                request.getHour2(), request.getMinute2(), request.getSecond2(), 0, ZoneId.of(request.getZoneId2()));
ZonedDateTime date3 = date2.withZoneSameInstant(ZoneId.of(request.getZoneId1()));

        System.out.println("Mapper1 " + date1);
        System.out.println("Mapper2 " + date2);
        System.out.println("Mapper3 " + date3);
        return new ZonedDateTime[]{date1, date3};
    }

//    public TimePeriod toTimePeriod(ZonedDateTime period) {
//        return TimePeriod.builder()
//                .years(period.getYear())
//                .months(period.getMonth().getValue())
//                .days(period.getDayOfMonth())
//                .hours(period.getHour())
//                .minutes(period.getMinute())
//                .seconds(period.getSecond())
//                .build();
//    }

    public TimePeriod periotToTimePeriod(Period period, Duration duration, long days) {
        return TimePeriod.builder()
                .years(period.getYears())
                .months(period.getMonths())
                .days(period.getDays())
                .hours(duration.toHoursPart())
                .minutes(duration.toMinutesPart())
                .seconds(duration.toSecondsPart())
                .periodInMonths(period.toTotalMonths())
                .periodInDays(days)
                .periodInHours(calculationOfHours(days, duration))
                .periodInMinutes(calculationOfMinutes(days, duration))
                .periodInSeconds(calculationOfSeconds(days, duration))
                .build();
    }

    private long calculationOfHours(long days, Duration duration){
        return (days*HOURS_IN_DAY) + duration.toHours();
    }

    private long calculationOfMinutes(long days, Duration duration){
        return (days*MINUTES_IN_DAY) + duration.toMinutes();
    }

    private long calculationOfSeconds(long days, Duration duration){
        return (days*SECONDS_IN_DAY) + duration.toSeconds();
    }
}
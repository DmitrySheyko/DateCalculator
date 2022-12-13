package com.DmitrySheyko.DateCalculator.controller;

import com.DmitrySheyko.DateCalculator.dto.PeriodRequestDto;
import com.DmitrySheyko.DateCalculator.model.TimePeriod;
import com.DmitrySheyko.DateCalculator.service.PeriodService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/period")
public class PeriodController {
    PeriodService periodService;

    @GetMapping("/param")
    public TimePeriod getRequestInParams(@RequestParam(value = "zoneId1", required = false, defaultValue = "Etc/UTC") String zone1,
                                         @RequestParam(value = "zoneId2", required = false, defaultValue = "Etc/UTC") String zone2,
                                         @RequestParam(value = "year1", required = false, defaultValue = "0") int year1,
                                         @RequestParam(value = "year2", required = false, defaultValue = "0") int year2,
                                         @RequestParam(value = "month1", required = false, defaultValue = "0") int month1,
                                         @RequestParam(value = "month2", required = false, defaultValue = "0") int month2,
                                         @RequestParam(value = "day1", required = false, defaultValue = "0") int day1,
                                         @RequestParam(value = "day2", required = false, defaultValue = "0") int day2,
                                         @RequestParam(value = "hour1", required = false, defaultValue = "0") int hour1,
                                         @RequestParam(value = "hour2", required = false, defaultValue = "0") int hour2,
                                         @RequestParam(value = "minute1", required = false, defaultValue = "0") int minute1,
                                         @RequestParam(value = "minute2", required = false, defaultValue = "0") int minute2,
                                         @RequestParam(value = "second1", required = false, defaultValue = "0") int second1,
                                         @RequestParam(value = "second2", required = false, defaultValue = "0") int second2
    ) {
        PeriodRequestDto response = PeriodRequestDto.builder()
                .zoneId1(zone1).zoneId2(zone2)
                .year1(year1).year2(year2)
                .month1(month1).month2(month2)
                .day1(day1).day2(day2)
                .hour1(hour1).hour2(hour2)
                .minute1(minute1).minute2(minute2)
                .second1(second1).second2(second2)
                .build();
        return periodService.get(response);
    }

    @GetMapping("/body")
    public TimePeriod getRequestInBody(@RequestBody PeriodRequestDto response) {
        System.out.println("Controller " + response.getZoneId1());
        System.out.println("Controller " + response.getZoneId2());
        return periodService.get(response);
    }
}

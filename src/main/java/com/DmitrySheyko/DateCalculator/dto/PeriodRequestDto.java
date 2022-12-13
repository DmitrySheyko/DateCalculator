package com.DmitrySheyko.DateCalculator.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PeriodRequestDto {
    private String zoneId1;
    private String zoneId2;
    @NotNull
    @Min(value = 0, message = "YEAR value should be greater than zero")
    @Max(value = 999999999, message = "YEAR value should be less than 999999999")
    private int year1;

    @NotNull
    @Min(value = 0, message = "YEAR value should be greater than zero")
    @Max(value = 999999999, message = "YEAR value should be less than 999999999")
    private int year2;

    @NotNull
    @Min(value = 1, message = "MONTH value should be not less than 1")
    @Max(value = 12, message = "MONTH value should be not greater than 12")
    private int month1;

    @NotNull
    @Min(value = 1, message = "MONTH value should be not less than 1")
    @Max(value = 12, message = "MONTH value should be not greater than 12")
    private int month2;

    @NotNull
    @Min(value = 1, message = "DAY value should be not less than 1")
    @Max(value = 31, message = "DAY value should be not greater than 31")
    private int day1;

    @NotNull
    @Min(value = 1, message = "DAY value should be not less than 1")
    @Max(value = 31, message = "DAY value should be not greater than 31")
    private int day2;

    @NotNull
    @Min(value = 0, message = "HOUR value should be not less than 0")
    @Max(value = 23, message = "HOUR value should be not greater than 23")
    private int hour1;

    @NotNull
    @Min(value = 0, message = "HOUR value should be not less than 0")
    @Max(value = 23, message = "HOUR value should be not greater than 23")
    private int hour2;

    @NotNull
    @Min(value = 0, message = "MINUTE value should be not less than 0")
    @Max(value = 59, message = "MINUTE value should be not greater than 59")
    private int minute1;

    @NotNull
    @Min(value = 0, message = "MINUTE value should be not less than 0")
    @Max(value = 59, message = "MINUTE value should be not greater than 59")
    private int minute2;

    @NotNull
    @Min(value = 0, message = "SECOND value should be not less than 0")
    @Max(value = 59, message = "SECOND value should be not greater than 59")
    private int second1;

    @NotNull
    @Min(value = 0, message = "SECOND value should be not less than 0")
    @Max(value = 59, message = "SECOND value should be not greater than 59")
    private int second2;
}

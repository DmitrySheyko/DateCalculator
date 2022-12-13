package com.DmitrySheyko.DateCalculator.model;

import lombok.*;

@Getter
@Setter
@EqualsAndHashCode
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TimePeriod {
    private int years;
    private int months;
    private int days;
    private int hours;
    private int minutes;
    private int seconds;
    private double periodInMonths;
    private double periodInDays;
    private double periodInHours;
    private double periodInMinutes;
    private double periodInSeconds;
}
package com.DmitrySheyko.DateCalculator.model;

import lombok.*;

@Getter
@Setter
@EqualsAndHashCode
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DateTime implements Comparable<DateTime>{
    private int year;
    private int month;
    private int day;
    private int hour;
    private int minute;
    private int second;

    @Override
    public int compareTo(DateTime o) {
        return 0;
    }
}

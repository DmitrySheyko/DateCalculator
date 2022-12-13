package com.DmitrySheyko.DateCalculator;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.List;
import java.util.Set;

public class main {
    public static void main(String[] args) {

        LocalDate z  = LocalDate.MAX;
        System.out.println(z);
        Set<String> zoneIds = ZoneId.getAvailableZoneIds();
        for (String zone : zoneIds){
            System.out.println(zone);
        }
    }
}

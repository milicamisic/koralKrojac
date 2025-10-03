package com.ftn.sbnz.model.util;

import com.ftn.sbnz.model.models.enums.Season;

import java.time.LocalDate;
import java.time.Month;

public class SeasonUtils {

    public static boolean isInSeason(Season season) {
        Month now = LocalDate.now().getMonth();

        switch (season) {
            case WINTER:
                return (now == Month.DECEMBER || now == Month.JANUARY || now == Month.FEBRUARY);
            case SUMMER:
                return (now == Month.JUNE || now == Month.JULY || now == Month.AUGUST);
            case UNIVERSAL:
                return true;
            default:
                return false;
        }
    }
}

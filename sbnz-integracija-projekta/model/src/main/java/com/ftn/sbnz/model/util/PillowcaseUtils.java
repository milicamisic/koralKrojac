package com.ftn.sbnz.model.util;

public class PillowcaseUtils {

    public static double pillowcaseMeters(int length, int width, int fabricWidth) {
        double neededLength = (2 * length) + 10;
        double neededWidth = width + 5;
        double panels = (neededWidth <= fabricWidth) ? 1.0 : 2.0;
        return (neededLength * panels) / 100.0;
    }
}

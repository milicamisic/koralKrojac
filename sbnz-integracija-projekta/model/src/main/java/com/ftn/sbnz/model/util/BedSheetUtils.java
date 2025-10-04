package com.ftn.sbnz.model.util;

public class BedSheetUtils {

    // Čaršaf bez lastiša
    public static double flatSheetMeters(int length, int width, int overhang, int fabricWidth) {
        double neededLength = length + 2 * overhang + 10;
        double neededWidth = width + 2 * overhang + 10;
        double panels = (neededWidth <= fabricWidth) ? 1.0 : 2.0;
        return (neededLength * panels) / 100.0;
    }

    // Čaršaf sa lastišem
    public static double fittedSheetMeters(int length, int width, int height, int fabricWidth) {
        double neededLength = length + 2 * height + 10;
        double neededWidth = width + 2 * height + 10;
        double panels = (neededWidth <= fabricWidth) ? 1.0 : 2.0;
        return (neededLength * panels) / 100.0;
    }

    // Navlaka za jorgan
    public static double duvetCoverMeters(int length, int width, int fabricWidth) {
        double neededLength = 2 * length + 10;
        double neededWidth = width + 10;
        double panels = (neededWidth <= fabricWidth) ? 1.0 : 2.0;
        return (neededLength * panels) / 100.0;
    }
}

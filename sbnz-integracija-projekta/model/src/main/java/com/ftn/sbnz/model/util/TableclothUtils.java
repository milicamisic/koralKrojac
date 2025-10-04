package com.ftn.sbnz.model.util;

public class TableclothUtils {

    // Pravougaoni/kvadratni: vrati potrebne METRE (na osnovu dimenzija u cm i širine platna u cm)
    public static double rectangleFabricMeters(double lengthCm, double widthCm, double overhangCm, double fabricWidthCm) {
        double neededLength = lengthCm + 2 * overhangCm; // cm
        double neededWidth  = widthCm  + 2 * overhangCm; // cm
        double panels = (neededWidth <= fabricWidthCm) ? 1.0 : 2.0;
        return (neededLength * panels) / 100.0; // u metrima
    }

    // Okrugli: uključuje +10% otpada zbog kružnog krojenja
    public static double roundFabricMetersWithWaste(double diameterCm, double overhangCm, double fabricWidthCm) {
        double neededWidth = diameterCm + 2 * overhangCm; // cm
        double panels = (neededWidth <= fabricWidthCm) ? 1.0 : 2.0;
        double meters = (neededWidth * panels) / 100.0;   // bazno (metri)
        return meters * 1.10; // +10% otpad
    }
}

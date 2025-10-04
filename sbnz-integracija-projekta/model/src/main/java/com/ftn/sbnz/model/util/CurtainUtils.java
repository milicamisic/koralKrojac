package com.ftn.sbnz.model.util;

public class CurtainUtils {

    public static double calculateCurtainLength(
            int height, int windowWidth, double pleatingFactor,
            String hangingType, int marginTop, int marginBottom, int fabricWidth) {

        // korekcija gornje margine prema tipu kačenja
        int topExtra = 0;
        if (hangingType != null) {
            switch (hangingType.toLowerCase()) {
                case "kanal":
                    topExtra = 10; // +10 cm
                    break;
                case "prstenovi":
                case "metalni prstenovi":
                    topExtra = 20; // +20 cm
                    break;
                case "kukice":
                case "karike":
                default:
                    topExtra = 0; // bez korekcije
                    break;
            }
        }

        // ukupna širina zavese = širina prozora × faktor nabrane
        double totalWidth = windowWidth * pleatingFactor;

        // broj panela = zaokruži naviše ako širina prelazi širinu platna
        int panels = (int) Math.ceil(totalWidth / fabricWidth);

        // ukupna visina = visina zavese + gornja i donja margina
        double neededHeight = height + marginTop + marginBottom + topExtra;

        // metraža = visina × broj panela
        double meters = (neededHeight * panels) / 100.0; // cm → m

        // +10% otpad pri krojenju
        return meters * 1.1;
    }
}

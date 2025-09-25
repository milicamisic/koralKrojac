package com.ftn.sbnz.model.models;

public class Recommendation {
    private Fabric fabric;
    private double requiredLength; // u metrima
    private String note; // upozorenja ili dodatne informacije

    public Recommendation() {}

    public Recommendation(Fabric fabric, double requiredLength, String note) {
        this.fabric = fabric;
        this.requiredLength = requiredLength;
        this.note = note;
    }

    public Fabric getFabric() {
        return fabric;
    }

    public void setFabric(Fabric fabric) {
        this.fabric = fabric;
    }

    public double getRequiredLength() {
        return requiredLength;
    }

    public void setRequiredLength(double requiredLength) {
        this.requiredLength = requiredLength;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}

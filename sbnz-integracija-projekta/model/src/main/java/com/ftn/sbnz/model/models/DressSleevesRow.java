package com.ftn.sbnz.model.models;

public class DressSleevesRow {
    private String sleeveType;   // NONE, SHORT, LONG
    private int maxLength;       // npr. <20, ≥20, ili 0 ako je bez rukava
    private double adjustment;   // -0.3, +0.2, +0.5

    public String getSleeveType() {
        return sleeveType;
    }

    public void setSleeveType(String sleeveType) {
        this.sleeveType = sleeveType;
    }

    public int getMaxLength() {
        return maxLength;
    }

    public void setMaxLength(int maxLength) {
        this.maxLength = maxLength;
    }

    public double getAdjustment() {
        return adjustment;
    }

    public void setAdjustment(double adjustment) {
        this.adjustment = adjustment;
    }
}

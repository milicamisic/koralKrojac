package com.ftn.sbnz.model.models;

public class DressHipsRow {
    private String type;      // Shift ili Bodycon
    private int minHips;
    private int maxHips;
    private double adjustment; // 0, +0.1, +0.2...

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getMinHips() {
        return minHips;
    }

    public void setMinHips(int minHips) {
        this.minHips = minHips;
    }

    public int getMaxHips() {
        return maxHips;
    }

    public void setMaxHips(int maxHips) {
        this.maxHips = maxHips;
    }

    public double getAdjustment() {
        return adjustment;
    }

    public void setAdjustment(double adjustment) {
        this.adjustment = adjustment;
    }
}

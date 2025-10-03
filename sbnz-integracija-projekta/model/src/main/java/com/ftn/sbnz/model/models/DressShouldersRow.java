package com.ftn.sbnz.model.models;

public class DressShouldersRow {
    private int minShoulder;
    private int maxShoulder;
    private double adjustment; // 0, +0.1, +0.2

    public int getMinShoulder() {
        return minShoulder;
    }

    public void setMinShoulder(int minShoulder) {
        this.minShoulder = minShoulder;
    }

    public int getMaxShoulder() {
        return maxShoulder;
    }

    public void setMaxShoulder(int maxShoulder) {
        this.maxShoulder = maxShoulder;
    }

    public double getAdjustment() {
        return adjustment;
    }

    public void setAdjustment(double adjustment) {
        this.adjustment = adjustment;
    }
}

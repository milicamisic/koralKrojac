package com.example.fabric.model;

public class BodyMeasurements {
    private double chest;
    private double waist;
    private double hips;
    private double inseam;
    private double height;
    private double armLength;
    private double shoulderWidth;
    private double neckCircumference;

    public BodyMeasurements() {}

    public BodyMeasurements(double chest, double waist, double hips, double inseam, double height, double armLength, double shoulderWidth, double neckCircumference) {
        this.chest = chest;
        this.waist = waist;
        this.hips = hips;
        this.inseam = inseam;
        this.height = height;
        this.armLength = armLength;
        this.shoulderWidth = shoulderWidth;
        this.neckCircumference = neckCircumference;
    }

    public double getChest() {
        return chest;
    }

    public void setChest(double chest) {
        this.chest = chest;
    }

    public double getWaist() {
        return waist;
    }

    public void setWaist(double waist) {
        this.waist = waist;
    }

    public double getHips() {
        return hips;
    }

    public void setHips(double hips) {
        this.hips = hips;
    }

    public double getInseam() {
        return inseam;
    }

    public void setInseam(double inseam) {
        this.inseam = inseam;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getArmLength() {
        return armLength;
    }

    public void setArmLength(double armLength) {
        this.armLength = armLength;
    }

    public double getShoulderWidth() {
        return shoulderWidth;
    }

    public void setShoulderWidth(double shoulderWidth) {
        this.shoulderWidth = shoulderWidth;
    }

    public double getNeckCircumference() {
        return neckCircumference;
    }

    public void setNeckCircumference(double neckCircumference) {
        this.neckCircumference = neckCircumference;
    }
}

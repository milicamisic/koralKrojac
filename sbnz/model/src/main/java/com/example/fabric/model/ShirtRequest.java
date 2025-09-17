package com.example.fabric.model;

public class ShirtRequest {
    public double chestCircumference;
    public double torsoLength;
    public boolean hasSleeves;
    public double sleeveLength;
    public double shoulderWidth;
    public String fit;

    public ShirtRequest() {}

    public ShirtRequest(double chestCircumference, double torsoLength, boolean hasSleeves, double sleeveLength, double shoulderWidth, String fit) {
        this.chestCircumference = chestCircumference;
        this.torsoLength = torsoLength;
        this.hasSleeves = hasSleeves;
        this.sleeveLength = sleeveLength;
        this.shoulderWidth = shoulderWidth;
        this.fit = fit;
    }

    public double getChestCircumference() {
        return chestCircumference;
    }

    public void setChestCircumference(double chestCircumference) {
        this.chestCircumference = chestCircumference;
    }

    public double getTorsoLength() {
        return torsoLength;
    }

    public void setTorsoLength(double torsoLength) {
        this.torsoLength = torsoLength;
    }

    public boolean isHasSleeves() {
        return hasSleeves;
    }

    public void setHasSleeves(boolean hasSleeves) {
        this.hasSleeves = hasSleeves;
    }

    public double getSleeveLength() {
        return sleeveLength;
    }

    public void setSleeveLength(double sleeveLength) {
        this.sleeveLength = sleeveLength;
    }

    public double getShoulderWidth() {
        return shoulderWidth;
    }

    public void setShoulderWidth(double shoulderWidth) {
        this.shoulderWidth = shoulderWidth;
    }

    public String getFit() {
        return fit;
    }

    public void setFit(String fit) {
        this.fit = fit;
    }
}

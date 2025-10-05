package com.ftn.sbnz.service.dto;

public class ShirtRequest {
    private int bust;
    private int torsoLength;
    private int shoulderWidth;
    private String fit; // STANDARD, SLIM, OVERSIZED
    private String sleeveType;

    public int getBust() {
        return bust;
    }

    public void setBust(int bust) {
        this.bust = bust;
    }

    public int getTorsoLength() {
        return torsoLength;
    }

    public void setTorsoLength(int torsoLength) {
        this.torsoLength = torsoLength;
    }

    public String getSleeveType() {
        return sleeveType;
    }

    public void setSleeveType(String sleeveType) {
        this.sleeveType = sleeveType;
    }

    public int getShoulderWidth() {
        return shoulderWidth;
    }

    public void setShoulderWidth(int shoulderWidth) {
        this.shoulderWidth = shoulderWidth;
    }

    public String getFit() {
        return fit;
    }

    public void setFit(String fit) {
        this.fit = fit;
    }
}

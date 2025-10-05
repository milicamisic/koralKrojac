package com.ftn.sbnz.service.dto;

public class BlouseRequest {
    private int bust;
    private int waist;
    private int torsoLength;
    private int shoulder;
    private int neck;
    private String collarType; // klasična, mandarinska, oversized, bez
    private String sleeveType;
    private String fit;

    public BlouseRequest() {}

    public BlouseRequest(int bust, int waist, int torsoLength, int shoulder, int neck, String collarType, String sleeveType, String fit) {
        this.bust = bust;
        this.waist = waist;
        this.torsoLength = torsoLength;
        this.shoulder = shoulder;
        this.neck = neck;
        this.collarType = collarType;
        this.sleeveType = sleeveType;
        this.fit = fit;
    }

    public int getBust() {
        return bust;
    }

    public void setBust(int bust) {
        this.bust = bust;
    }

    public int getWaist() {
        return waist;
    }

    public void setWaist(int waist) {
        this.waist = waist;
    }

    public int getTorsoLength() {
        return torsoLength;
    }

    public void setTorsoLength(int torsoLength) {
        this.torsoLength = torsoLength;
    }

    public int getShoulder() {
        return shoulder;
    }

    public void setShoulder(int shoulder) {
        this.shoulder = shoulder;
    }

    public int getNeck() {
        return neck;
    }

    public void setNeck(int neck) {
        this.neck = neck;
    }

    public String getCollarType() {
        return collarType;
    }

    public void setCollarType(String collarType) {
        this.collarType = collarType;
    }

    public String getSleeveType() {
        return sleeveType;
    }

    public void setSleeveType(String sleeveType) {
        this.sleeveType = sleeveType;
    }

    public String getFit() {
        return fit;
    }

    public void setFit(String fit) {
        this.fit = fit;
    }

    @Override
    public String toString() {
        return "BlouseRequest{" +
                "bust=" + bust +
                ", waist=" + waist +
                ", torsoLength=" + torsoLength +
                ", shoulder=" + shoulder +
                ", neck=" + neck +
                ", collarType='" + collarType + '\'' +
                ", sleeveType='" + sleeveType + '\'' +
                ", fit='" + fit + '\'' +
                '}';
    }
}

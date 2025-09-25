package com.ftn.sbnz.model.models;

public class Shirt extends Garment {
    private int bust;
    private int waist;
    private int torsoLength;
    private int sleeveLength;
    private int shoulder;
    private int neck;
    private boolean hasSleeves;
    private String collarType; // klasična, mandarinska, oversized, bez

    public Shirt(int bust, int waist, int torsoLength, int sleeveLength, int shoulder, int neck, boolean hasSleeves, String collarType) {
        this.bust = bust;
        this.waist = waist;
        this.torsoLength = torsoLength;
        this.sleeveLength = sleeveLength;
        this.shoulder = shoulder;
        this.neck = neck;
        this.hasSleeves = hasSleeves;
        this.collarType = collarType;
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

    public int getSleeveLength() {
        return sleeveLength;
    }

    public void setSleeveLength(int sleeveLength) {
        this.sleeveLength = sleeveLength;
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

    public boolean isHasSleeves() {
        return hasSleeves;
    }

    public void setHasSleeves(boolean hasSleeves) {
        this.hasSleeves = hasSleeves;
    }

    public String getCollarType() {
        return collarType;
    }

    public void setCollarType(String collarType) {
        this.collarType = collarType;
    }
}

package com.ftn.sbnz.model.models;

public class Shirt extends Garment {
    private int bust;
    private int torsoLength;
    private int shoulder;
    private String sleeveType;

    public Shirt() {}

    public Shirt(int bust, int waist, int torsoLength, int shoulder, boolean hasSleeves, int sleeveLength, String sleeveType) {
        this.bust = bust;
        this.torsoLength = torsoLength;
        this.shoulder = shoulder;
        this.sleeveType = sleeveType;
    }

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

    public int getShoulder() {
        return shoulder;
    }

    public void setShoulder(int shoulder) {
        this.shoulder = shoulder;
    }

    public String getSleeveType() {
        return sleeveType;
    }

    public void setSleeveType(String sleeveType) {
        this.sleeveType = sleeveType;
    }

    @Override
    public String toString() {
        return "Shirt{" +
                "fit='" + fit + '\'' +
                ", color='" + color + '\'' +
                ", shoulder=" + shoulder +
                ", torsoLength=" + torsoLength +
                ", bust=" + bust +
                '}';
    }
}

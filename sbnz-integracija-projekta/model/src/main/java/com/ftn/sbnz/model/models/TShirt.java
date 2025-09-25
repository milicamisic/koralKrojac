package com.ftn.sbnz.model.models;

public class TShirt extends Garment {
    private int bust;
    private int waist;
    private int torsoLength;
    private int shoulder;
    private boolean hasSleeves;
    private int sleeveLength;

    public TShirt() {}

    public TShirt(int bust, int waist, int torsoLength, int shoulder, boolean hasSleeves, int sleeveLength) {
        this.bust = bust;
        this.waist = waist;
        this.torsoLength = torsoLength;
        this.shoulder = shoulder;
        this.hasSleeves = hasSleeves;
        this.sleeveLength = sleeveLength;
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

    public boolean isHasSleeves() {
        return hasSleeves;
    }

    public void setHasSleeves(boolean hasSleeves) {
        this.hasSleeves = hasSleeves;
    }

    public int getSleeveLength() {
        return sleeveLength;
    }

    public void setSleeveLength(int sleeveLength) {
        this.sleeveLength = sleeveLength;
    }

    @Override
    public String toString() {
        return "TShirt{" +
                "fit='" + fit + '\'' +
                ", color='" + color + '\'' +
                ", sleeveLength=" + sleeveLength +
                ", hasSleeves=" + hasSleeves +
                ", shoulder=" + shoulder +
                ", torsoLength=" + torsoLength +
                ", waist=" + waist +
                ", bust=" + bust +
                '}';
    }
}

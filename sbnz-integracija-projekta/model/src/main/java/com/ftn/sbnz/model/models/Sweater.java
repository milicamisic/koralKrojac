package com.ftn.sbnz.model.models;

public class Sweater extends Garment {
    private int bust;
    private int torsoLength;
    private int sleeveLength;
    private int shoulder;
    private String yarnThickness; // tanka, srednja, debela
    private boolean hasSleeves;

    public Sweater() {}

    public Sweater(int bust, int torsoLength, int sleeveLength, int shoulder, String yarnThickness, boolean hasSleeves) {
        this.bust = bust;
        this.torsoLength = torsoLength;
        this.sleeveLength = sleeveLength;
        this.shoulder = shoulder;
        this.yarnThickness = yarnThickness;
        this.hasSleeves = hasSleeves;
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

    public String getYarnThickness() {
        return yarnThickness;
    }

    public void setYarnThickness(String yarnThickness) {
        this.yarnThickness = yarnThickness;
    }

    public boolean isHasSleeves() {
        return hasSleeves;
    }

    public void setHasSleeves(boolean hasSleeves) {
        this.hasSleeves = hasSleeves;
    }
}

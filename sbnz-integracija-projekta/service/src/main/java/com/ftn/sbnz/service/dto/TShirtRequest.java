package com.ftn.sbnz.service.dto;

public class TShirtRequest {
    private int bust;
    private int waist;
    private int torsoLength;
    private boolean hasSleeves;
    private int sleeveLength;
    private int shoulder;
    private String fit;

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

    public int getShoulder() {
        return shoulder;
    }

    public void setShoulder(int shoulder) {
        this.shoulder = shoulder;
    }

    public String getFit() {
        return fit;
    }

    public void setFit(String fit) {
        this.fit = fit;
    }
}

package com.ftn.sbnz.model.models;

public class Dress extends Garment {
    private int bust;
    private int waist;
    private int hips;
    private int length;
    private boolean hasSleeves;
    private int sleeveLength;
    private int shoulder;
    private String type; // A-line, Circle, Bodycon, Shift
    private int height;

    public Dress(int bust, int waist, int hips, int length, boolean hasSleeves, int sleeveLength, int shoulder, String type, int height) {
        this.bust = bust;
        this.waist = waist;
        this.hips = hips;
        this.length = length;
        this.hasSleeves = hasSleeves;
        this.sleeveLength = sleeveLength;
        this.shoulder = shoulder;
        this.type = type;
        this.height = height;
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

    public int getHips() {
        return hips;
    }

    public void setHips(int hips) {
        this.hips = hips;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
}

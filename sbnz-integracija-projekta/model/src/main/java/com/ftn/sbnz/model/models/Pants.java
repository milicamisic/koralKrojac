package com.ftn.sbnz.model.models;

public class Pants extends Garment {
    private int waist;
    private int hips;
    private int inseamLength;  // unutrašnja dužina
    private int outseamLength; // spoljašnja dužina
    private String fit; // slim, loose, standard

    public Pants(int waist, int hips, int inseamLength, int outseamLength, String fit) {
        this.waist = waist;
        this.hips = hips;
        this.inseamLength = inseamLength;
        this.outseamLength = outseamLength;
        this.fit = fit;
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

    public int getInseamLength() {
        return inseamLength;
    }

    public void setInseamLength(int inseamLength) {
        this.inseamLength = inseamLength;
    }

    public int getOutseamLength() {
        return outseamLength;
    }

    public void setOutseamLength(int outseamLength) {
        this.outseamLength = outseamLength;
    }

    @Override
    public String getFit() {
        return fit;
    }

    @Override
    public void setFit(String fit) {
        this.fit = fit;
    }
}

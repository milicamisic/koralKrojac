package com.ftn.sbnz.service.dto;

public class PantsRequest {
    private int waist;
    private int hips;
    private int inseamLength;
    private int outseamLength;
    private String fit; // STANDARD, SLIM, LOOSE

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

    public String getFit() {
        return fit;
    }

    public void setFit(String fit) {
        this.fit = fit;
    }
}

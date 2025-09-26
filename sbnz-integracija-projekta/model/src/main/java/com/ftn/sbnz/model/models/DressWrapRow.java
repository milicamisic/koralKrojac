package com.ftn.sbnz.model.models;

public class DressWrapRow {
    private String type;
    private boolean wrap;
    private double extraLength;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public boolean isWrap() {
        return wrap;
    }

    public void setWrap(boolean wrap) {
        this.wrap = wrap;
    }

    public double getExtraLength() {
        return extraLength;
    }

    public void setExtraLength(double extraLength) {
        this.extraLength = extraLength;
    }
}

package com.ftn.sbnz.model.models;

public class DressBaseLengthRow {
    private String dressType;
    private Integer minLength;
    private Integer maxLength;
    private Double baseLength;

    public DressBaseLengthRow() {}

    public DressBaseLengthRow(String dressType, Integer minLength, Integer maxLength, Double baseLength) {
        this.dressType = dressType;
        this.minLength = minLength;
        this.maxLength = maxLength;
        this.baseLength = baseLength;
    }

    public String getDressType() { return dressType; }
    public void setDressType(String dressType) { this.dressType = dressType; }

    public Integer getMinLength() { return minLength; }
    public void setMinLength(Integer minLength) { this.minLength = minLength; }

    public Integer getMaxLength() { return maxLength; }
    public void setMaxLength(Integer maxLength) { this.maxLength = maxLength; }

    public Double getBaseLength() { return baseLength; }
    public void setBaseLength(Double baseLength) { this.baseLength = baseLength; }
}

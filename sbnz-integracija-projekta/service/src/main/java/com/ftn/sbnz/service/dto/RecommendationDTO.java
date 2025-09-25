package com.ftn.sbnz.service.dto;

public class RecommendationDTO {

    private String fabricName;
    private String fabricType;
    private double pricePerMeter;
    private double requiredLength; // in meters
    private String note;

    public RecommendationDTO() {}

    public RecommendationDTO(String fabricName, String fabricType, double pricePerMeter,
                             double requiredLength, String note) {
        this.fabricName = fabricName;
        this.fabricType = fabricType;
        this.pricePerMeter = pricePerMeter;
        this.requiredLength = requiredLength;
        this.note = note;
    }

    // Getters and setters
    public String getFabricName() {
        return fabricName;
    }

    public void setFabricName(String fabricName) {
        this.fabricName = fabricName;
    }

    public String getFabricType() {
        return fabricType;
    }

    public void setFabricType(String fabricType) {
        this.fabricType = fabricType;
    }

    public double getPricePerMeter() {
        return pricePerMeter;
    }

    public void setPricePerMeter(double pricePerMeter) {
        this.pricePerMeter = pricePerMeter;
    }

    public double getRequiredLength() {
        return requiredLength;
    }

    public void setRequiredLength(double requiredLength) {
        this.requiredLength = requiredLength;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}


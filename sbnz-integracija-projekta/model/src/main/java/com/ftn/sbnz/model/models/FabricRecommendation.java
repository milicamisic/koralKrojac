package com.ftn.sbnz.model.models;

public class FabricRecommendation {
    private Fabric fabric;
    private double requiredLength; // u metrima
    private String note; // upozorenja ili dodatne informacije
    private String garmentCategory; // npr. "Dress", "Shirt", "Skirt"
    private String garmentSubtype;  // npr. "A-line", "Shift", "Bodycon", null za ne-haljine

    public FabricRecommendation() {}

    public FabricRecommendation(Fabric fabric, double requiredLength, String note) {
        this.fabric = fabric;
        this.requiredLength = requiredLength;
        this.note = note;
    }

    public FabricRecommendation(Fabric fabric, double requiredLength, String note,
                                String garmentCategory, String garmentSubtype) {
        this.fabric = fabric;
        this.requiredLength = requiredLength;
        this.note = note;
        this.garmentCategory = garmentCategory;
        this.garmentSubtype = garmentSubtype;
    }

    public Fabric getFabric() {
        return fabric;
    }

    public void setFabric(Fabric fabric) {
        this.fabric = fabric;
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

    public String getGarmentCategory() { return garmentCategory; }
    public void setGarmentCategory(String garmentCategory) { this.garmentCategory = garmentCategory; }

    public String getGarmentSubtype() { return garmentSubtype; }
    public void setGarmentSubtype(String garmentSubtype) { this.garmentSubtype = garmentSubtype; }

    @Override
    public String toString() {
        return "FabricRecommendation{" +
                "fabric=" + fabric +
                ", requiredLength=" + requiredLength +
                ", note='" + note + '\'' +
                ", garmentCategory='" + garmentCategory + '\'' +
                ", garmentSubtype='" + garmentSubtype + '\'' +
                '}';
    }
}


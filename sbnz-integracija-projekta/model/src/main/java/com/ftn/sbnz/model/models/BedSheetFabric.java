package com.ftn.sbnz.model.models;

import java.io.Serializable;

public class BedSheetFabric implements Serializable {

    private BedSheet bedSheet;
    private Fabric fabric;

    public BedSheetFabric() {}

    public BedSheetFabric(BedSheet bedSheet, Fabric fabric) {
        this.bedSheet = bedSheet;
        this.fabric = fabric;
    }

    public BedSheet getBedSheet() {
        return bedSheet;
    }

    public void setBedSheet(BedSheet bedSheet) {
        this.bedSheet = bedSheet;
    }

    public Fabric getFabric() {
        return fabric;
    }

    public void setFabric(Fabric fabric) {
        this.fabric = fabric;
    }

    // pomocni getteri za pravila
    public String getType() { return bedSheet != null ? bedSheet.getType() : null; }
    public int getLength() { return bedSheet != null ? bedSheet.getLength() : 0; }
    public int getWidth() { return bedSheet != null ? bedSheet.getWidth() : 0; }
    public int getHeight() { return bedSheet != null ? bedSheet.getHeight() : 0; }
    public int getOverhang() { return bedSheet != null ? bedSheet.getOverhang() : 0; }

    public int getFabricWidth() { return fabric != null ? fabric.getWidth() : 0; }
    public String getFabricCategory() { return fabric != null ? fabric.getCategory() : null; }

    @Override
    public String toString() {
        return "BedSheetFabric{" +
                "bedSheet=" + bedSheet +
                ", fabric=" + fabric +
                '}';
    }
}

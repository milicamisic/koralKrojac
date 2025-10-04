package com.ftn.sbnz.model.models;

import java.io.Serializable;

public class TableclothFabric implements Serializable {

    private Tablecloth tablecloth;
    private Fabric fabric;

    public TableclothFabric() {}

    public TableclothFabric(Tablecloth tablecloth, Fabric fabric) {
        this.tablecloth = tablecloth;
        this.fabric = fabric;
    }

    public Tablecloth getTablecloth() { return tablecloth; }
    public void setTablecloth(Tablecloth tablecloth) { this.tablecloth = tablecloth; }

    public Fabric getFabric() { return fabric; }
    public void setFabric(Fabric fabric) { this.fabric = fabric; }

    // helpers za pravila
    public String getShape() { return tablecloth != null ? tablecloth.getShape() : null; }
    public double getLength() { return tablecloth != null ? tablecloth.getLength() : 0; }
    public double getWidth() { return tablecloth != null ? tablecloth.getWidth() : 0; }
    public double getDiameter() { return tablecloth != null ? tablecloth.getDiameter() : 0; }
    public double getOverhang() { return tablecloth != null ? tablecloth.getOverhang() : 0; }

    // širina platna (Fabric.width u cm)
    public int getFabricWidth() { return fabric != null ? fabric.getWidth() : 0; }
    public String getFabricCategory() { return fabric != null ? fabric.getCategory() : null; }

    @Override
    public String toString() {
        return "TableclothFabric{" +
                "tablecloth=" + tablecloth +
                ", fabric=" + fabric +
                '}';
    }
}

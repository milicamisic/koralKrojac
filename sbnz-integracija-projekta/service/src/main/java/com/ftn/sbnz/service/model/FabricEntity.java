package com.ftn.sbnz.service.model;

import javax.persistence.*;

@Entity
@Table(name = "fabric")
public class FabricEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "type")
    private String type;

    @Column(name = "width")
    private int width;

    @Column(name = "stretch_percentage")
    private double stretchPercentage;

    @Column(name = "shrinkage_percentage")
    private double shrinkagePercentage;

    @Column(name = "has_nap")
    private boolean hasNap;

    @Column(name = "drape")
    private String drape;

    @Column(name = "gsm")
    private int gsm;

    @Column(name = "category")
    private String category;

    @Column(name = "price_per_meter")
    private double pricePerMeter;

    @Column(name = "in_stock")
    private int inStock;

    public FabricEntity() { }

    public FabricEntity(Long id, String name, String type, int width, double stretchPercentage, double shrinkagePercentage, boolean hasNap, String drape, int gsm, String category, double pricePerMeter, int inStock) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.width = width;
        this.stretchPercentage = stretchPercentage;
        this.shrinkagePercentage = shrinkagePercentage;
        this.hasNap = hasNap;
        this.drape = drape;
        this.gsm = gsm;
        this.category = category;
        this.pricePerMeter = pricePerMeter;
        this.inStock = inStock;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public double getStretchPercentage() {
        return stretchPercentage;
    }

    public void setStretchPercentage(double stretchPercentage) {
        this.stretchPercentage = stretchPercentage;
    }

    public double getShrinkagePercentage() {
        return shrinkagePercentage;
    }

    public void setShrinkagePercentage(double shrinkagePercentage) {
        this.shrinkagePercentage = shrinkagePercentage;
    }

    public boolean isHasNap() {
        return hasNap;
    }

    public void setHasNap(boolean hasNap) {
        this.hasNap = hasNap;
    }

    public String getDrape() {
        return drape;
    }

    public void setDrape(String drape) {
        this.drape = drape;
    }

    public int getGsm() {
        return gsm;
    }

    public void setGsm(int gsm) {
        this.gsm = gsm;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public double getPricePerMeter() {
        return pricePerMeter;
    }

    public void setPricePerMeter(double pricePerMeter) {
        this.pricePerMeter = pricePerMeter;
    }

    public int getInStock() {
        return inStock;
    }

    public void setInStock(int inStock) {
        this.inStock = inStock;
    }
}

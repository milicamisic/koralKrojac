package com.ftn.sbnz.model.models;

import com.ftn.sbnz.model.models.enums.Season;

import java.io.Serializable;

public class Fabric implements Serializable {

    // Polja iz specifikacije
    private String name;                   // naziv materijala
    private String type;                   // pamuk, vuna, viskoza, lan, sintetika
    private int width;                     // širina platna u cm
    private double stretchPercentage;      // % rastegljivosti
    private double shrinkagePercentage;    // % skupljanja
    private boolean hasNap;                // da li ima pravac dezena
    private String drape;                  // high ili low
    private int gsm;                       // težina materijala g/m2

    // Dodatna polja za aplikaciju
    private Long id;                       // zbog baze
    private String category;               // CLOTHING ili DECORATION
    private double pricePerMeter;          // cena po metru
    private int inStock;                   // dostupna količina

    // zbog stagnacije
    private Season season; // WINTER, SUMMER, UNIVERSAL

    public Fabric() {}

    public Fabric(Long id, String name, String type, int width,
                  double stretchPercentage, double shrinkagePercentage,
                  boolean hasNap, String drape, int gsm,
                  String category, double pricePerMeter, int inStock, Season season) {
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
        this.season = season;
    }

    // Getteri i setteri
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getType() { return type; }
    public void setType(String type) { this.type = type; }

    public int getWidth() { return width; }
    public void setWidth(int width) { this.width = width; }

    public double getStretchPercentage() { return stretchPercentage; }
    public void setStretchPercentage(double stretchPercentage) { this.stretchPercentage = stretchPercentage; }

    public double getShrinkagePercentage() { return shrinkagePercentage; }
    public void setShrinkagePercentage(double shrinkagePercentage) { this.shrinkagePercentage = shrinkagePercentage; }

    public boolean isHasNap() { return hasNap; }
    public void setHasNap(boolean hasNap) { this.hasNap = hasNap; }

    public String getDrape() { return drape; }
    public void setDrape(String drape) { this.drape = drape; }

    public int getGsm() { return gsm; }
    public void setGsm(int gsm) { this.gsm = gsm; }

    public String getCategory() { return category; }
    public void setCategory(String category) { this.category = category; }

    public double getPricePerMeter() { return pricePerMeter; }
    public void setPricePerMeter(double pricePerMeter) { this.pricePerMeter = pricePerMeter; }

    public int getInStock() { return inStock; }
    public void setInStock(int inStock) { this.inStock = inStock; }

    public Season getSeason() {
        return season;
    }

    public void setSeason(Season season) {
        this.season = season;
    }

    @Override
    public String toString() {
        return "Fabric{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", width=" + width +
                ", stretchPercentage=" + stretchPercentage +
                ", shrinkagePercentage=" + shrinkagePercentage +
                ", hasNap=" + hasNap +
                ", drape='" + drape + '\'' +
                ", gsm=" + gsm +
                ", category='" + category + '\'' +
                ", pricePerMeter=" + pricePerMeter +
                ", inStock=" + inStock +
                ", season='" + season + '\'' +
                '}';
    }
}

package com.example.fabric.model;

import jakarta.persistence.*;

@Entity()
@Table(name = "fabric")
public class Fabric {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;        // npr. "Pamuk", "Viskoza", "Lan", "Vuna", "Sintetika"
    private double stretchPct;  // npr. 12.0
    private double shrinkPct;   // npr. 5.0
    private int widthCm;        // npr. 140
    private boolean nap;        // ima li pravac dezena
    private String drape;       // "high" | "low"
    private int gsm;            // gramatura

    public Fabric() {}

    public Fabric(Long id, String name, double stretchPct, double shrinkPct, int widthCm, boolean nap, String drape, int gsm) {
        this.id = id;
        this.name = name;
        this.stretchPct = stretchPct;
        this.shrinkPct = shrinkPct;
        this.widthCm = widthCm;
        this.nap = nap;
        this.drape = drape;
        this.gsm = gsm;
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

    public double getStretchPct() {
        return stretchPct;
    }

    public void setStretchPct(double stretchPct) {
        this.stretchPct = stretchPct;
    }

    public double getShrinkPct() {
        return shrinkPct;
    }

    public void setShrinkPct(double shrinkPct) {
        this.shrinkPct = shrinkPct;
    }

    public int getWidthCm() {
        return widthCm;
    }

    public void setWidthCm(int widthCm) {
        this.widthCm = widthCm;
    }

    public boolean isNap() {
        return nap;
    }

    public void setNap(boolean nap) {
        this.nap = nap;
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
}

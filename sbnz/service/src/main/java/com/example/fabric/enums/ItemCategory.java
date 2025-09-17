package com.example.fabric.enums;

public enum ItemCategory {
    CLOTHING("Clothing"),
    HOME_DECOR("Home Decor");

    private final String label;

    ItemCategory(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }
}

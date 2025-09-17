package com.example.fabric.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Evaluation {

    private double baseLength;  // base fabric length in meters
    private Map<String, Double> lengthPerFabric; // fabric name -> required length
    private List<String> messages; // fired rule explanations

    public Evaluation() {
        this.baseLength = 0.0;
        this.lengthPerFabric = new HashMap<>();
        this.messages = new ArrayList<>();
    }

    public double getBaseLength() {
        return baseLength;
    }

    public void setBaseLength(double baseLength) {
        this.baseLength = baseLength;
    }

    public Map<String, Double> getLengthPerFabric() {
        return lengthPerFabric;
    }

    public void setLengthPerFabric(Map<String, Double> lengthPerFabric) {
        this.lengthPerFabric = lengthPerFabric;
    }

    public List<String> getMessages() {
        return messages;
    }

    public void setMessages(List<String> messages) {
        this.messages = messages;
    }

    // convenience methods
    public void addMessage(String msg) {
        this.messages.add(msg);
    }

    public void addFabricLength(String fabricName, double length) {
        this.lengthPerFabric.put(fabricName, length);
    }

    @Override
    public String toString() {
        return "Evaluation{" +
                "baseLength=" + baseLength +
                ", lengthPerFabric=" + lengthPerFabric +
                ", messages=" + messages +
                '}';
    }
}

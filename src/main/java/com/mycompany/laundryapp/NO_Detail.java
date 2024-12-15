/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.laundryapp;

/**
 *
 * @author DamHung
 */
public class NO_Detail {
    private String category;          // Category (String)
    private float weight;             // Weight (float)
    private String service;           // Service (String)
    private float pricePerKilo;       // PricePerKilo (float)
    private float serviceMultiplier;  // ServiceMultiplier (float)
    private float total;              // Total (float)

    // Default constructor
    public NO_Detail() {
        this.category = "";
        this.weight = 0.0f;
        this.service = "";
        this.pricePerKilo = 0.0f;
        this.serviceMultiplier = 1.0f;  // Default multiplier
        this.total = pricePerKilo*serviceMultiplier*weight;
    }

    // Parameterized constructor
    public NO_Detail(String category, float weight, String service, float pricePerKilo, float serviceMultiplier) {
        this.category = category;
        this.weight = weight;
        this.service = service;
        this.pricePerKilo = pricePerKilo;
        this.serviceMultiplier = serviceMultiplier;
        this.total = pricePerKilo*serviceMultiplier*weight;
    }

    // Getters and Setters
    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
    }

    public float getPricePerKilo() {
        return pricePerKilo;
    }

    public void setPricePerKilo(float pricePerKilo) {
        this.pricePerKilo = pricePerKilo;
    }

    public float getServiceMultiplier() {
        return serviceMultiplier;
    }

    public void setServiceMultiplier(float serviceMultiplier) {
        this.serviceMultiplier = serviceMultiplier;
    }

    public float getTotal() {
        return pricePerKilo*serviceMultiplier*weight;
    }

    public void setTotal(float total) {
        this.total = total;
    }
}

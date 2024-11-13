/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.laundryapp;

public class Detail {
    private int serviceId;          // Corresponds to LS_id
    private int catId;        // Corresponds to ITEM_id
    private int orderId;       // Corresponds to ORDER_id
    private float kilos;       // Corresponds to OD_kilos

    // Default constructor
    public Detail() {
        this.serviceId = 0;
        this.catId = 0;
        this.orderId = 0;
        this.kilos = 0.0f;
    }

    // Parameterized constructor
    public Detail(int serviceId, int catId, int orderId, float kilos) {
        this.serviceId = serviceId;
        this.catId = catId;
        this.orderId = orderId;
        this.kilos = kilos;
    }

    // Getters and setters
    public int getServiceId() {
        return serviceId;
    }

    public void setServiceId(int serviceId) {
        this.serviceId = serviceId;
    }

    public int getCatId() {
        return catId;
    }

    public void setcatId(int catId) {
        this.catId = catId;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public float getKilos() {
        return kilos;
    }

    public void setKilos(float kilos) {
        this.kilos = kilos;
    }

}
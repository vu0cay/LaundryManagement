package com.mycompany.laundryapp;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author ADMIN
 */
public class Service {
   private int id;
    private String name;
    
    private float multiplier;
    
    public Service() {
        
    }
    public Service(int id, String name, float mul) {
        this.id = id;
        this.name = new String(name);
        this.multiplier = mul;

    }    
    
    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public Float getMultiplier() {
        return multiplier;
    }

}

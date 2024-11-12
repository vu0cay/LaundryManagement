/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.laundryapp;

/**
 *
 * @author DamHung
 */
public class Option {
    private int id;
    private String type;    
     public Option() {
        this.id = 0;
        this.type = new String(); 
    }
    public Option(int id, String type) {
        this.id = id;
        this.type = new String(type);
//        this.action = new String(action);
    }
    
    public int getId() {
        return id;
    }
    public String getType() {
        return type;
    }
}

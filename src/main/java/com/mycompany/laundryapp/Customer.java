/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.laundryapp;

/**
 *
 * @author DamHung
 */
public class Customer {
    private int id;
    private String name;
    private String phone;    
     public Customer() {
        this.id = 0;
        this.name = new String("");
        this.phone = new String(""); 
    }
    public Customer(int id, String name, String phone) {
        this.id = id;
        this.name = name;
        this.phone = new String(phone);
//        this.action = new String(action);
    }
    
    public String getPhone() {
        return this.phone;
    }
    public String getName() {
        return this.name;
    }
    public int getId() {
        return this.id;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
    public void setName(String name) {
        this.name = name;
    }
    
    public void setId(int id) {
        this.id = id;
    }
}

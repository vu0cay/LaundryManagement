/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.laundryapp;

/**
 *
 * @author ADMIN
 */
public class Item {
    private int id;
    private String type;
    private float unitPrice;
//    public Item() {
//        ITEM_id = 0;
//        ITEM_type = new String();
//        ITEM_unit_price = 0f;
//    }
    public Item() {
        
    }
    public Item(int id, String type, float pricePerUnit) {
        this.id = id;
        this.type = new String(type);
        this.unitPrice = pricePerUnit;
//        this.action = new String(action);
    }
//    public Item(Item item) {
//        this.ITEM_id = item.ITEM_id;
//        this.ITEM_type = new String(item.ITEM_type);
//        this.ITEM_unit_price = item.ITEM_unit_price;
//        
//    }
    
    public int getId() {
        return id;
    }
    public String getType() {
        return type;
    }
    public Float getUnitPrice() {
        return unitPrice;
    }

}

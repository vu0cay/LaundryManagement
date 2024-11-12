/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.laundryapp;

import javafx.beans.property.SimpleObjectProperty;
import javafx.scene.control.Button;

/**
 *
 * @author ADMIN
 */
public class Item {
    private int id;
    private String type;
    private float unitPrice;
//    private Button button;
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
//        this.button = new Button("Edit");

    }    
    
    public int getId() {
        return id;
    }
    public String getType() {
        return type;
    }
    public Float getUnitPrice() {
        return unitPrice;
    }
//    public void setButton(Button act) {
//        button = act;
//    }
//    public SimpleObjectProperty<Button> getButton() {
//        return new SimpleObjectProperty<>(button);
//    }

}

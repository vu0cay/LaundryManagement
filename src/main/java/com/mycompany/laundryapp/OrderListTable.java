
package com.mycompany.laundryapp;

import javafx.beans.property.*;
import java.sql.Date;

/**
 * This class represents a table row in the order list with observable properties.
 * These properties are used to bind the data to the table columns in JavaFX.
 */
public class OrderListTable {

    private final IntegerProperty id;
    private final StringProperty customer;
    private final StringProperty phone;
    private final ObjectProperty<Date> date;
    private final FloatProperty price;
    private final StringProperty status;

    public OrderListTable() {
        this.id = new SimpleIntegerProperty(0);  
        this.customer = new SimpleStringProperty(""); 
        this.phone = new SimpleStringProperty("");  
        this.date = new SimpleObjectProperty<>(null);  
        this.price = new SimpleFloatProperty(0.0f);  
        this.status = new SimpleStringProperty("");  
    }

    public OrderListTable(int id, String customer, String phone, Date date, float price, String status) {
        this.id = new SimpleIntegerProperty(id);
        this.customer = new SimpleStringProperty(customer);
        this.phone = new SimpleStringProperty(phone);
        this.date = new SimpleObjectProperty<>(date);
        this.price = new SimpleFloatProperty(price);
        this.status = new SimpleStringProperty(status);
    }


    public int getId() {
        return id.get();
    }

    public void setId(int id) {
        this.id.set(id);
    }

    public IntegerProperty idProperty() {
        return id;
    }

    public String getCustomer() {
        return customer.get();
    }

    public void setCustomer(String customer) {
        this.customer.set(customer);
    }

    public StringProperty customerProperty() {
        return customer;
    }

    public String getPhone() {
        return phone.get();
    }

    public void setPhone(String phone) {
        this.phone.set(phone);
    }

    public StringProperty phoneProperty() {
        return phone;
    }

    public Date getDate() {
        return date.get();
    }

    public void setDate(Date date) {
        this.date.set(date);
    }

    public ObjectProperty<Date> dateProperty() {
        return date;
    }

    public float getPrice() {
        return price.get();
    }

    public void setPrice(float price) {
        this.price.set(price);
    }

    public FloatProperty priceProperty() {
        return price;
    }

    public String getStatus() {
        return status.get();
    }

    public void setStatus(String status) {
        this.status.set(status);
    }

    public StringProperty statusProperty() {
        return status;
    }
}


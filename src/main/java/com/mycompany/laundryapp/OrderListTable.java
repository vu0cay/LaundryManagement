/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.laundryapp;

import java.sql.Date;

/**
 *
 * @author ADMIN
 */
public class OrderListTable {
    private Date date;
    String customer;
    String status;
    
    public OrderListTable(Date date, String customer, String status) {
        this.date = new Date(date.getYear(), date.getMonth(), date.getDay());
        this.customer = new String(customer);
        this.status = new String(status);
//        this.button = new Button("Edit");

    }    
    
    public Date getDate() {
        return date;
    }
    public String getCustomer() {
        return customer;
    }
    public String getStatus() {
        return status;
    }
}

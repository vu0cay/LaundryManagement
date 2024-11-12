/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.laundryapp.models;

/**
 *
 * @author ADMIN
 */
public class Staff {
    private String name;
    private String userName;
    private String phone;
    private String address;
    
    public Staff() {

        name = new String();
        userName = new String();
        phone = new String();
        address = new String();
    }
    public Staff(String name, String userName,
                String phone, String address) 
    {
//        this.id = 0;
        this.name = new String(name);
        this.userName = new String(userName);
        this.phone = new String(phone);
        this.address = new String(address);
    }
    public Staff(Staff staff) 
    {
        this.name = staff.name;
        this.userName = staff.userName;
        this.phone = staff.phone;
        this.address = staff.address;
    }
     
//    public int getId() {
//        return id;
//    }
    public String getName() {
        return name;
    }
    public String getUserName() {
        return userName;
    }
    public String getPhone() {
        return phone;
    }
    public String getAddress() {
        return address;
    }
    
}

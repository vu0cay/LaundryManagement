package com.mycompany.laundryapp.models;

public class Staff {
    private int id;  // Add the id attribute
    private String name;
    private String userName;
    private String phone;
    private String address;

    // Default constructor
    public Staff() {
        id = 0;  // Default value for id
        name = new String();
        userName = new String();
        phone = new String();
        address = new String();
    }

    // Constructor with parameters
    public Staff(int id, String name, String userName, String phone, String address) {
        this.id = id;  // Initialize id
        this.name = new String(name);
        this.userName = new String(userName);
        this.phone = new String(phone);
        this.address = new String(address);
    }

    // Copy constructor
    public Staff(Staff staff) {
        this.id = staff.id;  // Copy id
        this.name = staff.name;
        this.userName = staff.userName;
        this.phone = staff.phone;
        this.address = staff.address;
    }

    // Getter for id
    public int getId() {
        return id;
    }

    // Getter for name
    public String getName() {
        return name;
    }

    // Getter for userName
    public String getUserName() {
        return userName;
    }

    // Getter for phone
    public String getPhone() {
        return phone;
    }

    // Getter for address
    public String getAddress() {
        return address;
    }

    // Optional setter for id (if needed)
    public void setId(int id) {
        this.id = id;
    }
}

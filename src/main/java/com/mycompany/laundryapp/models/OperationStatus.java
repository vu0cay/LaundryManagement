/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.laundryapp.models;

/**
 *
 * @author ADMIN
 */
public class OperationStatus {
    private static int active = 1;
    private static int inactive = 2;
    
    public static Integer getActive() {
        return active;
    }
    public static void setActive(int act) {
        active = act;
    }
    
    public static Integer getInactive() {
        return inactive;
    }
    public static void setInactive(int inact) {
        inactive = inact;
    }
}

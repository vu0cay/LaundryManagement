/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.laundryapp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

//import java.sql.DriverManager;;
/**
 *
 * @author ADMIN
 */
public class database {
    private static String connectionUrl = "jdbc:sqlserver://localhost:1433;"
                    + "databaseName=LaundryServices;user=sa;password=root;"
                    + "encrypt=true;trustServerCertificate=true";
//    public static Connection con;
    public static Connection openConnection() {
        
        try {
            Connection con = DriverManager.getConnection(connectionUrl);
//            System.out.println("Connection successfully");
            return con;
        } catch (SQLException ex) {
            Logger.getLogger(database.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public static void closeConnection() {
//        try {
//            con.close();
//        } catch (SQLException ex) {
//            Logger.getLogger(database.class.getName()).log(Level.SEVERE, null, ex);
//        }
    }
}

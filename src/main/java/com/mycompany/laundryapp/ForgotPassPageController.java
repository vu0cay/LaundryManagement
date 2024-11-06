/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.laundryapp;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.Initializable;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author ADMIN
 */
public class ForgotPassPageController implements Initializable {

    
    
    @FXML
    private Button btnSubmit;

    @FXML
    private AnchorPane frm_forgotPass;

    @FXML
    private TextField txtConfirmPass;

    @FXML
    private TextField txtPassword;

    @FXML
    private TextField txtUserName;
    
    PreparedStatement pstmt;
    ResultSet res;
    Connection con;
    
    public void onClick_Submit() {
        con = database.openConnection();
        try {
            
            if(
               txtUserName.getText() == "" || 
               txtPassword.getText() == "" ||
               txtConfirmPass.getText() == "") {
                throw new SQLException("Please fill all fields!");
            }
            
            if(!txtPassword.getText().equals(txtConfirmPass.getText())) {
                throw new SQLException("Incorrect confirm password!");
            }
        
            
            String sql = "update staffs set SF_password = ? where SF_username = ?";
            
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, txtPassword.getText());
            pstmt.setString(2, txtUserName.getText());
            
            int rows = pstmt.executeUpdate();
            
            

//            alert.setTitle("Information");
            Alert alert = new Alert(Alert.AlertType.INFORMATION);

            if(rows > 0) {
                alert.setContentText("Password updated successfully!");
                alert.showAndWait();
                
                try {
                    App.setRoot("primary");
                } catch (IOException ex) {
                    Logger.getLogger(SignUpPageController.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            } else {
                alert.setContentText("No make change!");
                alert.showAndWait();
            }
                
            
            con.close();
        } catch (SQLException ex) {
            Alert alert = new Alert(Alert.AlertType.ERROR);

            alert.setContentText(ex.getMessage());
            alert.showAndWait();
        }
    }
     public void OnClick_LogIn() {
        try {
            App.setRoot("primary");
        } catch (IOException ex) {
            Logger.getLogger(SignUpPageController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}

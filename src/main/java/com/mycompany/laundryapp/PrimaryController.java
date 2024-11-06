package com.mycompany.laundryapp;

import java.io.Console;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DialogPane;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class PrimaryController {

    @FXML
    private Button btnLogin;

    @FXML
    private AnchorPane frm_main;

    @FXML
    private Label lblForgotPass;

    @FXML
    private Label lblSignUp;

    @FXML
    private TextField txtPassword;

    @FXML
    private TextField txtUserName;

    PreparedStatement pstmt;
    ResultSet res;
    Connection con;

    public void login() {

        String sql = "select SF_password from staffs where SF_username = ?";
        con = database.openConnection();

        try {

            if (txtUserName.getText() == "" || txtPassword.getText() == "") {
                throw new SQLException("Please fill all fields!");
            }

            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, txtUserName.getText());
            res = pstmt.executeQuery();

            if (res.next()) {
                if (res.getString("SF_password").equals(txtPassword.getText())) {
                    System.out.println("Login successfully");

                    try {
                        App.setRoot("HomePage");
                    } catch (IOException ex) {
                        Logger.getLogger(PrimaryController.class.getName()).log(Level.SEVERE, null, ex);
                    }

                } else {
                    throw new SQLException("Incorrect password");
                }
            } else {
                throw new SQLException("User name not found!");
            }

            con.close();
        } catch (SQLException ex) {
            Alert alert = new Alert(Alert.AlertType.ERROR);

            alert.setContentText(ex.getMessage());
            alert.showAndWait();
        }
    }

    public void signUp() {

        try {
            App.setRoot("SignUpPage");
        } catch (IOException ex) {
            Logger.getLogger(PrimaryController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void ForgotPassword() {
        try {
            App.setRoot("ForgotPassPage");
        } catch (IOException ex) {
            Logger.getLogger(PrimaryController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}

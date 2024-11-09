/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.laundryapp;

import com.mycompany.laundryapp.models.Staff;
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

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author ADMIN
 */
public class SignUpPageController implements Initializable {

    @FXML
    private Button btnSignUp;

    @FXML
    private AnchorPane frm_signUp;

    @FXML
    private TextField txtAddress;

    @FXML
    private TextField txtFullName;

    @FXML
    private TextField txtPassword;

    @FXML
    private TextField txtPhone;

    @FXML
    private TextField txtUserName;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    PreparedStatement pstmt;
    ResultSet res;
    Connection con;
    final private int laundryId = 1;
    public void OnClick_SignUp() {
        con = database.openConnection();
        try {

            if (txtFullName.getText() == ""
                    || txtUserName.getText() == ""
                    || txtPassword.getText() == ""
                    || txtPhone.getText() == ""
                    || txtAddress.getText() == "") {
                throw new SQLException("Please fill all fields!");
            }

            String sql = "select * from staffs where SF_username = ?";

            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, txtUserName.getText());
            res = pstmt.executeQuery();

            if (res.next()) {
                System.out.println(res.getString("SF_username"));
                throw new SQLException("User name have already used");
            }

            sql = "Insert into staffs (SF_name, SF_username, SF_password, SF_phone, SF_address, L_id) "
                    + "values(?, ?, ?, ?, ?, ?)";

            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, txtFullName.getText());
            pstmt.setString(2, txtUserName.getText());
            pstmt.setString(3, txtPassword.getText());
            pstmt.setString(4, txtPhone.getText());
            pstmt.setString(5, txtAddress.getText());
            pstmt.setInt(6, laundryId);
            int rows = pstmt.executeUpdate();

//            alert.setTitle("Information");
            Alert alert = new Alert(Alert.AlertType.INFORMATION);

            if (rows > 0) {
                alert.setContentText("Sign up successfully!");
                alert.showAndWait();
                Staff staff = new Staff(txtFullName.getText(),txtUserName.getText(),
                                        txtPhone.getText(),txtAddress.getText());
                btnSignUp.getScene().getWindow().hide();

                try {
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("Dashboard.fxml"));
//                        Parent root = FXMLLoader.load(getClass().getResource("Dashboard.fxml"));
                    Parent root = loader.load();
                    DashboardController dbController = loader.getController();

                    dbController.initData(staff);

                    Stage stage = new Stage();
                    Scene scene = new Scene(root, 1080, 800);

                    stage.setScene(scene);
                    stage.show();
                } catch (IOException ex) {
                    Logger.getLogger(SignUpPageController.class.getName()).log(Level.SEVERE, null, ex);
                }

            } else {
                alert.setContentText("No change maked!");
                alert.showAndWait();
            }

            con.close();
        } catch (SQLException ex) {
            Alert alert = new Alert(Alert.AlertType.ERROR);

            alert.setContentText(ex.getMessage());
            alert.showAndWait();
        }

    }

}

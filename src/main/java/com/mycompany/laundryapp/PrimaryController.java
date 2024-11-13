package com.mycompany.laundryapp;

import com.mycompany.laundryapp.models.Staff;
import java.io.Console;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DialogPane;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class PrimaryController implements Initializable{

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
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }
    public void login() {

        String sql = "select * from staffs where SF_username = ?";
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
                    
                    Staff staff = new Staff(res.getInt("SF_id"), res.getString("SF_name"), res.getString("SF_username"), 
                                            res.getString("SF_phone"), res.getString("SF_address"));
                    btnLogin.getScene().getWindow().hide();
                    
                    System.out.println(staff.getName()+ ", "+staff.getUserName()
                                        + ", "+ staff.getPhone()+ ", "+staff.getAddress());
                    try {
//                        Parent root = FXMLLoader.load(getClass().getResource("DashBoard.fxml"));
                        FXMLLoader loader = new FXMLLoader(getClass().getResource("DashBoard.fxml"));
                        Parent root = loader.load();
                        
                        DashboardController dashboard = loader.getController();
                        
                        dashboard.initData(staff);
                        
                        Stage stage = new Stage();
                        Scene scene = new Scene(root, 1080, 600);
                        
                        stage.setScene(scene);
                        stage.show();
//                        App.setRoot("Dashboard"); 
                        
                        
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

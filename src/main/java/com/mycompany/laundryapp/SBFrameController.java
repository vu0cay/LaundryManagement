/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.laundryapp;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;

import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

/**
 * FXML Controller class
 *
 * @author myngo
 */
public class SBFrameController implements Initializable {

    @FXML
    private BorderPane bp;
    @FXML
    private VBox ap;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    private void LoadPage(String page) {
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource(page + "fxml"));
        } catch (IOException ex) {
            Logger.getLogger(SBFrameController.class.getName()).log(Level.SEVERE, null, ex);
        }
        bp.setCenter(root);
    }

    @FXML
    private void OrderListPage(MouseEvent event) {
        bp.setCenter(ap);
    }

    @FXML
    private void NewOrderPage(MouseEvent event) {
        LoadPage("NewOder");
    }

    @FXML
    private void ServicesPage(MouseEvent event) {
        LoadPage("Services");
    }

    @FXML
    private void StatisticsPage(MouseEvent event) {
        LoadPage("Statistics");
    }

    @FXML
    private void AccountPage(MouseEvent event) {
        LoadPage("Account");
    }

    @FXML
    private void AboutUsPage(MouseEvent event) {
        LoadPage("AboutUs");
    }

}

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
import java.sql.Statement;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
//import javafx.collections.ObservableListBase;
//import javafx.collections.ObservableListBase;
//import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author myngo
 */
public class DashboardController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    private AnchorPane ItemsManage;

    @FXML
    private Button aboutUsBtn;

    @FXML
    private AnchorPane aboutUsForm;

    @FXML
    private Button itemManageBtn;
    @FXML
    private Label lblUserName;
    @FXML
    private Button newOrderBtn;

    @FXML
    private AnchorPane newOrderForm;

    @FXML
    private Button orderListBtn;

    @FXML
    private AnchorPane orderListForm;

    @FXML
    private Button serviceManageBtn;

    @FXML
    private Button servicesBtn;

    @FXML
    private AnchorPane servicesForm;

    @FXML
    private AnchorPane servicesManage;

    @FXML
    private Button statisticsBtn;

    @FXML
    private AnchorPane statisticsForm;
    @FXML
    private Label lblAddress;

    @FXML
    private Label lblContact;

    @FXML
    private Label lblShopName;
    @FXML
    private Label lblAUStaffAddress;

    @FXML
    private Label lblAUStaffname;

    @FXML
    private Label lblAUStaffphone;
    @FXML
    private Label lblLogout;
    @FXML
    private TextField txtServiceMultiplier;

    @FXML
    private TextField txtServiceName;
    
    @FXML
    private Button btnServiceSave;
    @FXML
    private Button btnServiceItemSave;
    @FXML
    private TextField txtServiceItemName;

    @FXML
    private TextField txtServiceItemUnitPrice;
    
    @FXML
    private TableView<Item> tavItem;
//    @FXML
//    private TableColumn<Item, String> tabcoItemAction;

    @FXML
    private TableColumn<Item, Number> tabcoItemId;
    @FXML
    private TableColumn<Item, String> tabcoItemName;
    @FXML
    private TableColumn<Item, Number> tabcoItemPrice;
    

    Connection con;
    ResultSet res;
    PreparedStatement pstmt;
    Statement stmt;
    
    Staff staff;
    
    
    public ObservableList<Item> serviceItemListData() {
        
        con = database.openConnection();
        String sql = "select * from items";
        ObservableList<Item> data = FXCollections.observableArrayList();

        try {
            stmt = con.createStatement();
            res = stmt.executeQuery(sql);
            
//            data.add(new Item(1,"cloth", 2.5));
//            data.add(new Item(2,"coat", 3.0));
            while(res.next()) {
                Item item = new Item(res.getInt("ITEM_id"), res.getString("ITEM_type"), res.getFloat("ITEM_unit_price"));
//                System.out.println(item.getId() +", "+ item.getType() +", "+ item.getPricePerUnit()+", "+ "action");
                data.add(item);
            }
//            System.out.println(data.size());

                       
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(DashboardController.class.getName()).log(Level.SEVERE, null, ex);
        }        
        return data;
    }
    
    private ObservableList<Item> addServiceItemData;
    public void SetUpServiceTableView() {
        
        addServiceItemData = serviceItemListData();
        
//        tabcoItemId.setCellValueFactory(f -> new SimpleIntegerProperty(f.getValue().getId()));
//        tabcoItemName.setCellValueFactory(f -> new SimpleStringProperty(f.getValue().getType()));
//        tabcoItemPrice.setCellValueFactory(f -> new SimpleDoubleProperty(f.getValue().getUnitPrice()));
        tabcoItemId.setCellValueFactory(new PropertyValueFactory<>("id"));
        tabcoItemName.setCellValueFactory(new PropertyValueFactory<>("type"));
        tabcoItemPrice.setCellValueFactory(new PropertyValueFactory<>("unitPrice"));
        
        tavItem.setItems(addServiceItemData);
            
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        SetUpServiceTableView();

        //
//        lblAUStaffname.setText(staff.getName());
//        lblAUStaffAddress.setText(staff.getAddress());
//        lblAUStaffphone.setText(staff.getPhone());
        //
        
        con = database.openConnection();
        
        String sql = "select * from LAUNDRYSHOPS";
        
        try {
            
            stmt = con.createStatement();
            res = stmt.executeQuery(sql);
            
            if(res.next()) {
                lblShopName.setText(res.getString("L_name"));
                lblContact.setText(res.getString("L_phone"));
                lblAddress.setText(res.getString("L_address"));
            }
            
            con.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(DashboardController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
       

        // TODO
        //Stage stage = (Stage) .getScene().getWindow();
    }
    
    
    public void initData(Staff st) {
        
        this.staff = new Staff(st);
        lblUserName.setText(staff.getName());
        lblAUStaffphone.setText(staff.getPhone());
        lblAUStaffAddress.setText(staff.getAddress());
        
    }
    public void switchManageCategory(ActionEvent e) {
        if (e.getSource() == serviceManageBtn) {
            servicesManage.setVisible(true);
            ItemsManage.setVisible(false);
        } else {
            servicesManage.setVisible(false);
            ItemsManage.setVisible(true);
        }
    }

    public void switchForm(ActionEvent event) {
        if (event.getSource() == orderListBtn) {
            orderListBtn.getStyleClass().add("tab-active");
            newOrderBtn.getStyleClass().remove("tab-active");
            servicesBtn.getStyleClass().remove("tab-active");
            statisticsBtn.getStyleClass().remove("tab-active");
            aboutUsBtn.getStyleClass().remove("tab-active");
                    
            orderListForm.setVisible(true);
            newOrderForm.setVisible(false);
            servicesForm.setVisible(false);
            statisticsForm.setVisible(false);
            aboutUsForm.setVisible(false);
        } else if (event.getSource() == newOrderBtn) {
            orderListBtn.getStyleClass().remove("tab-active");
            newOrderBtn.getStyleClass().add("tab-active");
            servicesBtn.getStyleClass().remove("tab-active");
            statisticsBtn.getStyleClass().remove("tab-active");
            aboutUsBtn.getStyleClass().remove("tab-active");
            
            orderListForm.setVisible(false);
            newOrderForm.setVisible(true);
            servicesForm.setVisible(false);
            statisticsForm.setVisible(false);
            aboutUsForm.setVisible(false);
        } else if (event.getSource() == servicesBtn) {
            orderListBtn.getStyleClass().remove("tab-active");
            newOrderBtn.getStyleClass().remove("tab-active");
            servicesBtn.getStyleClass().add("tab-active");
            statisticsBtn.getStyleClass().remove("tab-active");
            aboutUsBtn.getStyleClass().remove("tab-active");
            
            orderListForm.setVisible(false);
            newOrderForm.setVisible(false);
            servicesForm.setVisible(true);
            statisticsForm.setVisible(false);
            aboutUsForm.setVisible(false);
        } else if (event.getSource() == statisticsBtn) {
            orderListBtn.getStyleClass().remove("tab-active");
            newOrderBtn.getStyleClass().remove("tab-active");
            servicesBtn.getStyleClass().remove("tab-active");
            statisticsBtn.getStyleClass().add("tab-active");
            aboutUsBtn.getStyleClass().remove("tab-active");
            
            orderListForm.setVisible(false);
            newOrderForm.setVisible(false);
            servicesForm.setVisible(false);
            statisticsForm.setVisible(true);
            aboutUsForm.setVisible(false);
        } else {
            orderListBtn.getStyleClass().remove("tab-active");
            newOrderBtn.getStyleClass().remove("tab-active");
            servicesBtn.getStyleClass().remove("tab-active");
            statisticsBtn.getStyleClass().remove("tab-active");
            aboutUsBtn.getStyleClass().add("tab-active");
            
            orderListForm.setVisible(false);
            newOrderForm.setVisible(false);
            servicesForm.setVisible(false);
            statisticsForm.setVisible(false);
            aboutUsForm.setVisible(true);
        
            
        }
    }
    
    public void OnClick_Logout() {
        lblUserName.getScene().getWindow().hide();
        
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("primary.fxml"));
            Parent root;
            root = loader.load();
//            DashboardController dashboard = loader.getController();

//            dashboard.initData(staff);

            Stage stage = new Stage();
            Scene scene = new Scene(root, 600, 400);

            stage.setScene(scene);
            stage.show();
            
        } catch (IOException ex) {
            Logger.getLogger(DashboardController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
    public void OnClick_ServiceSave() {
        con = database.openConnection();
        String sql = "INSERT INTO LAUNDRY_SERVICES (LS_name, LS_multiplier) VALUES (?,?)";
        
        try {
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, txtServiceName.getText());
            pstmt.setString(2, txtServiceMultiplier.getText());
            
            int rows = pstmt.executeUpdate();
            
            if(rows > 0){
                System.out.println("Insert service successfully!");
                txtServiceName.setText("");
                txtServiceMultiplier.setText("");
            }
            
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(DashboardController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void OnClick_ServiceCancel() {
        txtServiceName.setText("");
        txtServiceMultiplier.setText("");
    }
    public void OnClick_ServiceItemSave() {
        con = database.openConnection();
        String sql = "INSERT INTO ITEMS (ITEM_type, ITEM_unit_price) VALUES (?,?)";
        
        try {
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, txtServiceItemName.getText());
            pstmt.setString(2, txtServiceItemUnitPrice.getText());
            
            int rows = pstmt.executeUpdate();
            
            if(rows > 0) {
                System.out.println("Insert item successfully!");
                txtServiceItemName.setText("");
                txtServiceItemUnitPrice.setText("");
            }
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(DashboardController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        SetUpServiceTableView();
    }
    public void OnClick_ServiceItemCancel() {
        txtServiceItemName.setText("");
        txtServiceItemUnitPrice.setText("");

    }

}

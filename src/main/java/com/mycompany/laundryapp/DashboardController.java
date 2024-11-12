/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this templat
 */
package com.mycompany.laundryapp;

//import com.mycompany.laundryapp.models.Item;
//import com.mycompany.laundryapp.models.Staff;
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
import javafx.beans.value.ChangeListener;
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
import javafx.scene.chart.PieChart;

import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DialogPane;
import javafx.scene.control.Label;
import javafx.scene.control.TableCell;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.Spinner;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.collections.FXCollections;
import javafx.scene.control.ComboBox;
import javafx.scene.shape.Circle;
import javafx.util.Callback;

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
    private ComboBox<String> resultCombobox;

    @FXML
    private AnchorPane ItemsManage;

    @FXML
    private Button aboutUsBtn;

    @FXML
    private AnchorPane aboutUsForm;

    @FXML
    private Circle circleDraw;

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
    private AnchorPane pieArea;

    @FXML
    private PieChart piePie;

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
//    private ComboBox<?> cbxState;
    @FXML
    private DialogPane dipAction;
    
    @FXML
    private Button btnDialCancel;

    @FXML
    private Button btnDialSave;
    
    @FXML
    private TextField txtDialType;

    @FXML
    private TextField txtDialUnitPrice;
    

//    @FXML
//    private TableColumn<Item, String> tabcoItemAction;

    @FXML
    private TableColumn<Item, Number> tabcoItemId;
    @FXML
    private TableColumn<Item, String> tabcoItemName;
    @FXML
    private TableColumn<Item, Number> tabcoItemPrice;
    @FXML
    private TableColumn<Item, Void> tabcoAction;

    

        
   
    //Service components
     @FXML
    private AnchorPane NO_AddDetail_pane;

    @FXML
    private Button NO_Add_btn;

    @FXML
    private Button NO_Cancel_btn1;

    @FXML
    private ComboBox<Option> NO_Category_add;

    @FXML
    private Button NO_CreateCus_btn;

    @FXML
    private Button NO_CreateNewOder_btn;

    @FXML
    private TextField NO_CustomerName_txt;

    @FXML
    private TextField NO_Customer_Search_txt;

    @FXML
    private TableView<?> NO_Detail_table;

    @FXML
    private TextField NO_Phone_txt;

    @FXML
    private Button NO_Save_btn1;

    @FXML
    private ComboBox<Option> NO_Service_add;

    @FXML
    private TextField NO_Weight_add;

    @FXML
    private TableColumn<?, ?> NO_table_Category_col;

    @FXML
    private TableColumn<?, ?> NO_table_PricePerKilo_col;

    @FXML
    private TableColumn<?, ?> NO_table_ServiceMulti_col;

    @FXML
    private TableColumn<?, ?> NO_table_Service_col;

    @FXML
    private TableColumn<?, ?> NO_table_Total_col;

    @FXML
    private TableColumn<?, ?> NO_table_Weight_col;
    
      //====================================================================================================================================================  
  //init datas for the app
   /* public void initComponents(){
        NO_Service_add.setCellFactory(lv -> new ListCell<Option>() {
            @Override
            protected void updateItem(Option item, boolean empty) {
                super.updateItem(item, empty);
                setText(empty ? null : item.getType());
            }
        });
        NO_Service_add.setButtonCell(new ListCell<Option>() {
            @Override
            protected void updateItem(Option item, boolean empty) {
                super.updateItem(item, empty);
                setText(empty ? null : item.getType());  
            }
        });
        
        NO_Category_add.setCellFactory(lv -> new ListCell<Option>() {
            @Override
            protected void updateItem(Option item, boolean empty) {
                super.updateItem(item, empty);
                setText(empty ? null : item.getType());
            }
        });
        NO_Category_add.setButtonCell(new ListCell<Option>() {
            @Override
            protected void updateItem(Option item, boolean empty) {
                super.updateItem(item, empty);
                setText(empty ? null : item.getType());  
            }
        });
        
        NO_Weight_add.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue.matches("\\d*(\\.\\d*)?")) {
                NO_Weight_add.setText(oldValue); // Allows decimal numbers
            }
        });
        
    }*/
    
    
        
  //====================================================================================================================================================  
  //init datas for the app
    
    Connection con;
    ResultSet res;
    PreparedStatement pstmt;
    Statement stmt;
    
    Staff staff;
    Item currentItem;
    
//    public void setLoadComboBoxDialogState() {
//        cbxState.setItems(FXCollections.observableArrayList("Paid", "Complete", "Processing"));
//    }
    
    //about us
    public void aboutUs(){
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
    }
    
    //setting up data for New Order
    public ObservableList<Option> GetServices(){
        con = database.openConnection();
        String sql = "select * from LAUNDRY_SERVICES";
        ObservableList<Option> data = FXCollections.observableArrayList();
        
        try {
            stmt = con.createStatement();
            res = stmt.executeQuery(sql);            
//            data.add(new Item(1,"cloth", 2.5));
//            data.add(new Item(2,"coat", 3.0));
            while(res.next()) {
                Option option = new Option(res.getInt("LS_id"), res.getString("LS_name"));
                data.add(option);
            }
//            System.out.println(data.size());                  
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(DashboardController.class.getName()).log(Level.SEVERE, null, ex);
        } 
        return data;
    }
   

    public ObservableList<Option> GetCategory(){
        con = database.openConnection();
        String sql = "select * from ITEMS";
        ObservableList<Option> data = FXCollections.observableArrayList();
        
        try {
            stmt = con.createStatement();
            res = stmt.executeQuery(sql);            
//            data.add(new Item(1,"cloth", 2.5));
//            data.add(new Item(2,"coat", 3.0));
            while(res.next()) {
                Option option = new Option(res.getInt("ITEM_id"), res.getString("ITEM_type"));
                data.add(option);
            }
//            System.out.println(data.size());                  
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(DashboardController.class.getName()).log(Level.SEVERE, null, ex);
        } 
        return data;
    }
    
    
    public void SetUpNewOrder() {
        NO_Service_add.setItems(GetServices());
        NO_Category_add.setItems(GetCategory());
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        //initComponents();
        SetUpServiceTableView();
        SetUpNewOrder();
        aboutUs();
        //
//        lblAUStaffname.setText(staff.getName());
//        lblAUStaffAddress.setText(staff.getAddress());
//        lblAUStaffphone.setText(staff.getPhone());
        //

        // TODO
        //Stage stage = (Stage) .getScene().getWindow();
    }
    
    
    public void initData(Staff st) {
        
        this.staff = new Staff(st);
        lblUserName.setText(staff.getName());
        lblAUStaffphone.setText(staff.getPhone());
        lblAUStaffAddress.setText(staff.getAddress());
        
    }
    
        
  //====================================================================================================================================================  
  //Navigation tab bar switching
     
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
            circleDraw.setVisible(false);
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
            circleDraw.setVisible(false);

        } else if (event.getSource() == servicesBtn) {
            orderListBtn.getStyleClass().remove("tab-active");
            newOrderBtn.getStyleClass().remove("tab-active");
            servicesBtn.getStyleClass().add("tab-active");
            statisticsBtn.getStyleClass().remove("tab-active");
            aboutUsBtn.getStyleClass().remove("tab-active");

            circleDraw.setVisible(false);
            orderListForm.setVisible(false);
            newOrderForm.setVisible(false);
            servicesForm.setVisible(true);
            statisticsForm.setVisible(false);
            aboutUsForm.setVisible(false);

        } else if (event.getSource() == statisticsBtn) {
            ObservableList<PieChart.Data> pieChartData
                    = FXCollections.observableArrayList(
                            new PieChart.Data("Paid", 13),
                            new PieChart.Data("Completed", 25),
                            new PieChart.Data("Processing", 10));

            piePie.setData(pieChartData);

            
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
            circleDraw.setVisible(true);

        } else {
            orderListBtn.getStyleClass().remove("tab-active");
            newOrderBtn.getStyleClass().remove("tab-active");
            servicesBtn.getStyleClass().remove("tab-active");
            statisticsBtn.getStyleClass().remove("tab-active");
            aboutUsBtn.getStyleClass().add("tab-active");

            circleDraw.setVisible(false);
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
    
    
  //====================================================================================================================================================  
  //Order List functions
    
    
  //====================================================================================================================================================  
  //New Order functions
    
    public void OnClick_NO_Cancel_btn() {
        System.out.println("Cancel Clicked");
    }
    
    public void OnClick_NO_Add_btn() {
        System.out.println("Add Clicked");
        System.out.println(Float.parseFloat(NO_Weight_add.getText()));
    }
    
    public void OnClick_NO_Create_Order_btn() {
        NO_AddDetail_pane.setVisible(true);
    }
    
    
  //====================================================================================================================================================  
  //services functions
        public ObservableList<Item> serviceItemListData() {
        
        con = database.openConnection();
        String sql = "select * from items";
        ObservableList<Item> data = FXCollections.observableArrayList();

        try {
            stmt = con.createStatement();
            res = stmt.executeQuery(sql);
            
            while(res.next()) {
                Item item = new Item(res.getInt("ITEM_id"), res.getString("ITEM_type"), res.getFloat("ITEM_unit_price"));

                data.add(item);
            }
            
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(DashboardController.class.getName()).log(Level.SEVERE, null, ex);
        }        
        return data;
    }
    
    private ObservableList<Item> addServiceItemData;
    public void SetUpServiceTableView() {
        
        addServiceItemData = serviceItemListData();
        
        tabcoItemId.setCellValueFactory(new PropertyValueFactory<>("id"));
        tabcoItemName.setCellValueFactory(new PropertyValueFactory<>("type"));
        tabcoItemPrice.setCellValueFactory(new PropertyValueFactory<>("unitPrice"));
//        tabcoAction.setCellValueFactory(data -> data.getValue().getButton());
        
        Callback<TableColumn<Item, Void>, TableCell<Item, Void>> cellFactory = new Callback<>() {
            @Override
            public TableCell<Item, Void> call(TableColumn<Item, Void> param) {
                return new TableCell<>() {
                    private final Button btn = new Button("Edit");
                    {
                        btn.setOnMouseClicked(event -> {
                            Item items = getTableView().getItems().get(getIndex());
                            System.out.println("Button clicked for " + items.getId());
                            
                            // set dialog edit
                            currentItem = new Item(items.getId(), items.getType(), items.getUnitPrice());
                            
                            txtDialType.setText(items.getType());
                            txtDialUnitPrice.setText(Double.toString(items.getUnitPrice()));
                            dipAction.setVisible(true);
                            
                            
                            
                        });
                    }
                    
                    @Override
                    protected void updateItem(Void item, boolean empty) {
                        super.updateItem(item, empty);
                        if (empty) {
                            setGraphic(null);
                        } else {
                            setGraphic(btn);
                        }
                    }
                };
            }  
        };
        
        tabcoAction.setCellFactory(cellFactory);
        
        
        tavItem.setItems(addServiceItemData);
            
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
    public void OnClick_DiaglogCancel() {
        dipAction.setVisible(false);

    }
    public void OnClick_DiaglogSave() {
        System.out.println("Save");
        con = database.openConnection();
        
        try {
            
            String sql = "UPDATE ITEMS SET ITEM_type = ?, ITEM_unit_price = ? WHERE ITEM_id = ?";
            
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, txtDialType.getText());
            pstmt.setDouble(2, Double.parseDouble(txtDialUnitPrice.getText()));
            pstmt.setInt(3, currentItem.getId());
            
            int rows = pstmt.executeUpdate();
            
            if(rows > 0) {
                System.out.println("Update item "+currentItem.getId()+" successfully!");
                SetUpServiceTableView();
                dipAction.setVisible(false);

            }
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(DashboardController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void OnClick_DiaglogDelete() {
        System.out.println("Delete");
        con = database.openConnection();
        
        try {
            
            String sql = "DELETE FROM ITEMS WHERE ITEM_id = ?";
            
            pstmt = con.prepareStatement(sql);
            
            pstmt.setInt(1, currentItem.getId());
            
            int rows = pstmt.executeUpdate();
            
            if(rows > 0) {
                System.out.println("Delete item "+currentItem.getId()+" successfully!");
                SetUpServiceTableView();
                dipAction.setVisible(false);
            }
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(DashboardController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
        

  //====================================================================================================================================================  
  //Statistics functions
    

  //====================================================================================================================================================  
  //Statistics functions
    
  
  //====================================================================================================================================================  

}   

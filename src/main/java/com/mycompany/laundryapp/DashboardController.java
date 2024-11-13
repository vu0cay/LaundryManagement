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
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.HashSet;
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
import javafx.scene.control.Alert;
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

    

        
   
    //New Order components
    @FXML
    private AnchorPane NO_AddDetail_pane;

    @FXML
    private Button NO_Add_btn;

    @FXML
    private Button NO_Cancel_btn;

    @FXML
    private ComboBox<Option> NO_Category_add;
    
    @FXML
    private Button NO_CustomerSearch_btn;

    @FXML
    private Button NO_CreateCus_btn;
    
    @FXML
    private DialogPane NO_CreateCus_pane;
    
    @FXML
    private Button NO_CreateCus_cancel_btn;

    @FXML
    private Button NO_CreateCus_create_btn;

    @FXML
    private TextField NO_CreateCus_name_txt;

    @FXML
    private TextField NO_CreateCus_phone_txt;

    @FXML
    private Label NO_CreateOrderHint_lbl;
    @FXML
    private Button NO_CreateNewOder_btn;

    @FXML
    private TextField NO_CustomerName_txt;

    @FXML
    private TextField NO_Customer_Search_txt;

    @FXML
    private TableView<NO_Detail> NO_Detail_table;

    @FXML
    private TextField NO_Phone_txt;
    
    @FXML
    private Label NO_Order_id;

    @FXML
    private Button NO_Save_btn;

    @FXML
    private ComboBox<Option> NO_Service_add;

    @FXML
    private TextField NO_Weight_add;

    @FXML
    private TableColumn<NO_Detail, String> NO_table_Category_col;

    @FXML
    private TableColumn<NO_Detail, Float> NO_table_PricePerKilo_col;

    @FXML
    private TableColumn<NO_Detail, Float> NO_table_ServiceMulti_col;

    @FXML
    private TableColumn<NO_Detail, String> NO_table_Service_col;

    @FXML
    private TableColumn<NO_Detail, Float> NO_table_Total_col;

    @FXML
    private TableColumn<NO_Detail, Float> NO_table_Weight_col;
       
    
        
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
    
    
    

    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        initComponents_NO();
        SetUpServiceTableView();
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
    //----------
    //init components
    public void initComponents_NO(){
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
        
        NO_CreateCus_phone_txt.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue.matches("\\d*")) {
                NO_CreateCus_phone_txt.setText(newValue.replaceAll("[^\\d]", "")); // Allow only digits
            }
        });
        
        NO_Customer_Search_txt.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue.matches("\\d*")) {
                NO_Customer_Search_txt.setText(newValue.replaceAll("[^\\d]", "")); // Allow only digits
            }
        });
        NO_Service_add.setItems(GetServices());
        NO_Category_add.setItems(GetCategory());
        
        NO_table_Category_col.setCellValueFactory(new PropertyValueFactory<>("category"));

        // Weight column: Float type
        NO_table_Weight_col.setCellValueFactory(new PropertyValueFactory<>("weight"));

        // Service column: String type
        NO_table_Service_col.setCellValueFactory(new PropertyValueFactory<>("service"));

        // PricePerKilo column: Float type
        NO_table_PricePerKilo_col.setCellValueFactory(new PropertyValueFactory<>("pricePerKilo"));

        // ServiceMultiplier column: Float type
        NO_table_ServiceMulti_col.setCellValueFactory(new PropertyValueFactory<>("serviceMultiplier"));

        // Total column: Float type
        NO_table_Total_col.setCellValueFactory(new PropertyValueFactory<>("total"));
        
    }
    
    //----------
    //database connect
     public ObservableList<Option> GetServices(){
        con = database.openConnection();
        String sql = "select * from LAUNDRY_SERVICES";
        ObservableList<Option> data = FXCollections.observableArrayList();
        
        try {
            stmt = con.createStatement();
            res = stmt.executeQuery(sql);            
            while(res.next()) {
                Option option = new Option(res.getInt("LS_id"), res.getString("LS_name"));
                data.add(option);
            }              
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
            while(res.next()) {
                Option option = new Option(res.getInt("ITEM_id"), res.getString("ITEM_type"));
                data.add(option);
            }                
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(DashboardController.class.getName()).log(Level.SEVERE, null, ex);
        } 
        return data;
    }
    
    public Customer CustomerSearch(String phone){
        
        Customer result = new Customer();
        con = database.openConnection();
        String sql = "select * from Customers where CUS_phone = ?";
        
        try {
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, phone);
            res = pstmt.executeQuery();            
            if (res.next()){
                result.setId(res.getInt("CUS_id"));           
                result.setName(res.getString("CUS_name"));
                result.setPhone(res.getString("CUS_phone"));
            }                  
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(DashboardController.class.getName()).log(Level.SEVERE, null, ex);
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText(ex.getMessage());
            alert.showAndWait();
        } 
        return result;
    }
    
    public boolean CreateCustomer(Customer cus){
        con = database.openConnection();
        String sql = "insert into customers (CUS_name, CUS_phone) values (?, ?);";
        try {
                pstmt = con.prepareStatement(sql);
                pstmt.setString(1, cus.getName());
                pstmt.setString(2, cus.getPhone());
                pstmt.executeUpdate();                     
                con.close();
                return true;
        } catch (SQLException ex) {
            Logger.getLogger(DashboardController.class.getName()).log(Level.SEVERE, null, ex);
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText(ex.getMessage());
            alert.showAndWait();
            return false;
        } 
    }
    
    public int CreateOrder(String phone) {
        int orderId = -1;
        LocalDate currentDate = LocalDate.now();
        Date sqlDate = Date.valueOf(currentDate);
        int cusId = CustomerSearch(phone).getId();
        con = database.openConnection();
        String sql = "insert into ORDERS (CUS_id, ORDER_order_date, ORDER_pickup_date, ORDER_total_price) values (?, ?, ?, ?);";
        try {
            pstmt = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            pstmt.setInt(1, cusId);
            pstmt.setDate(2, sqlDate);
            pstmt.setDate(3, sqlDate);
            pstmt.setFloat(4, 0);
            pstmt.executeUpdate();    
            
            ResultSet generatedKeys = pstmt.getGeneratedKeys();
            if (generatedKeys.next()) {
                orderId = generatedKeys.getInt(1); 
            }

            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(DashboardController.class.getName()).log(Level.SEVERE, null, ex);
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText(ex.getMessage());
            alert.showAndWait();
        }
        return orderId;
    }
    
    public float GetPPK(int catId){
        float ppk = 0;
        con = database.openConnection();
        String sql = "select * from ITEMS where ITEM_id = ?";
        try {
            pstmt = con.prepareStatement(sql);
            pstmt.setInt(1, catId);
            res = pstmt.executeQuery();            
            ppk = res.getFloat("ITEM_unit_price");
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(DashboardController.class.getName()).log(Level.SEVERE, null, ex);
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText(ex.getMessage());
            alert.showAndWait();
        } 
        return ppk;
    }
    public float GetSMultiplier(int SId){
        float multiplier = 0;
        con = database.openConnection();
        String sql = "select * from LAUNDRY_SERVICES where LS_id = ?";
        try {
            pstmt = con.prepareStatement(sql);
            pstmt.setInt(1, SId);
            res = pstmt.executeQuery();            
            multiplier = res.getFloat("LS_multiplier");
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(DashboardController.class.getName()).log(Level.SEVERE, null, ex);
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText(ex.getMessage());
            alert.showAndWait();
        } 
        return multiplier;
    }
    //----------
    //in-app stuff
    public void OnClick_NO_CustomerSearch_btn(){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);   
        alert.setHeaderText(null);
        String phone = new String(NO_Customer_Search_txt.getText());
        Customer result = CustomerSearch(phone);
        if(result.getName().equals("")) {
            alert.setTitle("warning");
            alert.setContentText("Customer don't exist");
            alert.showAndWait();
        }
        else{
            alert.setTitle("success");
            alert.setContentText("Customer found with name " + result.getName());
            alert.showAndWait();
            NO_CustomerName_txt.setText(result.getName());
            NO_Phone_txt.setText(result.getPhone());
            NO_CreateNewOder_btn.setDisable(false);
        }
    }
    
    //create customer
    public void OnClick_NO_CreateCus_btn(){
        NO_CreateCus_pane.setVisible(true);
    }
    
    public void OnClick_NO_CreateCus_create_btn(){
        Alert alert = new Alert(Alert.AlertType.INFORMATION); 
        alert.setHeaderText(null);
        if(NO_CreateCus_name_txt.getText() == "" || NO_CreateCus_phone_txt.getText() == "") {
            alert.setTitle("waring");
            alert.setContentText("please fill all the fields");
            alert.showAndWait();
            return;
        }
        Customer cus = new Customer(0, NO_CreateCus_name_txt.getText(), NO_CreateCus_phone_txt.getText());
        if(!CustomerSearch(cus.getPhone()).getPhone().equals("")) {
            alert.setTitle("waring");
            alert.setContentText("Customer already exist");
            alert.showAndWait();
            return;
        }
        if(CreateCustomer(cus)){
            alert.setTitle("Success");
            alert.setContentText("New customer created");
            alert.showAndWait();
            NO_CreateCus_pane.setVisible(false);
            NO_Customer_Search_txt.setText(cus.getPhone());
            OnClick_NO_CustomerSearch_btn();
        }else{
            alert.setTitle("warning");
            alert.setContentText("something went wrong when creating!");
            alert.showAndWait();
        }
    }
    
    public void OnClick_NO_CreateCus_cancel_btn(){
        NO_CreateCus_name_txt.setText("");
        NO_CreateCus_phone_txt.setText("");
        NO_CreateCus_pane.setVisible(false);
    }
    
    
    //create order
    public void OnClick_NO_Create_Order_btn() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION); 
        alert.setHeaderText(null);
        int orderId = CreateOrder(NO_Phone_txt.getText());
        if(orderId == -1){
            alert.setTitle("error");
            alert.setContentText("something went wrong while creating order!");
            alert.showAndWait();
            return;
        }
        initComponents_NO();
        NO_Order_id.setText(String.valueOf(orderId));
            alert.setTitle("success");
            alert.setContentText("new order created with ID: " + NO_Order_id.getText());
            alert.showAndWait();
        NO_CreateOrderHint_lbl.setVisible(false);
        NO_CreateNewOder_btn.setDisable(true);
        NO_CreateNewOder_btn.setVisible(false);
        NO_AddDetail_pane.setVisible(true);
    }
    
    //TO DO add detail
    public void OnClick_NO_Add_btn() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION); 
        alert.setHeaderText(null);
        if(NO_Weight_add.getText().equals("") || NO_Service_add.getValue() == null || NO_Service_add.getValue() == null){
            alert.setTitle("warning");
            alert.setContentText("please fill all the fields");
            alert.showAndWait();
            return;
        }
        NO_Detail noDetail = new NO_Detail(NO_Service_add.getValue().getType(), 
                                           Float.parseFloat(NO_Weight_add.getText()), 
                                           NO_Service_add.getValue().getType(), 
                                           GetPPK(NO_Category_add.getSelectionModel().getSelectedItem().getId()),
                                           GetSMultiplier(NO_Service_add.getSelectionModel().getSelectedItem().getId()));
        Option selectedOption = NO_Service_add.getSelectionModel().getSelectedItem();
        System.out.println("Add Clicked");
        System.out.println(Float.parseFloat(NO_Weight_add.getText()));
    }
    
    //TODO
    public void OnClick_NO_Save_btn(){
        
    }
    
    //TODO
    public void OnClick_NO_Cancel_btn() {
        System.out.println("Cancel Clicked");
        NO_Order_id.setText("-1");
        NO_CreateOrderHint_lbl.setVisible(true);
        NO_CreateNewOder_btn.setDisable(true);
        NO_CreateNewOder_btn.setVisible(true);
        NO_AddDetail_pane.setVisible(false);
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

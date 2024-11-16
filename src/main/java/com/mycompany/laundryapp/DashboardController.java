/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this templat
 */
package com.mycompany.laundryapp;

import java.util.Locale;
//import java.util.ResourceBundle;

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
import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.ResourceBundle;
import java.util.Set;
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
import javafx.scene.text.Text;
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
    private Label lblContactMail;

    @FXML
    private Label lblShopName;
//    @FXML
//    private Label lblAUStaffAddress;

    @FXML
    private Label lblAUStaffname;

//    @FXML
//    private Label lblAUStaffphone;
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

    //Orderlist components
    @FXML
    private ComboBox<Integer> rmenuOrderListRows;

    @FXML
    private TextField txtOrderListSearch;

    @FXML
    private Button btnOrderListRefresh;

    @FXML
    private TableView<OrderListTable> tavOrderList;

    @FXML
    private TableColumn<OrderListTable, Void> tabcoOrderListAction;

    @FXML
    private TableColumn<OrderListTable, String> tabcoOrderListCustomer;

    @FXML
    private TableColumn<OrderListTable, Date> tabcoOrderListDate;

    @FXML
    private TableColumn<OrderListTable, Integer> tabcoOrderListId;

    @FXML
    private TableColumn<OrderListTable, String> tabcoOrderListPhone;

    @FXML
    private TableColumn<OrderListTable, Float> tabcoOrderListPrice;

    @FXML
    private TableColumn<OrderListTable, String> tabcoOrderListStatus;

    @FXML
    private Button btnOrderListEditCancel;

    @FXML
    private Button btnOrderListEditSave;

    @FXML
    private ComboBox<String> rmenuOrderListEdit;

    @FXML
    private DialogPane paneOrderList_editStatus;

    //Service components
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
    // Service - Service page component
    @FXML
    private TableView<Service> tavServiceType;

    @FXML
    private TableColumn<Service, Void> tabcoServiceTypeAction;

    @FXML
    private TableColumn<Service, Integer> tabcoServiceTypeId;

    @FXML
    private TableColumn<Service, String> tabcoServiceTypeName;
    @FXML
    private TableColumn<Service, Float> tabcoServiceTypeMultiplier;

    // dialog
    @FXML
    private DialogPane dipServiceTypeAction;
    @FXML
    private Button btnDialServiceTypeCancel;

    @FXML
    private Button btnDialServiceTypeDelete;

    @FXML
    private Button btnDialServiceTypeSave;

    @FXML
    private TextField txtDialServiceTypeMul;

    @FXML
    private TextField txtDialServiceTypeName;

    //====================================================================================================================================================  
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
    Service currentService;

//    public void setLoadComboBoxDialogState() {
//        cbxState.setItems(FXCollections.observableArrayList("Paid", "Complete", "Processing"));
//    }
    //about us
    public void aboutUs() {
        con = database.openConnection();

        String sql = "select * from LAUNDRYSHOPS";

        try {

            stmt = con.createStatement();
            res = stmt.executeQuery(sql);

            if (res.next()) {
                lblShopName.setText(res.getString("L_name"));
                lblContact.setText(res.getString("L_phone"));
                lblAddress.setText(res.getString("L_address"));
                lblContactMail.setText(res.getString("L_email"));
            }

            con.close();

        } catch (SQLException ex) {
            Logger.getLogger(DashboardController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        if (this.bundle == null) {
            this.bundle = rb;
        }

        initComponents_OL();
        initComponents_NO();
        SetUpServiceTableView();
        SetUpServiceTypeTableView();
        aboutUs();
        initBtnLanguage();

//        statistics();
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
//        lblAUStaffphone.setText(staff.getPhone());
//        lblAUStaffAddress.setText(staff.getAddress());

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
            initComponents_NO();

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
            statistics();
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

//        try {
//            FXMLLoader loader = new FXMLLoader(getClass().getResource("primary.fxml"));
//            Parent root;
//            root = loader.load();
////            DashboardController dashboard = loader.getController();
//
////            dashboard.initData(staff);
//            Stage stage = new Stage();
//            Scene scene = new Scene(root, 600, 400);
//
//            stage.setScene(scene);
//            stage.show();
//
//        } catch (IOException ex) {
//            Logger.getLogger(DashboardController.class.getName()).log(Level.SEVERE, null, ex);
//        }
        try {
            ResourceBundle bundle;
            if (languageN.equals("en")) {
                bundle = ResourceBundle.getBundle("language.MessageBundle", Locale.US);
            } else {
                Locale.setDefault(new Locale("vi", "VN"));
                bundle = ResourceBundle.getBundle("language.MessageBundle");
            }
            FXMLLoader loader = new FXMLLoader(getClass().getResource("primary.fxml"), bundle);
            Parent root = loader.load();

            PrimaryController pmrC = loader.getController();

            pmrC.initLanguage(languageN);
            pmrC.initBtnLanguage();

            Stage stage = new Stage();
            Scene scene = new Scene(root);

            stage.setScene(scene);

            stage.show();

        } catch (IOException ex) {
            Logger.getLogger(PrimaryController.class
                    .getName()).log(Level.SEVERE, null, ex);
            Alert alert = new Alert(Alert.AlertType.ERROR);

            alert.setContentText(ex.getMessage());
            alert.showAndWait();
        }
    }

    //====================================================================================================================================================  
    //Order List functions
    private int OLCurrentId;

    public void initComponents_OL() {
        rmenuOrderListRows.getItems().addAll(Integer.valueOf(50), Integer.valueOf(100), Integer.valueOf(500), Integer.valueOf(1000));
        rmenuOrderListRows.setValue(Integer.valueOf(50));

        tabcoOrderListId.setCellValueFactory(new PropertyValueFactory<>("id"));
        tabcoOrderListCustomer.setCellValueFactory(new PropertyValueFactory<>("customer"));
        tabcoOrderListPhone.setCellValueFactory(new PropertyValueFactory<>("phone"));
        tabcoOrderListDate.setCellValueFactory(new PropertyValueFactory<>("date"));
        tabcoOrderListPrice.setCellValueFactory(new PropertyValueFactory<>("price"));
        tabcoOrderListStatus.setCellValueFactory(new PropertyValueFactory<>("status"));
//        tabcoAction.setCellValueFactory(data -> data.getValue().getButton());

        Callback<TableColumn<OrderListTable, Void>, TableCell<OrderListTable, Void>> cellFactory = new Callback<>() {
            @Override
            public TableCell<OrderListTable, Void> call(TableColumn<OrderListTable, Void> param) {
                return new TableCell<>() {
                    private final Button btn = new Button(bundle.getString("tableEditBtn"));

                    {
                        btn.setOnMouseClicked(event -> {
                            OrderListTable items = getTableView().getItems().get(getIndex());
                            System.out.println("Button clicked for " + items.getId());

                            // set dialog edit
                            OLCurrentId = items.getId();

                            rmenuOrderListEdit.getItems().clear();
                            rmenuOrderListEdit.getItems().addAll(bundle.getString("processing"), bundle.getString("completed"), bundle.getString("paid"));
//                            txtDialUnitPrice.setText(Double.toString(items.getUnitPrice()));
                            paneOrderList_editStatus.setVisible(true);

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

        tabcoOrderListAction.setCellFactory(cellFactory);
        OnClick_btnOrderListRefresh();
    }

    //database stuffs
    public List<Integer> getRecentOrderIds(int amount, String excludeStatus) {
        List<Integer> orderIds = new ArrayList<>();
        String sql = "SELECT TOP " + amount + " o.ORDER_id "
                + "FROM ORDERS o "
                + "JOIN STATUS_DETAILS sd ON o.ORDER_id = sd.ORDER_id "
                + "WHERE sd.SD_status <> ? "
                + "AND sd.SD_timestamp = ("
                + "    SELECT MAX(inner_sd.SD_timestamp) "
                + "    FROM STATUS_DETAILS inner_sd "
                + "    WHERE inner_sd.ORDER_id = o.ORDER_id"
                + ") "
                + "ORDER BY o.ORDER_order_date DESC";

        try {
            con = database.openConnection();
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, excludeStatus);
            res = pstmt.executeQuery();

            while (res.next()) {
                orderIds.add(Integer.valueOf(res.getInt("ORDER_id")));
            }

            con.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText(ex.getMessage());
            alert.showAndWait();
        }

        return orderIds;
    }

    public List<Integer> findOrderIdsByPhoneNumber(String phoneNumber) {
        List<Integer> orderIds = new ArrayList<>();
        String sql = "SELECT o.ORDER_id "
                + "FROM ORDERS o "
                + "JOIN CUSTOMERS c ON o.CUS_id = c.CUS_id "
                + "WHERE c.CUS_phone LIKE ?";

        try {
            Connection con = database.openConnection();  // Assume database.openConnection() opens your DB connection
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setString(1, "%" + phoneNumber + "%");
            ResultSet res = pstmt.executeQuery();

            while (res.next()) {
                orderIds.add(Integer.valueOf(res.getInt("ORDER_id")));
            }

            con.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Error: " + ex.getMessage());
            alert.showAndWait();
        }
        return orderIds;
    }

    public OrderListTable GetDataForOrderListTable(int OrderId) {
        OrderListTable orderRow = null;
        String sql = "SELECT "
                + "o.ORDER_id AS OrderID, "
                + "c.CUS_name AS CustomerName, "
                + "c.CUS_phone AS CustomerPhone, "
                + "o.ORDER_order_date AS OrderDate, "
                + "o.ORDER_total_price AS TotalPrice, "
                + "(SELECT TOP 1 SD_status "
                + " FROM STATUS_DETAILS sd "
                + " WHERE sd.ORDER_id = o.ORDER_id "
                + " ORDER BY sd.SD_timestamp DESC) AS LatestStatus "
                + "FROM ORDERS o "
                + "JOIN CUSTOMERS c ON o.CUS_id = c.CUS_id "
                + "WHERE o.ORDER_id = ?";

        try {
            con = database.openConnection();
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setInt(1, OrderId);
            ResultSet res = pstmt.executeQuery();

            if (res.next()) {
                int id = res.getInt("OrderID");
                String customerName = res.getString("CustomerName");
                String customerPhone = res.getString("CustomerPhone");
                Date orderDate = res.getDate("OrderDate");
                float totalPrice = res.getFloat("TotalPrice");
                String latestStatus = res.getString("LatestStatus");
                System.out.println("LATEST STATUS IS " + latestStatus);
                if (latestStatus != null) {
                    latestStatus = bundle.getString(latestStatus);
                }
                orderRow = new OrderListTable(id, customerName, customerPhone, orderDate, totalPrice, latestStatus);
            } else {
                System.out.println("No order found with ID: " + OrderId);
            }

            con.close();
        } catch (SQLException ex) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText(ex.getMessage());
            alert.showAndWait();
        }

        return orderRow;
    }

    public void insertStatus(int staffId, int orderId, String status) {
        // SQL statement without the timestamp column
        String sql = "INSERT INTO STATUS_DETAILS (SF_id, ORDER_id, SD_status) VALUES (?, ?, ?)";

        try (Connection con = database.openConnection(); PreparedStatement pstmt = con.prepareStatement(sql)) {

            if (status.equals("Paid") || status.equals("Đã thu")) {
                status = "paid";
            } else if (status.equals("Completed") || status.equals("Xong")) {
                status = "completed";
            } else {
                status = "processing";
            }
            pstmt.setInt(1, staffId);  // Set staffId
            pstmt.setInt(2, orderId);  // Set orderId
            pstmt.setString(3, status);  // Set status

            pstmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText(ex.getMessage());
            alert.showAndWait();
        }
    }

    //in-app stuffs
    //i don't know which button use this
    public void setUpOrderListTable() {
    }

    public void OnClick_btnOrderListRefresh() {
        ObservableList<OrderListTable> data = FXCollections.observableArrayList();
        List<Integer> orderIds;
        if (txtOrderListSearch.getText() == "") {
            orderIds = getRecentOrderIds(rmenuOrderListRows.getValue(), "paid");
        } else {
            orderIds = findOrderIdsByPhoneNumber(txtOrderListSearch.getText());
        }
        for (int id : orderIds) {
            data.add(GetDataForOrderListTable(id));
        }
        tavOrderList.setItems(data);
        tavOrderList.refresh();
    }

    public void OnClick_btnOrderListEditCancel() {
        paneOrderList_editStatus.setVisible(false);
    }

    public void OnClick_btnOrderListEditSave() {
        if (rmenuOrderListEdit.getValue() == null) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Warning");
            alert.setHeaderText(null);
            alert.setContentText(bundle.getString("statusRequire"));
            alert.showAndWait();
            return;
        }
        insertStatus(staff.getId(), OLCurrentId, rmenuOrderListEdit.getValue());
        OnClick_btnOrderListRefresh();
        paneOrderList_editStatus.setVisible(false);
    }

    //====================================================================================================================================================  
    //New Order functions
    //----------
    //init components
    public void initComponents_NO() {
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

        ObservableList<NO_Detail> data = FXCollections.observableArrayList();
        NO_Detail_table.setItems(data);
        NO_Order_id.setText("");
    }

    //----------
    //database connect
    public ObservableList<Option> GetServices() {
        con = database.openConnection();
        String sql = "select * from LAUNDRY_SERVICES";
        ObservableList<Option> data = FXCollections.observableArrayList();

        try {
            stmt = con.createStatement();
            res = stmt.executeQuery(sql);
            while (res.next()) {
                String otpName = res.getString("LS_name");
                String otpToShow = bundle.getString(otpName);
//                Option option = new Option(res.getInt("LS_id"), res.getString("LS_name"));
                Option option = new Option(res.getInt("LS_id"), otpToShow);
                data.add(option);
            }
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(DashboardController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return data;
    }

    public ObservableList<Option> GetCategory() {
        con = database.openConnection();
        String sql = "select * from ITEMS";
        ObservableList<Option> data = FXCollections.observableArrayList();

        try {
            stmt = con.createStatement();
            res = stmt.executeQuery(sql);
            while (res.next()) {

//                String itemT = res.getString("ITEM_type").trim();
//                String itemTypeToShow = bundle.getString(itemT);
//                Item item = new Item(res.getInt("ITEM_id"), itemTypeToShow, res.getFloat("ITEM_unit_price"));
                String otpName = res.getString("ITEM_type").trim();
                System.out.println("OPTION name is " + otpName);
                String otpNameToShow = bundle.getString(otpName);
//                Option option = new Option(res.getInt("ITEM_id"), res.getString("ITEM_type"));
                Option option = new Option(res.getInt("ITEM_id"), otpNameToShow);
                data.add(option);
            }
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(DashboardController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return data;
    }

    public Customer CustomerSearch(String phone) {

        Customer result = new Customer();
        con = database.openConnection();
        String sql = "select * from Customers where CUS_phone = ?";

        try {
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, phone);
            res = pstmt.executeQuery();
            if (res.next()) {
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

    public boolean CreateCustomer(Customer cus) {
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

    public int CreateOrder(String phone, float total) {
        int orderId = -1;
        LocalDate currentDate = LocalDate.now();
        Date sqlDate = Date.valueOf(currentDate);
        int cusId = CustomerSearch(phone).getId();
        System.out.println("CUSTOMER ID IS "+cusId);
        con = database.openConnection();
        String sql = "insert into ORDERS (CUS_id, ORDER_order_date, ORDER_pickup_date, ORDER_total_price) values (?, ?, ?, ?);";
        try {
            pstmt = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            pstmt.setInt(1, cusId);
            pstmt.setDate(2, sqlDate);
            pstmt.setDate(3, sqlDate);
            pstmt.setFloat(4, total);
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

    public float GetPPK(int catId) {
        float ppk = 0;
        con = database.openConnection();
        String sql = "select * from ITEMS where ITEM_id = ?";
        try {
            pstmt = con.prepareStatement(sql);
            pstmt.setInt(1, catId);
            res = pstmt.executeQuery();
            if (res.next()) {
                ppk = res.getFloat("ITEM_unit_price");
            } else {
                System.out.println("No record found for catId: " + catId);
            }
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(DashboardController.class.getName()).log(Level.SEVERE, null, ex);
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText(ex.getMessage());
            alert.showAndWait();
        }
        return ppk;
    }

    public float GetSMultiplier(int SId) {
        System.out.println(SId);
        float multiplier = 0;
        con = database.openConnection();
        String sql = "select * from LAUNDRY_SERVICES where LS_id = ?";
        try {
            pstmt = con.prepareStatement(sql);
            pstmt.setInt(1, SId);
            res = pstmt.executeQuery();
            if (res.next()) {
                multiplier = res.getFloat("LS_multiplier");
            } else {
                System.out.println("No record found for SId: " + SId);
            }
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(DashboardController.class.getName()).log(Level.SEVERE, null, ex);
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText(ex.getMessage());
            alert.showAndWait();
        }
        return multiplier;
    }

    public void DeleteOrder(int orderID) {
        con = database.openConnection();
        String sql = "delete from orders where ORDER_id = ?";
        try {
            pstmt = con.prepareStatement(sql);
            pstmt.setInt(1, orderID);
            pstmt.executeUpdate();
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(DashboardController.class.getName()).log(Level.SEVERE, null, ex);
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText(ex.getMessage());
            alert.showAndWait();
        }
    }

    public int GetServiceId(String service) {
        int id = 0;
        con = database.openConnection();
        String sql = "select * from Laundry_services where LS_name = ?;";
        try {
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, service);
            res = pstmt.executeQuery();
            if (res.next()) {
                id = res.getInt("LS_id");
            } else {
                System.out.println("something went wrong");
            }
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(DashboardController.class.getName()).log(Level.SEVERE, null, ex);
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText(ex.getMessage());
            alert.showAndWait();
        }
        return id;
    }

    public int GetCategoryId(String cat) {
        int id = 0;
        con = database.openConnection();
        String sql = "select * from ITEMS where ITEM_type = ?;";
        try {
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, cat);
            res = pstmt.executeQuery();
            if (res.next()) {
                id = res.getInt("ITEM_id");
            } else {
                System.out.println("something went wrong");
            }
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(DashboardController.class.getName()).log(Level.SEVERE, null, ex);
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText(ex.getMessage());
            alert.showAndWait();
        }
        return id;
    }

    public void AddOrderDetail(NO_Detail detail) {
        String sql = "insert into ORDER_DETAILS (LS_id, ITEM_id, ORDER_id, OD_kilos) values(?, ?, ?, ?);";
        String detailService = detail.getService();
        String detailCat = detail.getCategory();
        String fDetailS = bundle.getString(detailService);
        String fDetailC = bundle.getString(detailCat);

        System.out.println("0000000000000000000" + fDetailS + " " + fDetailC);
        Detail add = new Detail(GetServiceId(fDetailS), GetCategoryId(fDetailC), Integer.parseInt(NO_Order_id.getText()), detail.getWeight());
        con = database.openConnection();
        try {
            System.out.println("LS ID IS " + GetServiceId(detail.getService()));
            pstmt = con.prepareStatement(sql);
            pstmt.setInt(1, add.getServiceId());
            pstmt.setInt(2, add.getCatId());
            pstmt.setInt(3, add.getOrderId());
            pstmt.setFloat(4, add.getKilos());
            pstmt.executeUpdate();
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(DashboardController.class.getName()).log(Level.SEVERE, null, ex);
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText(ex.getMessage());
            alert.showAndWait();
        }
    }

    //----------
    //in-app stuff
    public void OnClick_NO_CustomerSearch_btn() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText(null);
        String phone = new String(NO_Customer_Search_txt.getText());
        Customer result = CustomerSearch(phone);
        if (result.getName().equals("")) {
            alert.setTitle("warning");
            alert.setContentText("Customer don't exist");
            alert.showAndWait();
        } else {
            alert.setTitle("success");
            alert.setContentText("Customer found with name " + result.getName());
            alert.showAndWait();
            NO_CustomerName_txt.setText(result.getName());
            NO_Phone_txt.setText(result.getPhone());
        }
    }

    //create customer
    public void OnClick_NO_CreateCus_btn() {
        NO_CreateCus_pane.setVisible(true);
    }

    public void OnClick_NO_CreateCus_create_btn() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText(null);
        if (NO_CreateCus_name_txt.getText() == "" || NO_CreateCus_phone_txt.getText() == "") {
            alert.setTitle("waring");
            alert.setContentText(bundle.getString("fieldRequire"));
            alert.showAndWait();
            return;
        }
        Customer cus = new Customer(0, NO_CreateCus_name_txt.getText(), NO_CreateCus_phone_txt.getText());
        if (!CustomerSearch(cus.getPhone()).getPhone().equals("")) {
            alert.setTitle("waring");
            alert.setContentText(bundle.getString("existingCus"));
            alert.showAndWait();
            return;
        }
        if (CreateCustomer(cus)) {
            alert.setTitle("OK!");
            alert.setContentText(bundle.getString("createdCus"));
            alert.showAndWait();
            NO_CreateCus_pane.setVisible(false);
            NO_Customer_Search_txt.setText(cus.getPhone());
            OnClick_NO_CustomerSearch_btn();
        } else {
            alert.setTitle(bundle.getString("warning"));
            alert.setContentText(bundle.getString("errorCreate"));
            alert.showAndWait();
        }
    }

    public void OnClick_NO_CreateCus_cancel_btn() {
        NO_CreateCus_name_txt.setText("");
        NO_CreateCus_phone_txt.setText("");
        NO_CreateCus_pane.setVisible(false);
    }

    //add detail
    public void OnClick_NO_Add_btn() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText(null);
        if (NO_Weight_add.getText().equals("") || NO_Service_add.getValue() == null || NO_Service_add.getValue() == null) {
            alert.setTitle(bundle.getString("warning"));
            alert.setContentText(bundle.getString("fieldRequire"));
            alert.showAndWait();
            return;
        }
        NO_Detail newDetail = new NO_Detail(NO_Category_add.getValue().getType(),
                Float.parseFloat(NO_Weight_add.getText()),
                NO_Service_add.getValue().getType(),
                GetPPK(NO_Category_add.getSelectionModel().getSelectedItem().getId()),
                GetSMultiplier(NO_Service_add.getSelectionModel().getSelectedItem().getId()));
        ObservableList<NO_Detail> data = NO_Detail_table.getItems();
        boolean found = false;
        for (NO_Detail detail : data) {
            if (newDetail.getCategory().equals(detail.getCategory()) && newDetail.getService().equals(detail.getService())) {
                System.out.println("update row");
                detail.setWeight(newDetail.getWeight() + detail.getWeight());
                found = true;
                break;
            }
        }
        if (!found) {
            data.add(newDetail);
        }
        NO_Detail_table.setItems(data);
        NO_Detail_table.refresh();
    }

    //save order and details
    public void OnClick_NO_Save_btn() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText(null);
        if (NO_CustomerName_txt.getText() == "" || NO_Phone_txt.getText() == "") {
            alert.setTitle(bundle.getString("warning"));
            alert.setContentText(bundle.getString("cusREquire"));
            alert.showAndWait();
            return;
        }
        float total = 0;
        ObservableList<NO_Detail> data = NO_Detail_table.getItems();
        if (data.isEmpty()) {
            alert.setTitle(bundle.getString("warning"));
            alert.setContentText(bundle.getString("itemREquire"));
            alert.showAndWait();
            return;
        }
        for (NO_Detail detail : data) {
            total += detail.getTotal();
        }

        int orderId = CreateOrder(NO_Phone_txt.getText(), total);
        if (orderId == -1) {
            alert.setTitle(bundle.getString("warning"));
            alert.setContentText(bundle.getString("orderFailed"));
            alert.showAndWait();
            return;
        }
        NO_Order_id.setText(String.valueOf(orderId));
        for (NO_Detail detail : data) {
            AddOrderDetail(detail);
        }
        data = FXCollections.observableArrayList();
        NO_Detail_table.setItems(data);
//        insertStatus(staff.getId(), Integer.parseInt(NO_Order_id.getText()), "Pending");
        insertStatus(staff.getId(), Integer.parseInt(NO_Order_id.getText()), "processing");
        alert.setTitle("OK!");
        alert.setContentText(bundle.getString("okCreate") + " " + NO_Order_id.getText());
        alert.showAndWait();
        NO_Order_id.setText("");
    }

    public void OnClick_NO_Cancel_btn() {
        initComponents_NO();
    }

    //====================================================================================================================================================  
    //services functions
    // init data for tableview's Service-Service page
    private ObservableList<Service> addServiceTypeData;

    public ObservableList<Service> serviceTypeListData() {

        con = database.openConnection();
        String sql = "select * from LAUNDRY_SERVICES";
        ObservableList<Service> data = FXCollections.observableArrayList();

        try {
            stmt = con.createStatement();
            res = stmt.executeQuery(sql);

            while (res.next()) {
                String itemName = res.getString("LS_name");
                String itemNameToShow = bundle.getString(itemName);
//                Service item = new Service(res.getInt("LS_id"), res.getString("LS_name"), res.getFloat("LS_multiplier"));
                Service item = new Service(res.getInt("LS_id"), itemNameToShow, res.getFloat("LS_multiplier"));
                System.out.println(item.getId() + ", " + item.getName() + ", " + item.getMultiplier());
                data.add(item);
            }

            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(DashboardController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return data;
    }

    public void SetUpServiceTypeTableView() {

        addServiceTypeData = serviceTypeListData();

        tabcoServiceTypeId.setCellValueFactory(new PropertyValueFactory<>("id"));
        tabcoServiceTypeName.setCellValueFactory(new PropertyValueFactory<>("name"));
        tabcoServiceTypeMultiplier.setCellValueFactory(new PropertyValueFactory<>("multiplier"));

        Callback<TableColumn<Service, Void>, TableCell<Service, Void>> cellFactory = new Callback<>() {
            @Override
            public TableCell<Service, Void> call(TableColumn<Service, Void> param) {
                return new TableCell<>() {
                    private final Button btn = new Button(bundle.getString("tableEditBtn"));

                    {
                        btn.setOnMouseClicked(event -> {
                            Service items = getTableView().getItems().get(getIndex());
                            System.out.println("Button clicked for " + items.getId());

                            // set dialog edit
                            currentService = new Service(items.getId(), items.getName(), items.getMultiplier());
                            txtDialServiceTypeName.setText(items.getName());
                            txtDialServiceTypeMul.setText(Double.toString(items.getMultiplier()));
                            dipServiceTypeAction.setVisible(true);

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
        // add button to action field tableviews
        tabcoServiceTypeAction.setCellFactory(cellFactory);
        tavServiceType.setItems(addServiceTypeData);

    }

    // event for Service-Service page
    public void OnClick_DiaglogServiceCancel() {
        dipServiceTypeAction.setVisible(false);

    }

    public void OnClick_DiaglogServiceSave() {
        System.out.println("Save");
        con = database.openConnection();

        try {

            String sql = "UPDATE LAUNDRY_SERVICES SET LS_name = ?, LS_multiplier = ? WHERE LS_id = ?";

            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, txtDialServiceTypeName.getText());
            pstmt.setDouble(2, Double.parseDouble(txtDialServiceTypeMul.getText()));
            pstmt.setInt(3, currentService.getId());

            int rows = pstmt.executeUpdate();

            if (rows > 0) {
                System.out.println("Update item " + currentService.getId() + " successfully!");
                SetUpServiceTypeTableView();
                dipServiceTypeAction.setVisible(false);
            }
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(DashboardController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void OnClick_DiaglogServiceDelete() {
        System.out.println("Delete");
        con = database.openConnection();

        try {

            String sql = "DELETE FROM LAUNDRY_SERVICES WHERE LS_id = ?";

            pstmt = con.prepareStatement(sql);

            pstmt.setInt(1, currentService.getId());

            int rows = pstmt.executeUpdate();

            if (rows > 0) {
                System.out.println("Delete item " + currentService.getId() + " successfully!");
                SetUpServiceTypeTableView();
                dipServiceTypeAction.setVisible(false);
            }
            con.close();
        } catch (SQLException ex) {
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

            if (rows > 0) {
                System.out.println(bundle.getString("insertService"));
                txtServiceName.setText("");
                txtServiceMultiplier.setText("");
                SetUpServiceTypeTableView();
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

    // init data for tableview's Service-Item page
    private ObservableList<Item> addServiceItemData;

    public ObservableList<Item> serviceItemListData() {

        con = database.openConnection();
        String sql = "select * from items";
        ObservableList<Item> data = FXCollections.observableArrayList();

        try {
            stmt = con.createStatement();
            res = stmt.executeQuery(sql);

            while (res.next()) {
                String itemT = res.getString("ITEM_type").trim();

//                String itemType = "clothes";
                String itemTypeToShow = bundle.getString(itemT);
                Item item = new Item(res.getInt("ITEM_id"), itemTypeToShow, res.getFloat("ITEM_unit_price"));
                data.add(item);
            }

            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(DashboardController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return data;
    }

    public void SetUpServiceTableView() {

        addServiceItemData = serviceItemListData();

        tabcoItemId.setCellValueFactory(new PropertyValueFactory<>("id"));
        tabcoItemName.setCellValueFactory(new PropertyValueFactory<>("type"));
        tabcoItemPrice.setCellValueFactory(new PropertyValueFactory<>("unitPrice"));

        Callback<TableColumn<Item, Void>, TableCell<Item, Void>> cellFactory = new Callback<>() {
            @Override
            public TableCell<Item, Void> call(TableColumn<Item, Void> param) {
                return new TableCell<>() {
                    private final Button btn = new Button(bundle.getString("tableEditBtn"));

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
        // add button to action field tableviews
        tabcoAction.setCellFactory(cellFactory);
        tavItem.setItems(addServiceItemData);

    }

    // event for Service-Item page
    public void OnClick_ServiceItemSave() {
        con = database.openConnection();
        String sql = "INSERT INTO ITEMS (ITEM_type, ITEM_unit_price) VALUES (?,?)";

        try {
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, txtServiceItemName.getText());
            pstmt.setString(2, txtServiceItemUnitPrice.getText());

            int rows = pstmt.executeUpdate();

            if (rows > 0) {
                System.out.println(bundle.getString("insertItem"));
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

            if (rows > 0) {
                System.out.println("Update item " + currentItem.getId() + " successfully!");
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

            if (rows > 0) {
                System.out.println("Delete item " + currentItem.getId() + " successfully!");
                SetUpServiceTableView();
                dipAction.setVisible(false);
            }
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(DashboardController.class.getName()).log(Level.SEVERE, null, ex);
        }
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

    //====================================================================================================================================================  
    //Statistics functions
    @FXML
    private ComboBox<String> resultStatisticCombobox;

    @FXML
    private Label lblOrders_recieved;
    @FXML
    private Label lblComplete;
    @FXML
    private Label lblPaid;
    @FXML
    private Label lblProcessing;

    @FXML
    private Label lblToday;

    @FXML
    private Label lblRevenue;

    @FXML
    private Label lblPaidPercentage;
    @FXML
    private Label lblProcessingPercentage;
    @FXML
    private Label lblCompletedPercentage;

    @FXML
    private AnchorPane remainOrderInfo;

    @FXML
    private AnchorPane remainOrderInfo2;

    @FXML
    private Text txtRemainOrders;

    @FXML
    private Button btnLanguage;

    private int paidNum, completedNum, processingNum, totalNum;
    private int remainOrders = 0;
    private float totalRevenue;
    private String languageN = "en";

    public void getOrderQuantity(String timeChosen) {
        paidNum = 0;
        completedNum = 0;
        processingNum = 0;
        totalNum = 0;
        totalRevenue = 0;

        con = database.openConnection();
//        String sql = "with latestStatus as"
//                + "(select ORDER_id,SD_status, ROW_NUMBER() "
//                + "over	(partition by order_id order by sd_timestamp desc) as row_num "
//                + "from STATUS_DETAILS) "
//                + "select sd_status, count(distinct lateststatus.ORDER_id) as num "
//                + "from "
//                + "latestStatus join ORDERS on latestStatus.ORDER_id = ORDERS.ORDER_id "
//                + "where "
//                + "latestStatus.row_num=1 ";

        String sql = "with latestStatus as "
                + "(select ORDER_id,SD_status, ROW_NUMBER() over "
                + "(partition by order_id order by sd_timestamp desc) as row_num "
                + "from STATUS_DETAILS)"
                + "select "
                + "sd_status, latestStatus.ORDER_id as ORDER_ID, ORDER_total_price as total_price "
                + "from "
                + "latestStatus join ORDERS on latestStatus.ORDER_id = ORDERS.ORDER_id "
                + "where "
                + "latestStatus.row_num=1 ";

        if (timeChosen == "month") {
            sql
                    += "and MONTH(ORDER_order_date) = MONTH(getdate()) "
                    + "group by SD_status, latestStatus.ORDER_id, ORDER_total_price;";
        } else if (timeChosen == "seven") {
            sql += "and ORDER_order_date >= DATEADD(DAY, -7, getdate())"
                    + "group by SD_status, latestStatus.ORDER_id, ORDER_total_price;";
        } else {
            sql += "and ORDER_order_date = cast(getdate() as date)"
                    + "group by SD_status, latestStatus.ORDER_id, ORDER_total_price;";
        }

        try {
            stmt = con.createStatement();
            res = stmt.executeQuery(sql);
            while (res.next()) {
                String stt = res.getString("sd_status");
                if ("paid".equals(stt)) {
                    paidNum++;
                    float amount = res.getFloat("total_price");
                    totalRevenue += amount;
                } else if ("completed".equals(stt)) {
                    completedNum++;
                } else {
                    processingNum++;
                }
            }
            totalNum = paidNum + processingNum + completedNum;
            System.out.println(res);
            con.close();

        } catch (SQLException ex) {
            Logger.getLogger(DashboardController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void getRemainOrders() {
        con = database.openConnection();
        remainOrders = 0;
        String sql2 = "with latestStatus as "
                + "(select ORDER_id,SD_status, ROW_NUMBER() over "
                + "(partition by order_id order by sd_timestamp desc) as row_num "
                + "from STATUS_DETAILS)"
                + "select count (distinct ORDER_id) as remainOrders "
                + "from latestStatus where row_num=1 and SD_status='processing';";
        try {
            System.out.println("here");
            stmt = con.createStatement();
            res = stmt.executeQuery(sql2);
            while (res.next()) {
                Integer remain = res.getObject("remainOrders", Integer.class);
                if (remain != null) {
                    remainOrders = remain;
                }
            }
            con.close();
        } catch (SQLException e) {
            Logger.getLogger(DashboardController.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    public void setPieChart() {
        String data1 = bundle.getString("paid");
        String data2 = bundle.getString("completed");
        String data3 = bundle.getString("processing");

        ObservableList<PieChart.Data> pieChartData
                = FXCollections.observableArrayList(
                        new PieChart.Data(data1, paidNum),
                        new PieChart.Data(data2, completedNum),
                        new PieChart.Data(data3, processingNum));

        piePie.setData(pieChartData);

    }

    public void setValuesToInterface() {
        lblPaid.setText(String.valueOf(paidNum));
        lblProcessing.setText(String.valueOf(processingNum));
        lblOrders_recieved.setText(String.valueOf(totalNum));
        lblComplete.setText(String.valueOf(completedNum));
        lblRevenue.setText(String.valueOf(totalRevenue));
        LocalDate today = LocalDate.now();
        lblToday.setText(bundle.getString("date") + ": " + today);

        float sumP = (float) (paidNum + completedNum + processingNum);

        String paidPStr = "(" + Math.round((float) paidNum / (sumP) * 10000) / 100.0 + "%)";
        String completedPStr = "(" + Math.round((float) completedNum / (sumP) * 10000) / 100.0 + "%)";
        System.out.println(completedPStr);
        String processingPStr = "(" + Math.round((float) processingNum / (sumP) * 10000) / 100.0 + "%)";
        lblPaidPercentage.setText(paidPStr);
        lblCompletedPercentage.setText(completedPStr);
        lblProcessingPercentage.setText(processingPStr);

        if (remainOrders != 0) {
//            remainOrderInfo.setVisible(false);
//            remainOrderInfo2.setVisible(true);

            String remainString = bundle.getString("remainOrdersMessage");
            txtRemainOrders.setText(remainOrders + " " + remainString);
            remainOrderInfo2.setVisible(false);
            remainOrderInfo.setVisible(true);
        } else {
//            String remainString = bundle.getString("remainOrdersMessage");
//            txtRemainOrders.setText(remainOrders + " " + remainString);
//            remainOrderInfo2.setVisible(false);
//            remainOrderInfo.setVisible(true);
            remainOrderInfo.setVisible(false);
            remainOrderInfo2.setVisible(true);
        }

    }

    public void statistics() {
        ObservableList<String> ol = FXCollections.observableArrayList();
        ol.add(bundle.getString("today"));
        ol.add(bundle.getString("seven"));
        ol.add(bundle.getString("thismonth"));
        resultStatisticCombobox.setItems(ol);
        resultStatisticCombobox.setOnAction(e -> showResultInTime());

        getOrderQuantity("today");
        setPieChart();
        getRemainOrders();
        setValuesToInterface();
    }

    public void showResultInTime() {
        String selectedTime = resultStatisticCombobox.getValue();
        if (selectedTime == null) {
            selectedTime = "Today";
        }
        if (selectedTime.equals("Today")) {
            getOrderQuantity("today");
        } else if (selectedTime.equals("In 7 days")) {
            getOrderQuantity("seven");
        } else {
            getOrderQuantity("month");
        }
        setPieChart();
        setValuesToInterface();
    }

//    public void setLanguage() {
////        if (languageN.equals("en")) languageN = "vi";
//        loginIni(languageN);
//    }
    public void switchLanguage() {
        if (languageN.equals("en")) {
            languageN = "vi";
        } else {
            languageN = "en";
        }
        loginIni(languageN);
//        initBtnLanguage();
    }

    public void initLanguage(String langg) {
        this.languageN = langg;
    }

    public void loginIni(String languageMm) {
        System.out.println("The language is " + languageN);
        int myId = this.staff.getId();
        String myName = this.staff.getName();
        String myUsername = this.staff.getUserName();
        String myPhone = this.staff.getPhone();
        String myAddress = this.staff.getAddress();
        Staff staff = new Staff(myId, myName, myUsername, myPhone, myAddress);
        btnLanguage.getScene().getWindow().hide();
        System.out.println(staff.getName() + ", " + staff.getUserName()
                + ", " + staff.getPhone() + ", " + staff.getAddress());
        try {
            ResourceBundle bundle;
            if (languageN.equals("en")) {
                bundle = ResourceBundle.getBundle("language.MessageBundle", Locale.US);
            } else {
                Locale.setDefault(new Locale("vi", "VN"));
                bundle = ResourceBundle.getBundle("language.MessageBundle");
            }
            FXMLLoader loader = new FXMLLoader(getClass().getResource("DashBoard.fxml"), bundle);
            Parent root = loader.load();

            DashboardController dashboard = loader.getController();

            dashboard.initData(staff);
            dashboard.initLanguage(languageMm);
            dashboard.initBtnLanguage();
            dashboard.setBundle(bundle);

            Stage stage = new Stage();
            Scene scene = new Scene(root, 1080, 600);

            stage.setScene(scene);

            stage.show();
//                        App.setRoot("Dashboard");

        } catch (IOException ex) {
            Logger.getLogger(PrimaryController.class
                    .getName()).log(Level.SEVERE, null, ex);
            Alert alert = new Alert(Alert.AlertType.ERROR);

            alert.setContentText(ex.getMessage());
            alert.showAndWait();
        }
    }

    public void initBtnLanguage() {
//        System.out.println("INBTN "+languageN);
        if (languageN.equals("en")) {
            btnLanguage.setText("English");
        } else {
            btnLanguage.setText("Tiếng Việt");
        }
    }

    public void setBundle(ResourceBundle bundle) {
        this.bundle = bundle;
    }

    private ResourceBundle bundle;
    //====================================================================================================================================================  
}

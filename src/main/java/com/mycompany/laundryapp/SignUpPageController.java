package com.mycompany.laundryapp;

import java.util.Locale;
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
import javafx.scene.control.Label;
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
        initBtnLanguage();
    }

    ResourceBundle bundle;

    PreparedStatement pstmt;
    ResultSet res;
    Connection con;
    final private int laundryId = 1;

    public void OnClick_SignUp() {
        con = database.openConnection();
//        ResourceBundle bundle;
        if (languageN.equals("en")) {
            bundle = ResourceBundle.getBundle("language.MessageBundle", Locale.US);
        } else {
            Locale.setDefault(new Locale("vi", "VN"));
            bundle = ResourceBundle.getBundle("language.MessageBundle");
        }
        try {
            // Check if any field is empty
            if (txtFullName.getText() == ""
                    || txtUserName.getText() == ""
                    || txtPassword.getText() == ""
                    || txtPhone.getText() == ""
                    || txtAddress.getText() == "") {
                System.out.println("Error");
                throw new SQLException(bundle.getString("fillFieldsMessage"));
            }

            // Check if the username already exists
            String sql = "SELECT * FROM staffs WHERE SF_username = ?";
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, txtUserName.getText());
            res = pstmt.executeQuery();

            if (res.next()) {
                throw new SQLException(bundle.getString("ExistingUsername"));
            }

            // Insert new staff record
            sql = "INSERT INTO staffs (SF_name, SF_username, SF_password, SF_phone, SF_address, L_id) "
                    + "VALUES (?, ?, ?, ?, ?, ?)";
            pstmt = con.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);  // Get generated keys
            pstmt.setString(1, txtFullName.getText());
            pstmt.setString(2, txtUserName.getText());
            pstmt.setString(3, txtPassword.getText());
            pstmt.setString(4, txtPhone.getText());
            pstmt.setString(5, txtAddress.getText());
            pstmt.setInt(6, laundryId);

            int rows = pstmt.executeUpdate();

            // If insertion was successful, retrieve the generated staff ID
            if (rows > 0) {
                res = pstmt.getGeneratedKeys();
                if (res.next()) {
                    int staffId = res.getInt(1);  // Assuming the first column is the auto-generated ID

                    // Show success alert
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setContentText(bundle.getString("signUpInfo"));
                    alert.showAndWait();

                    // Create Staff object with the generated id
                    Staff staff = new Staff(staffId, txtFullName.getText(), txtUserName.getText(),
                            txtPhone.getText(), txtAddress.getText());

                    // Close the current window and open the dashboard
                    btnSignUp.getScene().getWindow().hide();

                    try {
//                        FXMLLoader loader = new FXMLLoader(getClass().getResource("Dashboard.fxml"));
//                        Parent root = loader.load();
//                        DashboardController dbController = loader.getController();
//
//                        // Initialize Dashboard with the staff data
//                        dbController.initData(staff);
//                        dbController.initLanguage(languageN);
//
//                        Stage stage = new Stage();
//                        Scene scene = new Scene(root, 1080, 800);
//                        stage.setScene(scene);
//                        stage.show();

                        FXMLLoader loader = new FXMLLoader(getClass().getResource("Dashboard.fxml"), bundle);
                        Parent root = loader.load();

                        DashboardController dC = loader.getController();
                        dC.initData(staff);
                        System.out.println("Language pass to Dashboard is "+languageN);
                        dC.initLanguage(languageN);
                        dC.initBtnLanguage();

                        Stage stage = new Stage();
                        Scene scene = new Scene(root);

                        stage.setScene(scene);

                        stage.show();
                    } catch (IOException ex) {
                        Logger.getLogger(SignUpPageController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setContentText(bundle.getString("NoChange"));
                alert.showAndWait();
            }

            con.close();
        } catch (SQLException ex) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText(ex.getMessage());
            alert.showAndWait();
        }
    }

    public void reloadSignUp(String languageMm) {
        lblLanguageSwitchLg.getScene().getWindow().hide();
        try {
            ResourceBundle bundle;
            if (languageN.equals("en")) {
                bundle = ResourceBundle.getBundle("language.MessageBundle", Locale.US);
            } else {
                Locale.setDefault(new Locale("vi", "VN"));
                bundle = ResourceBundle.getBundle("language.MessageBundle");
            }
            FXMLLoader loader = new FXMLLoader(getClass().getResource("SignUpPage.fxml"), bundle);
            Parent root = loader.load();

            SignUpPageController sC = loader.getController();

            sC.initLanguage(languageMm);
            sC.initBtnLanguage();

            Stage stage = new Stage();
            Scene scene = new Scene(root);

            stage.setScene(scene);

            stage.show();

        } catch (IOException ex) {
            Logger.getLogger(SignUpPageController.class
                    .getName()).log(Level.SEVERE, null, ex);
            Alert alert = new Alert(Alert.AlertType.ERROR);

            alert.setContentText(ex.getMessage());
            alert.showAndWait();
        }
    }

    public void switchLanguage() {
        if (languageN.equals("en")) {
            languageN = "vi";
        } else {
            languageN = "en";
        }
        reloadSignUp(languageN);
//        initBtnLanguage();
    }

    public void initLanguage(String langg) {
        this.languageN = langg;
    }

    public void initBtnLanguage() {
//        System.out.println("INBTN "+languageN);
        if (languageN.equals("en")) {
            lblLanguageSwitchLg.setText("English");
        } else {
            lblLanguageSwitchLg.setText("Tiếng Việt");
        }
    }
    private String languageN = "en";
    @FXML
    private Label lblLanguageSwitchLg;
    
    @FXML
    private Button btnBack;
    
    public void Back(){
        btnBack.getScene().getWindow().hide();
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

            PrimaryController sC = loader.getController();

            sC.initLanguage(languageN);
            sC.initBtnLanguage();

            Stage stage = new Stage();
            Scene scene = new Scene(root);

            stage.setScene(scene);

            stage.show();

        } catch (IOException ex) {
            Logger.getLogger(SignUpPageController.class
                    .getName()).log(Level.SEVERE, null, ex);
            Alert alert = new Alert(Alert.AlertType.ERROR);

            alert.setContentText(ex.getMessage());
            alert.showAndWait();
        }
    }
}

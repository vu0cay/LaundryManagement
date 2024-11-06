module com.mycompany.laundryapp {
    requires javafx.graphics;
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires java.base;
    opens com.mycompany.laundryapp to javafx.   fxml;
    exports com.mycompany.laundryapp;
}

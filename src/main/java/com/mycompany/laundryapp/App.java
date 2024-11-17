package com.mycompany.laundryapp;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.nio.channels.ConnectionPendingException;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.control.Alert;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;
    private String languageN = "en";
    @Override
    public void start(Stage stage) throws IOException {
//        scene = new Scene(loadFXML("primary"), 600, 400);
//        stage.setScene(scene);
//        stage.show();
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

//            Stage stage = new Stage();
            scene = new Scene(root, 600,400);

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

    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static void main(String[] args) {
        launch();    
    }

}
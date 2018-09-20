package controller;

import java.io.IOException;

import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

public class LoginController {

    @FXML
    private JFXTextField username;

    @FXML
    private JFXPasswordField password;

    @FXML
    void logIn(ActionEvent event) throws IOException {
    	if(!username.getText().equals("")) {
    		FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/resources/Main.fxml"));
            Parent p = loader.load();
            Scene scene = new Scene(p);
            //access the controller and call a method
            
            //This line gets the Stage information
            Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
            
            window.setScene(scene);
            window.show();
    	}
    	else {
    		Alert alert = new Alert(AlertType.INFORMATION);
    		alert.setTitle("Information Dialog");
    		alert.setHeaderText(null);
    		alert.setContentText("");

    		alert.showAndWait();

    	}
    }

}

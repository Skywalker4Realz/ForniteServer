package controller;

import java.io.IOException;

import application.Main;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class MainController {
	
	private Main app;
	
    @FXML
    private Button btnRanking;

    @FXML
    private Button btnPartida;

    @FXML
    private Button btnPlatform;

    @FXML
    private Button btnValentine;

    @FXML
    private Button btnBack;

    @FXML
    void exitApp(ActionEvent event) {
    	System.exit(0);
    }

    @FXML
    void startMatch(ActionEvent event) throws IOException {
    	Parent root;
		root = FXMLLoader.load(getClass().getResource("/view/GameFrame.fxml"));
		Scene scene = new Scene(root);
		Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
		window.setScene(scene);
		window.show();
    }

    @FXML
    void startRanking(ActionEvent event) throws IOException {
    	
    	Parent root;
		root = FXMLLoader.load(getClass().getResource("/view/RankingFrame.fxml"));
		Scene scene = new Scene(root);
		Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
		window.setScene(scene);
		window.show();
			
    }

    @FXML
    void startPlatformMode(ActionEvent event) throws IOException {
    	Parent root;
		root = FXMLLoader.load(getClass().getResource("/view/PlatformFrame.fxml"));
		Scene scene = new Scene(root);
		Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
		window.setScene(scene);
		window.initStyle(StageStyle.TRANSPARENT);
		window.show();
    }

    @FXML
    void startValentineMode(ActionEvent event) throws IOException {
    	Parent root;
		root = FXMLLoader.load(getClass().getResource("/view/ValentinesMode.fxml"));
		Scene scene = new Scene(root);
		Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
		window.setScene(scene);
		window.initStyle(StageStyle.UNDECORATED);
		window.show();
    }
    	

}

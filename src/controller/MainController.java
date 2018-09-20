package controller;

import java.awt.List;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.ResourceBundle;

import application.Main;
import fornite.util.ForniteList;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import model.ForniteGlobalServer;
import model.Player;
import model.Server;

public class MainController implements Initializable {
	
	private ForniteGlobalServer forniteServer;
	
	
    @FXML
	RankingController ranking;
    
    @FXML
	MatchController match;
    
    @FXML
	PlatformModeController platform;
    
   	
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
    	 FXMLLoader loader = new FXMLLoader();
         loader.setLocation(getClass().getResource("/resources/GameFrame.fxml"));
         Parent p = loader.load();
         Scene scene = new Scene(p);
         //access the controller and call a method
         match = loader.getController();
         match.init(this);
         
         //This line gets the Stage information
         Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
         
         window.setScene(scene);
         window.show();
         
         loadPlayers();
    }

    @FXML
    void startRanking(ActionEvent event) throws IOException {
    	
    	FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/resources/RankingFrame.fxml"));
        Parent p = loader.load();
        Scene scene = new Scene(p);
        //access the controller and call a method
        ranking = loader.getController();
        ranking.init(this);
        
        ranking.showLANRanking(event);
        //This line gets the Stage information
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        
        window.setScene(scene);
        window.show();
        

        Alert a = new Alert(AlertType.INFORMATION);
        a.setContentText("INICIAMELNTE LOS RANKINGS SON POR KILLS, PERSIONE EN LA COLUMNA REQUERIDA"
        		+ "PARA ORDENAR");
        a.setTitle("FORNITE");
		a.show();
		
    }

    @FXML
    void startPlatformMode(ActionEvent event) throws IOException {
    	FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/resources/PlatformModeFrame.fxml"));
        Parent p = loader.load();
        Scene scene = new Scene(p);
        //access the controller and call a method
        platform = loader.getController();
        platform.init(this);
        
        //This line gets the Stage information
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        
        window.setScene(scene);
        window.show();
    }

    @FXML
    void startValentineMode(ActionEvent event) throws IOException {
    	Parent root;
		root = FXMLLoader.load(getClass().getResource("/resources/ValentinesModeFrame.fxml"));
		Scene scene = new Scene(root);
		Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
		window.setScene(scene);
		//window.initStyle(StageStyle.UNDECORATED);
		window.show();
    }

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		btnPartida.setFocusTraversable(false);
		btnRanking.setFocusTraversable(false);
		btnBack.setFocusTraversable(false);
		btnPlatform.setFocusTraversable(false);
		btnValentine.setFocusTraversable(false);
		
		forniteServer = new ForniteGlobalServer();
		forniteServer.uploadGlobalPlayers();	
		
	}
	
	
	public <T> void loadPlayers(){
		
		forniteServer.getServers().get(4).sort();
		ForniteList<Player> players = forniteServer.getServers().get(4).getPlayers();
		
		for (int i = 0; i < players.size(); i++) {
			match.getData().add( players.get(i));
		}
		
	}


	public ForniteGlobalServer getForniteServer() {
		return forniteServer;
	}

	
	

}

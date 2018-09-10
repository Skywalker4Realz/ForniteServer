package controller;

import java.io.IOException;
import java.net.URL;
import java.util.Observable;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Spinner;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import model.Player;
import javafx.fxml.Initializable;

public class PlatformModeController implements Initializable{

	//
		
	  @FXML
	    private TableView<Player> tablePlayers;

	    @FXML
	    private TableColumn<Player, String> colNickname;

	    @FXML
	    private TableColumn<Player, String> colLevel;

	    @FXML
	    private TableColumn<Player, String> colKills;

	    @FXML
	    private TableColumn<Player, String> colPlatform;

	    @FXML
	    private TableColumn<Player, String> colPing;

	    @FXML
	    private Button btnBack;

	    @FXML
	    private Button btnMatch;

	    @FXML
	    private ComboBox<String> comboPlatform;

	    @FXML
	    private Spinner<Integer> spnNumber;
	    
	    @Override
		public void initialize(URL location, ResourceBundle resources) {
	    	ObservableList<String> options = 
	    		    FXCollections.observableArrayList(
	    		        "Playstation",
	    		        "Xbox",
	    		        "PC"
	    		    );
	    	comboPlatform.setItems(options);
	    	
	    	
	    	
	    	final ObservableList<Player> data = FXCollections.observableArrayList(
				   
				  
				);
			colNickname.setCellValueFactory(new PropertyValueFactory<Player, String>("Nickname"));
			colLevel.setCellValueFactory(new PropertyValueFactory<Player, String>("Level"));
			colKills.setCellValueFactory(new PropertyValueFactory<Player, String>("Kills"));
			colPing.setCellValueFactory(new PropertyValueFactory<Player, String>("Ping"));
			colPlatform.setCellValueFactory(new PropertyValueFactory<Player, String>("Platform"));


			tablePlayers.setItems(data);
			
		}

	    @FXML
	    void findMatch(ActionEvent event) {

	    }

	    @FXML
	    void goBack(ActionEvent event) throws IOException {
	    	Parent root;
			root = FXMLLoader.load(getClass().getResource("/view/Main.fxml"));
			Scene scene = new Scene(root);
			Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
			window.setScene(scene);
			window.show();
	    }


}

package controller;

import java.io.IOException;
import java.net.URL;
import java.util.Observable;
import java.util.ResourceBundle;

import fornite.util.ForniteList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import model.Player;
import javafx.fxml.Initializable;

public class PlatformModeController implements Initializable{

	
		MainController main;
		
		private ObservableList<Player> data;


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
	    	
	    	
	    	data = FXCollections.observableArrayList(
				   
				  
				);
			colNickname.setCellValueFactory(new PropertyValueFactory<Player, String>("Nickname"));
			colLevel.setCellValueFactory(new PropertyValueFactory<Player, String>("Experiencia"));
			colKills.setCellValueFactory(new PropertyValueFactory<Player, String>("Kills"));
			colPing.setCellValueFactory(new PropertyValueFactory<Player, String>("Ping"));
			colPlatform.setCellValueFactory(new PropertyValueFactory<Player, String>("Platform"));


			tablePlayers.setItems(data);
			
			SpinnerValueFactory<Integer> valueFactory = //
	                new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 100, 0);
	 
	        spnNumber.setValueFactory(valueFactory);
	        
	        spnNumber.setStyle(null);
			
		}

	    @FXML
	    void findMatch(ActionEvent event) {
	    	
	    	data.removeAll(data);
	    	
	    	ForniteList<Player> players = null;
	    	if(comboPlatform.getValue() != null) {
	    	if(!comboPlatform.getValue().equalsIgnoreCase(comboPlatform.getPromptText()) && spnNumber.getValue() >0) {
	    
	    		players = main.getForniteServer().findMatchPlataformMode(comboPlatform.getValue(), spnNumber.getValue());
	    		for (int i = players.size()-1; i > -1 ; i--) {
	    			data.add(players.get(i));}
	    		System.out.println(comboPlatform.getValue());
	    		
	    		Alert a = new Alert(AlertType.INFORMATION);
		        a.setContentText("Se ha creado una partida con las restricciones dadas");
		        a.setTitle("FORNITE");
				a.show();
	    	
	    	}}else {
	    		Alert a = new Alert(AlertType.ERROR);
		        a.setContentText("Seleccione restricciones validas");
		        a.setTitle("FORNITE");
				a.show();
	    		
	    	}}
	    	
	    
			


	    @FXML
	    void goBack(ActionEvent event) throws IOException {
	    	FXMLLoader loader = new FXMLLoader();
	        loader.setLocation(getClass().getResource("/resources/Main.fxml"));
	        Parent p = loader.load();
	        Scene scene = new Scene(p);
	        //access the controller and call a method
	        main = loader.getController();
	        
	        //This line gets the Stage information
	        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
	        
	        window.setScene(scene);
	        window.show();
			
	    }

	    public void init(MainController m) {
	    	main = m;
	    }

}

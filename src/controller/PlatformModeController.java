package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

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
import javafx.stage.Stage;
import javafx.fxml.Initializable;

public class PlatformModeController implements Initializable{

	//
		
	  @FXML
	    private TableView<?> tablePlayers;

	    @FXML
	    private TableColumn<?, ?> colNickname;

	    @FXML
	    private TableColumn<?, ?> colLevel;

	    @FXML
	    private TableColumn<?, ?> colKills;

	    @FXML
	    private TableColumn<?, ?> colPlatform;

	    @FXML
	    private TableColumn<?, ?> colPing;

	    @FXML
	    private Button btnBack;

	    @FXML
	    private Button btnMatch;

	    @FXML
	    private ComboBox<?> comboPlatform;

	    @FXML
	    private Spinner<?> spnNumber;
	    
	    @Override
		public void initialize(URL location, ResourceBundle resources) {
			// TODO Auto-generated method stub
			
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

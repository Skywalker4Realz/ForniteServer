package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

public class RankingController implements Initializable {
	
    @FXML
    private TableView<?> tableRanking;
    
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
    private Button btnLAN;

    @FXML
    private Button btnEU;

    @FXML
    private Button btnAFR;

    @FXML
    private Button btnNS;

    @FXML
    private Button btnBack;

    @FXML
    void goToMenu(ActionEvent event) throws IOException {
    	Parent root;
		root = FXMLLoader.load(getClass().getResource("/view/Main.fxml"));
		Scene scene = new Scene(root);
		Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
		window.setScene(scene);
		window.show();
			
    }

    @FXML
    void showAFRRanking(ActionEvent event) {
    }

    @FXML
    void showEURanking(ActionEvent event) {

    }

    @FXML
    void showLANRanking(ActionEvent event) {

    }

    @FXML
    void showNSRanking(ActionEvent event) {

    }

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}

}

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
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import model.ValentinesMode;

public class ValentinesModeController implements Initializable{
	
	private ValentinesMode mode;
	
	 @FXML
	    private GridPane gridWeapons;

	    @FXML
	    private GridPane gridSlots;

	    @FXML
	    private Label slot1;
	    
	    @FXML
	    private Text txtMunicion;


	    @FXML
	    private Button btnShot;

	    @FXML
	    void chooseM4(MouseEvent event) {
	    	mode.putWeapon(mode.M4, "M4");
			Image image = new Image(getClass().getResourceAsStream(mode.getBagpack().top()));
			ImageView a = new ImageView(image);
			a.setFitHeight(150);
			a.setFitWidth(150);
			slot1.setGraphic(a);
			txtMunicion.setText(""+mode.getMunicion());
	    }

	    @FXML
	    void chooseMinigun(MouseEvent event) {
	    	mode.putWeapon(mode.MINUGUN, "MINIGUN");
			Image image = new Image(getClass().getResourceAsStream(mode.getBagpack().top()));
			ImageView a = new ImageView(image);
			a.setFitHeight(150);
			a.setFitWidth(150);
			slot1.setGraphic(a);
			txtMunicion.setText(""+mode.getMunicion());
	    }

	    @FXML
	    void choosePistol(MouseEvent event) {
	    	mode.putWeapon(mode.PISTOL, "PISTOL");
			Image image = new Image(getClass().getResourceAsStream(mode.getBagpack().top()));
			ImageView a = new ImageView(image);
			a.setFitHeight(150);
			a.setFitWidth(150);
			slot1.setGraphic(a);
			txtMunicion.setText(""+mode.getMunicion());
	    }

	    @FXML
	    void chooseRocket(MouseEvent event) {
	    	mode.putWeapon(mode.ROCKET, "ROCKET");
			Image image = new Image(getClass().getResourceAsStream(mode.getBagpack().top()));
			ImageView a = new ImageView(image);
			a.setFitHeight(150);
			a.setFitWidth(150);
			slot1.setGraphic(a);
			txtMunicion.setText(""+mode.getMunicion());
	    }

	    @FXML
	    void chooseSCAR(MouseEvent event) {
	    	mode.putWeapon(mode.SCAR, "SCAR");
			Image image = new Image(getClass().getResourceAsStream(mode.getBagpack().top()));
			ImageView a = new ImageView(image);
			a.setFitHeight(150);
			a.setFitWidth(150);
			slot1.setGraphic(a);
			txtMunicion.setText(""+mode.getMunicion());
	    }
	    
	    

	    @FXML
	    void chooseShotGun(MouseEvent event) {
	    	mode.putWeapon(mode.SHOTGUN, "SHOTGUN");
			Image image = new Image(getClass().getResourceAsStream(mode.getBagpack().top()));
			ImageView a = new ImageView(image);
			a.setFitHeight(150);
			a.setFitWidth(150);
			slot1.setGraphic(a);
			txtMunicion.setText(""+mode.getMunicion());
	    }

	   
	    @FXML
	    void makeShot(ActionEvent event) {
	    	mode.makeShot();;
			Image image = new Image(getClass().getResourceAsStream(mode.getBagpack().top()));
			ImageView a = new ImageView(image);
			a.setFitHeight(150);
			a.setFitWidth(150);
			slot1.setGraphic(a);
			txtMunicion.setText(""+mode.getMunicion());
	    }
	    
	    @FXML
	    void goBack(ActionEvent event) throws IOException {
	    	Parent root;
			root = FXMLLoader.load(getClass().getResource("/resources/Main.fxml"));
			Scene scene = new Scene(root);
			Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
			window.setScene(scene);
			window.show();
	    }

		@Override
		public void initialize(URL location, ResourceBundle resources) {
			
			mode = new ValentinesMode();
	    	System.out.println(mode.getBagpack().top());
			Image image = new Image(getClass().getResourceAsStream(mode.getBagpack().top()));
			ImageView a = new ImageView(image);
			a.setFitHeight(150);
			a.setFitWidth(150);
			slot1.setGraphic(a);
			txtMunicion.setText(""+mode.getMunicion());
			
		}

	    

}

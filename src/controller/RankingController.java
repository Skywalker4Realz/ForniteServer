package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import fornite.util.ForniteList;
import fornite.util.ForniteQueue;
import fornite.util.QueueException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import model.ForniteGlobalServer;
import model.Player;

public class RankingController implements Initializable {
	
	MainController main;

	private ObservableList<Player> data;
	
    @FXML
    private TableView<Player> tableRanking;
    
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

    @FXML
    void showAFRRanking(ActionEvent event) {
    	main.getForniteServer().getServers().get(2).putRanking();
    	data.removeAll(data);
    	tableRanking.getSortOrder().add(colKills);
    	ForniteQueue<Player> ranking = main.getForniteServer().getServers().get(2).getRanking();
    	while(!ranking.isEmpty()) {
    		try {
    			System.out.println(ranking.front().toString());
				data.add((Player) ranking.dequeue());
			} catch (QueueException e) {
			}
    	}
    }

    @FXML
    void showEURanking(ActionEvent event) {
    	main.getForniteServer().getServers().get(1).putRanking();
    	data.removeAll(data);
    	tableRanking.getSortOrder().add(colKills);
    	ForniteQueue<Player> ranking = main.getForniteServer().getServers().get(1).getRanking();
    	while(!ranking.isEmpty()) {
    		try {
				data.add((Player) ranking.dequeue());
			} catch (QueueException e) {
			}
    	}
    }

    @FXML
    void showLANRanking(ActionEvent event) {
    	main.getForniteServer().getServers().get(0).putRanking();
    	data.removeAll(data);
    	tableRanking.getSortOrder().add(colKills);
    	
    	ForniteQueue<Player> ranking = main.getForniteServer().getServers().get(0).getRanking();
    	while(!ranking.isEmpty()) {
    		try {
				data.add((Player) ranking.dequeue());
			} catch (QueueException e) {
			}
    	}
    }

    @FXML
    void showAsiaRanking(ActionEvent event) {
    	main.getForniteServer().getServers().get(3).putRanking();
    	data.removeAll(data);
    	tableRanking.getSortOrder().add(colKills);
    	ForniteQueue<Player> ranking
    	= main.getForniteServer().getServers().get(3).getRanking();
    	while(!ranking.isEmpty()) {
    		try {
				data.add((Player) ranking.dequeue());
			} catch (QueueException e) {
			}
    	}
    }

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		data = FXCollections.observableArrayList();
		
		colNickname.setCellValueFactory(new PropertyValueFactory<Player, String>("Nickname"));
		colLevel.setCellValueFactory(new PropertyValueFactory<Player, String>("Experience"));
		colKills.setCellValueFactory(new PropertyValueFactory<Player, String>("Kills"));
		colKills.setSortable(true);
		colPing.setCellValueFactory(new PropertyValueFactory<Player, String>("Ping"));
		colPlatform.setCellValueFactory(new PropertyValueFactory<Player, String>("Platform"));

		
		tableRanking.setItems(data);
		
	}

}

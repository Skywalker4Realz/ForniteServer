package model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import fornite.util.ForniteList;

public class ForniteGlobalServer {

	public static final int AMERICA = 1;
	public static final int EUROPE = 2;
	public static final int AFRICA = 3;
	public static final int ASIA = 4;

	private ForniteList<Server> servers;
	
	public ForniteGlobalServer() {
		servers = new ForniteList<Server>();
		servers.add(new Server(AMERICA));
		servers.add(new Server(EUROPE));
		servers.add(new Server(AFRICA));
		servers.add(new Server(ASIA));
	}
	
	
	public void uploadGlobalPlayers() {
		File file = new File ("archivo/players.txt");		
		try {
			FileReader reader = new FileReader(file); 
			BufferedReader br = new BufferedReader(reader); 
			String line = "";
			String[] s;
			while((line = br.readLine()) != null){
				s = line.split("-");
				Player p = new Player(s[0], Integer.parseInt(s[1]), 
						Integer.parseInt(s[2]),Integer.parseInt(s[3]), 
						Integer.parseInt(s[4]), Integer.parseInt(s[5]), Integer.parseInt(s[6]));
				
				if(p.getZone()==1) {
					servers.get(0).addPlayer(p);;
				}else if(p.getZone()==2) {
					servers.get(1).addPlayer(p);;
				}else if(p.getZone()==3) {
					servers.get(2).addPlayer(p);;
				}else {
					servers.get(3).addPlayer(p);;
				}	
			}
			br.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}catch(IOException e){
			e.printStackTrace();
		}
	}

	public ForniteList<Server> getServers() {
		return servers;
	}
	
}

package model;

/**
 * This class is responsible for modeling the main server of the Fornite game 
 * depending on its region / continent.
 *@author: Nicolas Martinez  Cristian Molina  Juan Manuel Castillo.
 *@version: 23/08/2018/A
 */

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;

import fornite.util.ForniteList;

public class ForniteGlobalServer {

	public static final int AMERICA = 1;
	public static final int EUROPE = 2;
	public static final int AFRICA = 3;
	public static final int ASIA = 4;
	public static final int GLOBAL = 5;


	private ForniteList<Server> servers;
	private double globalDesviation;
	
	/**
	 * This method is responsible for initializing the forniteGlobalServer.
	 */
	
	public ForniteGlobalServer() {
		servers = new ForniteList<Server>();
		servers.add(new Server(AMERICA));
		servers.add(new Server(EUROPE));
		servers.add(new Server(AFRICA));
		servers.add(new Server(ASIA));
		servers.add(new Server(GLOBAL));
		uploadGlobalPlayers();
		globalList();
		globalDesviation = getStdDev(servers.get(4).getPlayers());
	}
	
	/**
	 * This method is responsible for loading a txt file which contains the players 
	 * which is read for the operation of the main server
	 */
	
	
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

	/**
	 * This method is in charge of once obtained the players divided into zones. Collect them all in
	 * a single list, interpreted as the main list or main server.
	 *  
	 *  @return global of type FortniteList with players from all regions. 
	 */
	
	public void globalList(){
		
		ForniteList<Player> global = new ForniteList<Player>();

		ForniteList<Player> america = servers.get(0).getPlayers();
		ForniteList<Player> europe = servers.get(1).getPlayers();
		ForniteList<Player> africa = servers.get(2).getPlayers();
		ForniteList<Player> asia = servers.get(3).getPlayers();
		
		for (int i = 0; i < america.size(); i++) {
			global.add(america.get(i));
		}for (int i = 0; i < europe.size(); i++) {
			global.add(europe.get(i));
		}for (int i = 0; i < africa.size(); i++) {
			global.add(africa.get(i));
		}for (int i = 0; i < asia.size(); i++) {
			global.add(asia.get(i));
		}
		
		servers.get(4).setPlayers(global);
	}
	
	/**
	 * This method is responsible for obtaining the servers added to the main list.
	 *  
	 *  @return servers of type FortniteList with the region servers.
	 */
	
	public ForniteList<Server> getServers() {
		return servers;
	}
	
	
	public ForniteList<Player> findMatch() {
		ForniteList<Player> match = new ForniteList<Player>();
		
		servers.get(4).sort();
		ForniteList<Player> global = servers.get(4).getPlayers();
		
		
		double stdDesviationGlobal = getStdDev(global);
		
		Random rnd = new Random();
		int x = (int)(rnd.nextDouble() * 500);
		
		System.out.println(x);
		for (int i = x; i < global.size() && i <100; i++) {
			match.add(global.get(i));
		}
		
		double stdDesviationMatch = getStdDev(match);
		
		if(stdDesviationMatch<(stdDesviationGlobal)*2) {
		return match;}
		else {	
			return findMatch();
		}
	}
	
	
	public ForniteList<Player> findMatchPlataformMode(String platform, int num){

		ForniteList<Player> match = new ForniteList<Player>();
		servers.get(4).sort();
		ForniteList<Player> global = servers.get(4).getPlayers();
				
		Random rnd = new Random();
		int x = (int)(rnd.nextDouble() * 100);
		
		for (int i = 0; i < global.size() && match.size() < num; i++) {
			if(global.get(i).getPlatform().equalsIgnoreCase(platform)) {
			match.add(global.get(i));}
		}
		
		return match;
	}
	

	public double getMean(ForniteList<Player> data) {
        double sum = 0.0;
        for(int i=0; i<data.size(); i++ )
            sum += data.get(i).getPing();
        return sum/data.size();
    }

    public double getVariance(ForniteList<Player> data) {
        double mean = getMean(data);
        double temp = 0;
        for(int i=0; i<data.size(); i++ )
            temp += (data.get(i).getPing()-mean)*(data.get(i).getPing()-mean);
        return temp/(data.size()-1);
    }

    public double getStdDev(ForniteList<Player> data) {
        return Math.sqrt(getVariance(data));
    }

	public double getGlobalDesviation() {
		return globalDesviation;
	}
	
    
}

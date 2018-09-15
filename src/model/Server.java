package model;

import fornite.util.ForniteList;
import fornite.util.ForniteQueue;

public class Server {
	
	private int id;
	private ForniteList<Player> players;
	private ForniteQueue<Player> ranking;
	
	
	public Server(int id) {
		this.id = id;
		players = new ForniteList<Player>();
		ranking = new ForniteQueue<Player>();
	}
	
	
	public void addPlayer(Player p) {
		players.add(p);
	}


	public ForniteList<Player> getPlayers() {
		return players;
	}
	
	
}

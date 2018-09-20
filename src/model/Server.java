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
	
	
	public void putRanking() {
	
		sort();
		for (int i = players.size()-1; i > -1; i--) {
			ranking.enqueue(players.get(i));
		}
		
	}
	
	public void putToArray()
	{
		Player[] p = new Player[players.size()];
		for (int i = 0; i < p.length; i++) {
			p[i] = players.get(i);
		}
		
		ForniteList<Player> f = new ForniteList<>();
		for (int i = 0; i < p.length; i++) {
			f.add(p[i]);
		}
		
		players = f;
	}
	public ForniteList<Player> getPlayers() {
		return players;
	}


	public ForniteQueue<Player> getRanking() {
		return ranking;
	}


	public void setPlayers(ForniteList<Player> players) {
		this.players = players;
	}
	
	
	
}

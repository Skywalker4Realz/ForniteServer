package model;

/**
 * This class is responsible for the modeling of a game gathered by 100 players 
 * for x platform depending on different factors such as ranking.
 *@author: Nicolas Martinez  Cristian Molina  Juan Manuel Castillo.
 *@version: 20/09/2018/A
 */

import fornite.util.ForniteList;
import fornite.util.ForniteQueue;

public class Server {
	
	private int id;
	private ForniteList<Player> players;
	private ForniteQueue<Player> ranking;
	
	/**
	 * This method is responsible for initializing the Server.
	 * 
	 * @param id of type int with the server´s identification.
	 */
	
	
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
	
	public void sort()
	{
		int n = players.size();
        for (int i=1; i<n; ++i)
        {
            Player key = players.get(i);
            int j = i-1;
            
            while (j>=0 && players.get(j).compareTo(key) > 0)
            {
                players.set(j+1, players.get(j));
                
                j = j-1;
            }
            players.set(j+1, key);
        }
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

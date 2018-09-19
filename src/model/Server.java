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
	
	public void sort()
	{
		Player[] p = new Player[players.size()];
		for (int i = 0; i < p.length; i++) {
			p[i] = players.get(i);
		}
		quicksort(p, 0, p.length-1);
		ForniteList<Player> f = new ForniteList<>();
		for (int i = 0; i < p.length; i++) {
			f.add(p[i]);
		}
	}
	
	private void quicksort(Player array[], int left, int right) 
	{
		Player pivot= array[left];
		int i=left;
		int j=right;
		Player aux;
		
		while(i<j)
		{            
			while((array[i]).compareTo(pivot)<=0 && i<j)
			{
				i++;
			}
			while(array[j].compareTo(pivot)>0)
			{
				j--;         
			}
			if (i<j)
			{                      
				aux= array[i];                  
				array[i]=array[j];
				array[j]=aux;
			}
		}
		array[left]=array[j];
		array[j]=pivot;
		if(left<j-1)
		{
			quicksort(array,left,j-1);
		}
		if(j+1 <right)
		{
			quicksort(array,j+1,right);
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

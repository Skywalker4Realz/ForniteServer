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
	}
	
	
	
	public void addPlayer(Player p) {
		players.add(p);
	}
	
	
	public void putRanking() {
		sort();
		ranking = new ForniteQueue<Player>();
		for (int i = players.size()-1; i > -1; i-=2) {
			ranking.enqueue(players.get(i));
		}
	}
	
	public void sort()
	{
		Player[] p = new Player[players.size()];
		for (int i = 0; i < players.size(); i++) {
			p[i] = players.get(i);
		}
		
		p = heapSort(p);
		
		ForniteList<Player> f = new ForniteList<>();
		for (int i = 0; i < players.size(); i++) {
			f.add(p[i]);
		}
	
		players = f;	
	}
	
	
	
	public Player[] heapSort(Player arr[])
    {
        int n = arr.length;
 
        // Build heap (rearrange array)
        for (int i = n / 2 - 1; i >= 0; i--)
            heapify(arr, n, i);
 
        // One by one extract an element from heap
        for (int i=n-1; i>=0; i--)
        {
            // Move current root to end
            Player temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
 
            // call max heapify on the reduced heap
            heapify(arr, i, 0);
        }
        
        return arr;
    }
 
    // To heapify a subtree rooted with node i which is
    // an index in arr[]. n is size of heap
    void heapify(Player arr[], int n, int i)
    {
        int largest = i; // Initialize largest as root
        int l = 2*i + 1; // left = 2*i + 1
        int r = 2*i + 2; // right = 2*i + 2
 
        // If left child is larger than root
        if (l < n && arr[l].compareTo(arr[largest])>0 )
            largest = l;
 
        // If right child is larger than largest so far
        if (r < n && arr[r].compareTo(arr[largest])>0)
            largest = r;
 
        // If largest is not root
        if (largest != i)
        {
            Player swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;
 
            // Recursively heapify the affected sub-tree
            heapify(arr, n, largest);
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

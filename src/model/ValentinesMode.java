package model;

import java.util.Hashtable;

import fornite.util.ForniteHashTable;
import fornite.util.ForniteStack;

public class ValentinesMode {
	
	public static final String M4 = "/resources/m4.png";
	public static final String PICK = "/resources/pico.png";
	public static final String SHOTGUN = "/resources/shotgun.png";
	public static final String ROCKET = "/resources/scar.png";
	public static final String MINUGUN = "/resources/minigun.png";
	public static final String PISTOL = "/resources/pistol.png";
	public static final String SCAR = "/resources/scar.png";


	private int municion;
	private ForniteStack<String> bagpack;
	private Hashtable<String, Integer> weapons;
	
	public ValentinesMode() {
		bagpack = new ForniteStack<String>();
		weapons = new Hashtable<String, Integer>();
		
		bagpack.push(PICK);
		setWeapons();
	}
	
	
	public void setWeapons() {
		weapons.put("PICK", 0);
		weapons.put("M4", 20);
		weapons.put("SCAR", 40);
		weapons.put("SHOTGUN", 200);
		weapons.put("PISTOL", 30);
		weapons.put("ROCKET", 40);
		weapons.put("MINIGUN", 50);
	}
	
	public void putWeapon(String w, String k) {
		bagpack.push(w);
		municion = weapons.get(k);
	}
	
	
	public void makeShot() {
		
		if(municion==0 && !bagpack.top().equals(PICK)) {
			bagpack.pop();  municion = 20;
		}else if(!bagpack.top().equals(PICK)) {
			municion--;
		}
	}


	public ForniteStack<String> getBagpack() {
		return bagpack;
	}


	public Hashtable<String, Integer> getWeapons() {
		return weapons;
	}
	
	
	public int getMunicion() {
		return municion;
	}

	
	
}

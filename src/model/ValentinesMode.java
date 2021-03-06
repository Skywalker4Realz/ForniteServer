package model;

/**
 * This class is responsible for modeling the conditions for a special game
 *  of the date of Saint Valentines day
 *@author: Nicolas Martinez  Cristian Molina  Juan Manuel Castillo.
 *@version: 20/09/2018/A
 */

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
	private ForniteStack<Weapon> bagpack;
	private ForniteHashTable<String, Integer> weapons;
	
	/**
	 * This method is responsible for initializing the ValentinesMode.
	 */
	
	public ValentinesMode() {
		bagpack = new ForniteStack<Weapon>();
		weapons = new ForniteHashTable<String, Integer>();
		
		setWeapons();
		bagpack.push(new Weapon(PICK, weapons.get("PICK")));
	}
	
	/**
	 * This method is responsible for establishing the available weapons 
	 * for the Saint Valentines game mode
	 */
	
	public void setWeapons() {
		weapons.put("PICK", 0);
		weapons.put("M4", 20);
		weapons.put("SCAR", 40);
		weapons.put("SHOTGUN", 200);
		weapons.put("PISTOL", 30);
		weapons.put("ROCKET", 40);
		weapons.put("MINIGUN", 50);
	}
	
	/**
	 * This method is responsible for establishing the weapon to use depending
	 * on your ammunition and what is in the bagpack.
	 * 
	 * @param w of type String with the name of the gun
	 * @param k of type String with the number of ammo.
	 */
	
	public void putWeapon(String w, String k) {
		bagpack.push(new Weapon(w, weapons.get(k).intValue()));
	}
	
	
	/**
	 * This method is responsible for reducing the ammunition based on the shots 
	 * made and how much ammunition each weapon possesses.
	 */
	
	public void makeShot() {
		
		if(bagpack.top().getAmmo() ==0 && !bagpack.top().getImg().equalsIgnoreCase(PICK)) {
			bagpack.pop(); 
			if(!bagpack.top().equals(PICK)) {
				bagpack.top().setAmmo(bagpack.top().getAmmo()-1);
			}
		}else if(!bagpack.top().getImg().equalsIgnoreCase(PICK)) {
			bagpack.top().setAmmo(bagpack.top().getAmmo()-1);
		}
	}


	
	
	public ForniteStack<Weapon> getBagpack() {
		return bagpack;
	}


	public ForniteHashTable<String, Integer> getWeapons() {
		return weapons;
	}
	
	
	public int getMunicion() {
		return municion;
	}

	
	
}





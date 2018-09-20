package model;

public class Weapon {

	private String img;
	private int ammo;
	
	public Weapon(String img, int ammo) {
		super();
		this.img = img;
		this.ammo = ammo;
	}

	public String getImg() {
		return img;
	}

	public int getAmmo() {
		return ammo;
	}

	public void setAmmo(int ammo) {
		this.ammo = ammo;
	}
	
	
	
}

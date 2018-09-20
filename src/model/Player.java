package model;


/**
 * This class is responsible for the modeling of a player based on his name, skill, platform,
 * experience, among others, for the use of other services of the program.
 *@author: Nicolas Martinez  Cristian Molina  Juan Manuel Castillo.
 *@version: 20/09/2018/A
 */

<<<<<<< HEAD


=======
>>>>>>> 82a63028aa1449b9bf64288dcc31d610b876ed85
public class Player implements Comparable<Player>{


	//Zone constants
	public static final int AMERICA = 1;
	public static final int AFRICA = 2;
	public static final int EUROPE = 3;
	public static final int ASIA = 4;
	
	//Platform constants
	public static final int PLAYSTATION = 1;
	public static final int XBOX = 2;
	public static final int PC = 3;
	
	private String nickname;
	private int latitude;
	private int longitude;
	private int zone;
	private double kills;
	private double experience;
	private String platform;
	private double ping;
	
	/**
	 * This method is in charge of giving construction to a new generation of values
	 *  which are the characteristics of a player.
	 * 
	 * @param nickname of type String for the identification of the player
	 * @param latitude of type int for the variance
	 * @param longitude of type int for the variance
	 * @param skill of type double with the player's technique/skill
	 * @param experience of type double with the expertise of the player
	 * @param platform of type int with the number indicated by the player's platform
	 */
	
	public Player(String nickname, int latitude, int longitude, double skill, double experience, int platform,
			double ping) {
		super();
		this.nickname = nickname;
		this.latitude = latitude;
		this.longitude = longitude;
		this.kills = skill;
		this.experience = experience;
		setPlatform(platform);
		this.ping = ping;
		setZone();
	}
	
	/**
	 * This method is responsible for establishing the platform in which the 
	 * player is located
	 * @param p of type int with the number indicated by the player's platform.
	 */
	
	public void setPlatform(int p) {
		if(p == PLAYSTATION) {
			platform = "Playstation";
		}else if(p == XBOX) {
			platform = "Xbox";
		}else {
			platform = "PC";
		}
	}
	
	/**
	 * This method is responsible for establishing the area / region 
	 * in which the player is located
	 */
	
	public void setZone()
	{
		if(longitude<=8&&latitude<=5)
		{
			zone = AMERICA;
		}
		else if(latitude<=5&&longitude<=12)
		{
			zone = AFRICA;
		}
		else if(longitude<=12)
		{
			zone = EUROPE;
		}
		else
		{
			zone = ASIA;
		}
	}
	
	
	
	public String getNickname() {
		return nickname;
	}

	public int getZone() {
		return zone;
	}

	public double getKills() {
		return kills;
	}

	public double getExperience() {
		return experience;
	}

	public String getPlatform() {
		return platform;
	}

	
	public double getPing() {
		return ping;
	}

	@Override
	public int compareTo(Player o) {
		int a= 0;
		if(kills>o.kills) {
			a= 1;
		}else if(kills<o.kills) {
			a= -1;
		}else {
//			if(experience>o.experience) {
//				a= 1;
//			}else if(experience<o.experience) {
//				a= -1;
//			}else {
//				if(ping>o.ping) {
//					a= 1;
//				}else if(ping<o.ping) {
//					a= -1;
//				}else {
//					a= 0;
//				}
//			}
			a= 0;
		}
		return a;
		
	}

	@Override
	public String toString() {
		return "Player [nickname=" + nickname + ", kills=" + kills + ", experience=" + experience + ", platform="
				+ platform + ", ping=" + ping + "]";
	}
	
	
	
}
<<<<<<< HEAD

=======
>>>>>>> 82a63028aa1449b9bf64288dcc31d610b876ed85

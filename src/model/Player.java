package model;

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
	
	public void setPlatform(int p) {
		if(p == PLAYSTATION) {
			platform = "Playstation";
		}else if(p == XBOX) {
			platform = "Xbox";
		}else {
			platform = "PC";
		}
	}
	
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

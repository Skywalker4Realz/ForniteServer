package model;

public class Player {

	public Player(String nickname, int latitude, int longitude, double skill, double experience, int platform,
			double ping) {
		super();
		this.nickname = nickname;
		this.latitude = latitude;
		this.longitude = longitude;
		this.skill = skill;
		this.experience = experience;
		this.platform = platform;
		this.ping = ping;
		setZone();
	}
	
	public void setZone()
	{
		if(longitude<=8)
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
	//Zone constants
	public static final int AMERICA = 1;
	public static final int AFRICA = 2;
	public static final int EUROPE = 3;
	public static final int ASIA = 1;
	
	//Platform constants
	public static final int PS4 = 1;
	public static final int XBOX = 2;
	public static final int PC = 3;
	
	private String nickname;
	private int latitude;
	private int longitude;
	private int zone;
	private double skill;
	private double experience;
	private int platform;
	private double ping;
	
	public String getNickname() {
		return nickname;
	}

	public int getZone() {
		return zone;
	}

	public double getSkill() {
		return skill;
	}

	public double getExperience() {
		return experience;
	}

	public int getPlatform() {
		return platform;
	}

	public double getPing() {
		return ping;
	}
	
}

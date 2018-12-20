
public class Player implements Comparable<Player> {

	String name;
	int speed;
	int shooting;
	int passing;
	int dribbling;
	int defending;
	
	public Player(String n, int spd, int sht, int pas, int dri, int def) {
		this.name = n;
		this.speed = spd;
		this.shooting = sht;
		this.passing = pas;
		this.dribbling = dri;
		this.defending = def;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	public int getShooting() {
		return shooting;
	}

	public void setShooting(int shooting) {
		this.shooting = shooting;
	}

	public int getPassing() {
		return passing;
	}

	public void setPassing(int passing) {
		this.passing = passing;
	}

	public int getDribbling() {
		return dribbling;
	}

	public void setDribbling(int dribbling) {
		this.dribbling = dribbling;
	}

	public int getDefending() {
		return defending;
	}

	public void setDefending(int defending) {
		this.defending = defending;
	}

	@Override
	public int compareTo(Player p) {
		
		int thisSum = this.speed + this.shooting + this.passing + this.dribbling + this.defending;
		int otherSum = p.getSpeed() + p.getShooting() + p.getPassing() + p.getDribbling() + p.getDefending();
		
		if (thisSum > otherSum)
			return 1;
		else if (thisSum < otherSum)
			return -1;
		return 0;
	}
	
}

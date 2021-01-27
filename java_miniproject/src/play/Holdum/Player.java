package play.Holdum;

public class Player {
	protected String name;
	protected int points;

	public Player() {}
	public Player(String name) {
		this.name = name;
		points = 300;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPoints() {
		return points;
	}

	public void setPoints(int points) {
		this.points = points;
	}

	@Override
	public String toString() {
		return "Player [name=" + name + ", points=" + points + "]";
	}

}

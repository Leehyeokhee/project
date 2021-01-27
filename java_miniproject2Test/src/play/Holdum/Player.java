package play.Holdum;

public class Player {
	protected String name; //이름
	protected int points; //보유 포인트

	public Player() {}
	public Player(String name) {
		this.name = name;
		points = 300; // 처음에 제공되는 포인트
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

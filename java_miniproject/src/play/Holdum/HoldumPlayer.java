package play.Holdum;

import java.util.ArrayList;

public class HoldumPlayer {
	private String name;
	private int points;
	private ArrayList<Integer> cards = new ArrayList<>(); // 받은 카드 리스트
	private int[] arr = new int[3]; // 오픈한 카드의 배열

	public HoldumPlayer(String name) {
		this.name = name;
		points = 300;
	}

	public HoldumPlayer() {
		name = "AIPlayer";
		points = 1000;
	}

	public int[] getArr() {
		return arr;
	}

	public void setArr(int[] arr) {
		this.arr = arr;
	}

	public ArrayList<Integer> getCards() {
		return cards;
	}

	public void setCards(ArrayList<Integer> cards) {
		this.cards = cards;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getpoints() {
		return points;
	}

	public void setpoints(int points) {
		this.points = points;
	}

	@Override
	public String toString() {
		return "HoldumPlayer [name=" + name + ", points=" + points + "]";
	}

}

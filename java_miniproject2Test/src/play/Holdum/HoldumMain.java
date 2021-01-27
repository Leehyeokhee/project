package play.Holdum;

import java.util.Scanner;

public class HoldumMain {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Player p1 = new HoldumPlayer("Lee");
		HoldumPlayer p2 = ((HoldumPlayer) p1);
		Play p = new Play(p2);
		p.playHoldum(sc);

	}
}

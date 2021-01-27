package play.Holdum;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		HoldumPlayer p1 = new HoldumPlayer("Lee");
		Play p = new Play(p1);
		p.playHoldum(sc);
	}

}

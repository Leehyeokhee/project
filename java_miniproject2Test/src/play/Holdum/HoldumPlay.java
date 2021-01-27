package play.Holdum;

import java.util.ArrayList;
import java.util.Scanner;

public interface HoldumPlay {

	void draw(ArrayList<Integer> deck, Player p1, HoldumPlayer p2); // 카드 분배

	void betting(Scanner sc, Player p); // 플레이어 배팅

	void aiBetting(Player p); // ai 배팅

	void aiFirBetting();

	void openCard(Scanner sc, Player p); // 카드 공개

	void openCard(Player p);

	void openCard();

	int checkSum(Player p1);

	boolean checkRainbow(Player p1);

	void result(HoldumPlayImpl hp, Player p1, HoldumPlayer ai);
}

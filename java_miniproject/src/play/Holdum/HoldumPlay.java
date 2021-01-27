package play.Holdum;

import java.util.ArrayList;
import java.util.Scanner;

public interface HoldumPlay {

	void draw(ArrayList<Integer> deck, HoldumPlayer p1, HoldumPlayer p2); // 카드 분배

	void betting(Scanner sc, HoldumPlayer p); // 플레이어 배팅

	void aiBetting(HoldumPlayer p); // ai 배팅

	void aiFirBetting();

	void openCard(Scanner sc, HoldumPlayer p); // 카드 공개

	void openCard(HoldumPlayer p);

	void openCard();

	void result(HoldumPlayImpl hp, HoldumPlayer p1, HoldumPlayer ai);
	
	int checkSum(HoldumPlayer p1);
	
	boolean checkRainbow(HoldumPlayer p1);

}

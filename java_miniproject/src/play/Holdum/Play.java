package play.Holdum;

import java.util.Scanner;

public class Play {
	private HoldumPlayer p1;
	private HoldumPlayer ai;
	private HoldumPlayImpl hp;

	public Play(HoldumPlayer p1) {
		this.p1 = p1;
		ai = new HoldumPlayer();
		hp = new HoldumPlayImpl();
	}

	public void playHoldum(Scanner sc) {
		System.out.println("============================================");
		System.out.println("Rainbow Holdum 게임을 시작합니다.");
		System.out.println("============================================");

		// 카드 분배
		System.out.println("============================================");
		System.out.println("카드 분배");
		hp.draw(hp.getDeck(), p1, ai);
		System.out.println("============================================");

		// 받은 카드 확인
		System.out.println("============================================");
		System.out.println("카드를 확인하세요");
		for (int c : p1.getCards()) {
			System.out.print(c + " ");
		}
		System.out.println("\n");
		System.out.println("============================================");

		// 카드 1장 오픈
		System.out.println("============================================");
		hp.openCard(sc, p1); // 플레이어
		hp.openCard(ai); // ai
		hp.openCard(); // dealer
		System.out.println("============================================");

		// 첫 번째 배팅
		System.out.println("============================================");
		hp.aiFirBetting(); // 초기 배팅 금액 10
		hp.betting(sc, p1);
		System.out.println("============================================");

		// 두 번째 카드 오픈
		System.out.println("============================================");
		hp.openCard(sc, p1); // 플레이어
		hp.openCard(ai); // ai
		hp.openCard(); // dealer
		System.out.println("============================================");

		// 두 번째 배팅
		System.out.println("============================================");
		hp.aiBetting(ai);
		hp.betting(sc, p1);
		System.out.println("============================================");

		// 세 번째 카드 오픈
		System.out.println("============================================");
		hp.openCard(sc, p1); // 플레이어
		hp.openCard(ai); // ai
		hp.openCard(); // dealer
		System.out.println("============================================");

		// 마지막 배팅
		System.out.println("============================================");
		hp.aiBetting(ai);
		hp.betting(sc, p1);
		System.out.println("============================================");

		// 마지막 딜러 카드 오픈
		System.out.println("============================================");
		hp.openCard(); // dealer
		System.out.println("============================================");
		
		// 카드 합계 계산 및 출력
		System.out.println("============================================");
		System.out.println("카드 합계");
		System.out.println("Player의 합계 : " + hp.checkSum(p1));
		System.out.println("aiPlayer의 합계 : " + hp.checkSum(ai));
		System.out.println("============================================");
		
		// Rainbow 여부 확인
		System.out.println("============================================");
		System.out.println("Rainbow?");
		System.out.println("Player : " + hp.checkRainbow(p1));
		System.out.println("aiPlayer : " + hp.checkRainbow(ai));
		System.out.println("============================================");
		
		// 결과
		System.out.println("============================================");
		hp.result(hp,p1,ai);
		
		
		
		System.out.println("============================================");
		
		
		
		
	}

}

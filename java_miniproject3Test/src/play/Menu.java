package play;

import java.util.Scanner;

import hangman.HmService;
import hangman.HmServiceImpl;
import holdum.HoldumPlayImpl;
import player.Player;
import player.Service;
import player.ServiceImpl;

public class Menu {
	private Service service;
	private HoldumPlayImpl hp;
	private Player ai;
	private HmService hmService;

	public Menu() {
		service = new ServiceImpl();
		hmService = new HmServiceImpl();
	}

	public void run(Scanner sc) {
		boolean flag = true;
//		service.start();
		while (flag) {
			System.out.println("================================ 메인 메뉴 ================================");
			System.out.println("1.플레이어 메뉴 | 2.유러피언 룰렛 | 3.레인보우 홀덤 | 4.행맨 |5.종료");
			int m = sc.nextInt();
			if (m < 1 || m > 5)
				System.out.println("범위 내의 번호를 입력해주세요.");
			switch (m) {
			case 1:
				run_p(sc);
				break;
			case 2:
				run_g(sc);
				break;
			case 3:
				run_rh(sc);
				break;
			case 4:
				run_hm(sc);
				break;
			case 5:
				flag = false;
				break;

			}
		}
//		service.stop();
	}

	public void run_p(Scanner sc) {
		boolean flag = true;
		while (flag) {
			System.out.println("\n=============================== 플레이어 메뉴 ===============================");
			System.out.println("1.플레이어 추가 | 2.플레이어 정보 | 3.포인트 순위 | 4.플레이어 삭제 | 5.메인 메뉴");
			int m = sc.nextInt();
			if (m < 1 || m > 5)
				System.out.println("범위 내의 번호를 입력해주세요.");
			switch (m) {
			case 1:
				service.addPlayer(sc);
				break;
			case 2:
				service.showAllPlayer();
				break;
			case 3:
				service.rankPlayer();
				break;
			case 4:
				service.delPlayer(sc);
				break;
			case 5:
				flag = false;
				break;
			}
		}
	}

	public void run_g(Scanner sc) {

		System.out.println("\n=============================== 유러피언 룰렛 ===============================");
		System.out.println("\n사용할 플레이어를 선택해주세요:");
		service.showAllPlayer();
		int num = 0;
		Player p = null;
		if (service.checkPlayerList() == 0) {
			return;
		} else {
			System.out.print("\n플레이어 번호로 선택: \n");
			num = sc.nextInt();
			if (service.getByNum(num) == null) {
				System.out.println("플레이어 번호를 확인하세요.");
				return;
			} else {
				p = service.getByNum(num);
			}
		}

		boolean flag = true;
		while (flag) {
			System.out.println("\n어떤 베팅을 하시겠습니까?");
			System.out.println("1. Inside Bet | 2. Outside Bet | 3. Return");
			int b = sc.nextInt();
			if (b < 1 || b > 3)
				System.out.println("범위 내의 번호를 입력해주세요.");
			switch (b) {

			case 1:
				System.out.println(
						"\n1. Straight(35배) | 2. Split(17배) | 3. Street(11배) | 4. Corner(8배) | 5. Six Line(5배) | 6. Return");
				int m = sc.nextInt();
				if (m < 1 || m > 6)
					System.out.println("범위 내의 번호를 입력해주세요.");
				int x = (int) (Math.random() * 37);

				switch (m) {

				case 1:
					System.out.println("\n얼마를 베팅하시겠습니까?");
					int bet = sc.nextInt();
					if (bet == 0 || bet < 0) {
						System.out.println("올바르지 않은 베팅 금액입니다.");
						break;
					}
					int reward = (bet * 35);
					if (p.getPoint() < bet) {
						System.out.println("\n포인트가 부족합니다. 현재 보유 중이신 포인트는 " + p.getPoint() + " 포인트 입니다.");
						break;
					} else {
						System.out.println(
								"      0\n 1R  2B  3R\n 4B  5R  6B\n 7R  8B  9R\n10B 11B 12R\n13B 14R 15B\n16R 17B 18R\n19R 20B 21R\n22B 23R 24B\n25R 26B 27R\n28B 29B 30R\n31B 32R 33B\n34R 35B 36R");
						System.out.println("\n어디에 베팅하시겠습니까?\n0 ~ 36 사이의 숫자를 입력해주세요.");
					}
					while (flag) {
						if (p.getPoint() >= bet) {
							int guess = sc.nextInt();
							if (guess < 0 || guess > 36) {
								System.out.println("\n0 ~ 36 사이의 숫자를 입력해주세요.\n");
							} else {
								System.out.println("\n베팅하신 번호는... " + guess + " 입니다.");
								System.out.println("당첨번호는... " + x + " 입니다!");
								if (x == guess) {
									System.out.println("축하합니다! 베팅에 성공하셨습니다!");
									p.setPoint(reward + p.getPoint());
									System.out.println(reward + " 포인트 획득! 현재 보유 포인트: " + p.getPoint());
									break;
								} else {
									System.out.println("아쉽게도 베팅에 실패하였습니다.");
									p.setPoint(p.getPoint() - bet);
									System.out.println("현재 보유 포인트: " + p.getPoint());
									break;
								}
							}
						}
					}
					break;
				case 2:
					System.out.println("\n얼마를 베팅하시겠습니까?");
					int bet2 = sc.nextInt();
					if (bet2 == 0 || bet2 < 0) {
						System.out.println("올바르지 않은 베팅 금액입니다.");
						break;
					}
					int reward2 = (bet2 * 17);
					if (p.getPoint() < bet2) {
						System.out.println("\n포인트가 부족합니다. 현재 보유 중이신 포인트는 " + p.getPoint() + " 포인트 입니다.");
						break;
					} else {
						System.out.println(
								"      0\n 1R  2B  3R\n 4B  5R  6B\n 7R  8B  9R\n10B 11B 12R\n13B 14R 15B\n16R 17B 18R\n19R 20B 21R\n22B 23R 24B\n25R 26B 27R\n28B 29B 30R\n31B 32R 33B\n34R 35B 36R");
						System.out.println("\n어디에 베팅하시겠습니까?\n룰렛 테이블에서 인접한 두 숫자를 입력해주세요.");
					}
					while (flag) {
						if (p.getPoint() >= bet2) {
							int guess = sc.nextInt();
							int guess2 = sc.nextInt();
							if ((guess < 0 || guess > 36) || (guess2 < 0 || guess2 > 36)) {
								System.out.println("\n룰렛 테이블에서 인접한 두 숫자를 입력해주세요.\n");
							} else if (guess == guess2) {
								System.out.println("\n서로 다른 값을 입력해주세요.");
							} else if (guess == (guess2 + 3) || guess == (guess2 - 3) || guess == (guess2 + 1)
									|| guess == (guess2 - 1) || (guess == 0 && guess2 == 2)) {
								System.out.println("\n베팅하신 번호는... " + guess + ", " + guess2 + " 입니다.");
								System.out.println("당첨번호는... " + x + " 입니다!");
								if (x == guess || x == guess2) {
									System.out.println("축하합니다! 베팅에 성공하셨습니다!");
									p.setPoint(reward2 + p.getPoint());
									System.out.println(reward2 + " 포인트 획득! 현재 보유 포인트: " + p.getPoint());
									break;
								} else {
									System.out.println("아쉽게도 베팅에 실패하였습니다.");
									p.setPoint(p.getPoint() - bet2);
									System.out.println("현재 보유 포인트: " + p.getPoint());
									break;
								}
							} else {
								System.out.println("\n룰렛 테이블에서 인접한 두 숫자를 입력해주세요.");
							}
						}
					}
					break;
				case 3:
					System.out.println("\n얼마를 베팅하시겠습니까?");
					int bet3 = sc.nextInt();
					if (bet3 == 0 || bet3 < 0) {
						System.out.println("올바르지 않은 베팅 금액입니다.");
						break;
					}
					int reward3 = (bet3 * 11);
					if (p.getPoint() < bet3) {
						System.out.println("\n포인트가 부족합니다. 현재 보유 중이신 포인트는 " + p.getPoint() + " 포인트 입니다.");
						break;
					} else {
						System.out.println(
								"      0\n 1R  2B  3R\n 4B  5R  6B\n 7R  8B  9R\n10B 11B 12R\n13B 14R 15B\n16R 17B 18R\n19R 20B 21R\n22B 23R 24B\n25R 26B 27R\n28B 29B 30R\n31B 32R 33B\n34R 35B 36R");
						System.out.println("\n어디에 베팅하시겠습니까?\n0, 또는 행의 맨좌측 값을 입력해주세요.");
					}
					while (flag) {
						if (p.getPoint() >= bet3) {
							int guess = sc.nextInt();
							if (guess < 0 || guess > 34) {
								System.out.println("\n0, 또는 행의 맨좌측 값을 입력해주세요.\n");
							}
							if (guess == 1 || guess == 4 || guess == 7 || guess == 10 || guess == 13 || guess == 16
									|| guess == 19 || guess == 22 || guess == 25 || guess == 28 || guess == 31
									|| guess == 34) {
								System.out.println("\n베팅하신 번호는... " + guess + " ~ " + (guess + 2) + " 입니다.");
								System.out.println("당첨번호는... " + x + " 입니다!");
								if (x == guess || x == (guess + 1) || x == (guess + 2)) {
									System.out.println("축하합니다! 베팅에 성공하셨습니다!");
									p.setPoint(reward3 + p.getPoint());
									System.out.println(reward3 + " 포인트 획득! 현재 보유 포인트: " + p.getPoint());
									break;
								} else {
									System.out.println("아쉽게도 베팅에 실패하였습니다.");
									p.setPoint(p.getPoint() - bet3);
									System.out.println("현재 보유 포인트: " + p.getPoint());
									break;
								}
							} else if (guess == 0) {
								System.out.println("[0,1,2] 를 베팅하시려면 1\n[0,2,3] 을 베팅하시려면 2 를 입력해주세요.");
								int z = sc.nextInt();
								if (z < 1 || z > 2) {
									System.out.println("잘못 입력하셨습니다. 베팅 메뉴로 돌아갑니다.");
									break;
								}
								switch (z) {
								case 1:
									System.out.println("\n베팅하신 번호는... 0, 1, 2 입니다.");
									System.out.println("당첨번호는... " + x + " 입니다!");
									if (x == 0 || x == 1 || x == 2) {
										System.out.println("축하합니다! 베팅에 성공하셨습니다!");
										p.setPoint(reward3 + p.getPoint());
										System.out.println(reward3 + " 포인트 획득! 현재 보유 포인트: " + p.getPoint());
										break;
									} else {
										System.out.println("아쉽게도 베팅에 실패하였습니다.");
										p.setPoint(p.getPoint() - bet3);
										System.out.println("현재 보유 포인트: " + p.getPoint());
										break;
									}
								case 2:
									System.out.println("\n베팅하신 번호는... 0, 2, 3 입니다.");
									System.out.println("당첨번호는... " + x + " 입니다!");
									if (x == 0 || x == 2 || x == 3) {
										System.out.println("축하합니다! 베팅에 성공하셨습니다!");
										p.setPoint(reward3 + p.getPoint());
										System.out.println(reward3 + " 포인트 획득! 현재 보유 포인트: " + p.getPoint());
										break;
									} else {
										System.out.println("아쉽게도 베팅에 실패하였습니다.");
										p.setPoint(p.getPoint() - bet3);
										System.out.println("현재 보유 포인트: " + p.getPoint());
										break;
									}
								}
							} else {
								System.out.println("\n0 또는 행의 맨좌측 값을 입력해주세요.");
							}
						}
					}
					break;
				case 4:
					System.out.println("\n얼마를 베팅하시겠습니까?");
					int bet4 = sc.nextInt();
					if (bet4 == 0 || bet4 < 0) {
						System.out.println("올바르지 않은 베팅 금액입니다.");
						break;
					}
					int reward4 = (bet4 * 8);
					if (p.getPoint() < bet4) {
						System.out.println("\n포인트가 부족합니다. 현재 보유 중이신 포인트는 " + p.getPoint() + " 포인트 입니다.");
						break;
					} else {
						System.out.println(
								"      0\n 1R  2B  3R\n 4B  5R  6B\n 7R  8B  9R\n10B 11B 12R\n13B 14R 15B\n16R 17B 18R\n19R 20B 21R\n22B 23R 24B\n25R 26B 27R\n28B 29B 30R\n31B 32R 33B\n34R 35B 36R");
						System.out.println("\n어디에 베팅하시겠습니까?\n[0,1,2,3]을 베팅하시려면 0, 또는 인접한 4개의 값 중 제일 적은 값을 입력해주세요.");
					}
					while (flag) {
						if (p.getPoint() >= bet4) {
							int guess = sc.nextInt();
							if (guess < 0 || guess > 32) {
								System.out.println("\n[0,1,2,3]을 베팅하시려면 0, 또는 인접한 4개의 값 중 제일 적은 값을 입력해주세요.\n");
							} else if (guess == 0) {
								System.out.println("\n베팅하신 번호는... 0, 1, 2, 3 입니다.");
								System.out.println("당첨번호는... " + x + " 입니다!");
								if (x == 0 || x == 1 || x == 2 || x == 3) {
									System.out.println("축하합니다! 베팅에 성공하셨습니다!");
									p.setPoint(reward4 + p.getPoint());
									System.out.println(reward4 + " 포인트 획득! 현재 보유 포인트: " + p.getPoint());
									break;
								} else {
									System.out.println("아쉽게도 베팅에 실패하였습니다.");
									p.setPoint(p.getPoint() - bet4);
									System.out.println("현재 보유 포인트: " + p.getPoint());
									break;
								}
							} else if (guess == 1 || guess == 2 || guess == 4 || guess == 5 || guess == 7 || guess == 8
									|| guess == 10 || guess == 11 || guess == 13 || guess == 14 || guess == 16
									|| guess == 17 || guess == 19 || guess == 20 || guess == 22 || guess == 23
									|| guess == 25 || guess == 26 || guess == 28 || guess == 29 || guess == 31
									|| guess == 32) {
								System.out.println("\n베팅하신 번호는... " + guess + ", " + (guess + 1) + ", " + (guess + 3)
										+ ", " + (guess + 4) + " 입니다.");
								System.out.println("당첨번호는... " + x + " 입니다!");
								if (x == guess || x == (guess + 1) || x == (guess + 3) || x == (guess + 4)) {
									System.out.println("축하합니다! 베팅에 성공하셨습니다!");
									p.setPoint(reward4 + p.getPoint());
									System.out.println(reward4 + " 포인트 획득! 현재 보유 포인트: " + p.getPoint());
									break;
								} else {
									System.out.println("아쉽게도 베팅에 실패하였습니다.");
									p.setPoint(p.getPoint() - bet4);
									System.out.println("현재 보유 포인트: " + p.getPoint());
									break;
								}
							} else {
								System.out.println("\n[0,1,2,3]을 베팅하시려면 0, 또는 인접한 4개의 값 중 제일 적은 값을 입력해주세요.");
							}
						}
					}
					break;
				case 5:
					System.out.println("\n얼마를 베팅하시겠습니까?");
					int bet5 = sc.nextInt();
					if (bet5 == 0 || bet5 < 0) {
						System.out.println("올바르지 않은 베팅 금액입니다.");
						break;
					}
					int reward5 = (bet5 * 5);
					if (p.getPoint() < bet5) {
						System.out.println("\n포인트가 부족합니다. 현재 보유 중이신 포인트는 " + p.getPoint() + " 포인트 입니다.");
						break;
					} else {
						System.out.println(
								"      0\n 1R  2B  3R\n 4B  5R  6B\n 7R  8B  9R\n10B 11B 12R\n13B 14R 15B\n16R 17B 18R\n19R 20B 21R\n22B 23R 24B\n25R 26B 27R\n28B 29B 30R\n31B 32R 33B\n34R 35B 36R");
						System.out.println("\n어디에 베팅하시겠습니까?\n베팅하실 연속되는 여섯개의 숫자 중, 첫번째 숫자를 입력해주세요.(0 ~ 31)");
					}
					while (flag) {
						if (p.getPoint() >= bet5) {
							int guess = sc.nextInt();
							if (guess < 0 || guess > 31) {
								System.out.println("\n베팅하실 연속되는 여섯개의 숫자 중, 첫번째 숫자를 입력해주세요.(0 ~ 31)\n");
							} else {
								System.out.println("\n베팅하신 번호는... " + guess + " ~ " + (guess + 5) + " 입니다.");
								System.out.println("당첨번호는... " + x + " 입니다!");
								if (x == guess || x == (guess + 1) || x == (guess + 2) || x == (guess + 3)
										|| x == (guess + 4) || x == (guess + 5)) {
									System.out.println("축하합니다! 베팅에 성공하셨습니다!");
									p.setPoint(reward5 + p.getPoint());
									System.out.println(reward5 + " 포인트 획득! 현재 보유 포인트: " + p.getPoint());
									break;
								} else {
									System.out.println("아쉽게도 베팅에 실패하였습니다.");
									p.setPoint(p.getPoint() - bet5);
									System.out.println("현재 보유 포인트: " + p.getPoint());
									break;
								}
							}
						}
					}
					break;
				case 6:
					flag = false;
					break;
				}
				break;
			case 2:
				System.out.println(
						"\n1. Column(2배) | 2. Dozens(2배) | 3. Color(1배) | 4. Even or Odd(1배) | 5. Low or High(1배) | 6. Return");
				int m2 = sc.nextInt();
				if (m2 < 1 || m2 > 6)
					System.out.println("범위 내의 번호를 입력해주세요.");
				int x2 = (int) (Math.random() * 37);

				switch (m2) {

				case 1:
					System.out.println("\n얼마를 베팅하시겠습니까?");
					int bet = sc.nextInt();
					if (bet == 0 || bet < 0) {
						System.out.println("올바르지 않은 베팅 금액입니다.");
						break;
					}
					int reward = (bet * 2);
					if (p.getPoint() < bet) {
						System.out.println("\n포인트가 부족합니다. 현재 보유 중이신 포인트는 " + p.getPoint() + " 포인트 입니다.");
						break;
					} else {
						System.out.println(
								"      0\n 1R  2B  3R\n 4B  5R  6B\n 7R  8B  9R\n10B 11B 12R\n13B 14R 15B\n16R 17B 18R\n19R 20B 21R\n22B 23R 24B\n25R 26B 27R\n28B 29B 30R\n31B 32R 33B\n34R 35B 36R");
						System.out.println("\n어디에 베팅하시겠습니까?\n맨좌측 열은 1, 가운데 열은 2, 맨우측 열은 3을 입력해주세요.");
					}
					while (flag) {
						if (p.getPoint() >= bet) {
							int guess = sc.nextInt();
							if (guess < 0 || guess > 3) {
								System.out.println("\n맨좌측 열은 1, 가운데 열은 2, 맨우측 열은 3을 입력해주세요.\n");
							} else if (guess == 1) {
								System.out.println("\n베팅하신 번호는... " + guess + ", " + (guess + 3) + ", " + (guess + 6)
										+ ", " + (guess + 9) + ", " + (guess + 12) + ", " + (guess + 15) + ", "
										+ (guess + 18) + ", " + (guess + 21) + ", " + (guess + 24) + ", " + (guess + 27)
										+ ", " + (guess + 30) + ", " + (guess + 33) + " 입니다.");
								System.out.println("당첨번호는... " + x2 + " 입니다!");
								if (x2 == guess || x2 == (guess + 3) || x2 == (guess + 6) || x2 == (guess + 9)
										|| x2 == (guess + 12) || x2 == (guess + 15) || x2 == (guess + 18)
										|| x2 == (guess + 21) || x2 == (guess + 24) || x2 == (guess + 27)
										|| x2 == (guess + 30) || x2 == (guess + 33)) {
									System.out.println("축하합니다! 베팅에 성공하셨습니다!");
									p.setPoint(reward + p.getPoint());
									System.out.println(reward + " 포인트 획득! 현재 보유 포인트: " + p.getPoint());
									break;
								} else {
									System.out.println("아쉽게도 베팅에 실패하였습니다.");
									p.setPoint(p.getPoint() - bet);
									System.out.println("현재 보유 포인트: " + p.getPoint());
									break;
								}
							} else if (guess == 2) {
								System.out.println("\n베팅하신 번호는... " + guess + ", " + (guess + 3) + ", " + (guess + 6)
										+ ", " + (guess + 9) + ", " + (guess + 12) + ", " + (guess + 15) + ", "
										+ (guess + 18) + ", " + (guess + 21) + ", " + (guess + 24) + ", " + (guess + 27)
										+ ", " + (guess + 30) + ", " + (guess + 33) + " 입니다.");
								System.out.println("당첨번호는... " + x2 + " 입니다!");
								if (x2 == guess || x2 == (guess + 3) || x2 == (guess + 6) || x2 == (guess + 9)
										|| x2 == (guess + 12) || x2 == (guess + 15) || x2 == (guess + 18)
										|| x2 == (guess + 21) || x2 == (guess + 24) || x2 == (guess + 27)
										|| x2 == (guess + 30) || x2 == (guess + 33)) {
									System.out.println("축하합니다! 베팅에 성공하셨습니다!");
									p.setPoint(reward + p.getPoint());
									System.out.println(reward + " 포인트 획득! 현재 보유 포인트: " + p.getPoint());
									break;
								} else {
									System.out.println("아쉽게도 베팅에 실패하였습니다.");
									p.setPoint(p.getPoint() - bet);
									System.out.println("현재 보유 포인트: " + p.getPoint());
									break;
								}
							} else if (guess == 3) {
								System.out.println("\n베팅하신 번호는... " + guess + ", " + (guess + 3) + ", " + (guess + 6)
										+ ", " + (guess + 9) + ", " + (guess + 12) + ", " + (guess + 15) + ", "
										+ (guess + 18) + ", " + (guess + 21) + ", " + (guess + 24) + ", " + (guess + 27)
										+ ", " + (guess + 30) + ", " + (guess + 33) + " 입니다.");
								System.out.println("당첨번호는... " + x2 + " 입니다!");
								if (x2 == guess || x2 == (guess + 3) || x2 == (guess + 6) || x2 == (guess + 9)
										|| x2 == (guess + 12) || x2 == (guess + 15) || x2 == (guess + 18)
										|| x2 == (guess + 21) || x2 == (guess + 24) || x2 == (guess + 27)
										|| x2 == (guess + 30) || x2 == (guess + 33)) {
									System.out.println("축하합니다! 베팅에 성공하셨습니다!");
									p.setPoint(reward + p.getPoint());
									System.out.println(reward + " 포인트 획득! 현재 보유 포인트: " + p.getPoint());
									break;
								} else {
									System.out.println("아쉽게도 베팅에 실패하였습니다.");
									p.setPoint(p.getPoint() - bet);
									System.out.println("현재 보유 포인트: " + p.getPoint());
									break;
								}
							} else {
								System.out.println("\n맨좌측 열은 1\n가운데 열은 2\n맨우측 열은 3을 입력해주세요.");
							}
						}
					}
					break;
				case 2:
					System.out.println("\n얼마를 베팅하시겠습니까?");
					int bet2 = sc.nextInt();
					if (bet2 == 0 || bet2 < 0) {
						System.out.println("올바르지 않은 베팅 금액입니다.");
						break;
					}
					int reward2 = (bet2 * 2);
					if (p.getPoint() < bet2) {
						System.out.println("\n포인트가 부족합니다. 현재 보유 중이신 포인트는 " + p.getPoint() + " 포인트 입니다.");
						break;
					} else {
						System.out.println(
								"      0\n 1R  2B  3R\n 4B  5R  6B\n 7R  8B  9R\n10B 11B 12R\n13B 14R 15B\n16R 17B 18R\n19R 20B 21R\n22B 23R 24B\n25R 26B 27R\n28B 29B 30R\n31B 32R 33B\n34R 35B 36R");
						System.out.println("\n어디에 베팅하시겠습니까?\n1 ~ 12는 1\n13 ~ 24는 2\n25 ~ 36은 3 을 입력해주세요.");
					}
					while (flag) {
						if (p.getPoint() >= bet2) {
							int guess = sc.nextInt();
							if (guess < 0 || guess > 3) {
								System.out.println("\n1 ~ 12는 1,\n13 ~ 24는 2,\n25 ~ 36은 3 을 입력해주세요.\n");
							} else if (guess == 1) {
								System.out.println("\n베팅하신 번호는... 1 ~ 12 입니다.");
								System.out.println("당첨번호는... " + x2 + " 입니다!");
								if (x2 == guess || x2 == (guess + 1) || x2 == (guess + 2) || x2 == (guess + 3)
										|| x2 == (guess + 4) || x2 == (guess + 5) || x2 == (guess + 6)
										|| x2 == (guess + 7) || x2 == (guess + 8) || x2 == (guess + 9)
										|| x2 == (guess + 10) || x2 == (guess + 11)) {
									System.out.println("축하합니다! 베팅에 성공하셨습니다!");
									p.setPoint(reward2 + p.getPoint());
									System.out.println(reward2 + " 포인트 획득! 현재 보유 포인트: " + p.getPoint());
									break;
								} else {
									System.out.println("아쉽게도 베팅에 실패하였습니다.");
									p.setPoint(p.getPoint() - bet2);
									System.out.println("현재 보유 포인트: " + p.getPoint());
									break;
								}
							} else if (guess == 2) {
								System.out.println("\n베팅하신 번호는... 13 ~ 24 입니다.");
								System.out.println("당첨번호는... " + x2 + " 입니다!");
								if ((x2 == guess + 22) || x2 == (guess + 11) || x2 == (guess + 12) || x2 == (guess + 13)
										|| x2 == (guess + 14) || x2 == (guess + 15) || x2 == (guess + 16)
										|| x2 == (guess + 17) || x2 == (guess + 18) || x2 == (guess + 19)
										|| x2 == (guess + 20) || x2 == (guess + 21)) {
									System.out.println("축하합니다! 베팅에 성공하셨습니다!");
									p.setPoint(reward2 + p.getPoint());
									System.out.println(reward2 + " 포인트 획득! 현재 보유 포인트: " + p.getPoint());
									break;
								} else {
									System.out.println("아쉽게도 베팅에 실패하였습니다.");
									p.setPoint(p.getPoint() - bet2);
									System.out.println("현재 보유 포인트: " + p.getPoint());
									break;
								}
							} else if (guess == 3) {
								System.out.println("\n베팅하신 번호는... 25 ~ 36 입니다.");
								System.out.println("당첨번호는... " + x2 + " 입니다!");
								if ((x2 == guess + 22) || x2 == (guess + 23) || x2 == (guess + 24) || x2 == (guess + 25)
										|| x2 == (guess + 26) || x2 == (guess + 27) || x2 == (guess + 28)
										|| x2 == (guess + 29) || x2 == (guess + 30) || x2 == (guess + 31)
										|| x2 == (guess + 32) || x2 == (guess + 33)) {
									System.out.println("축하합니다! 베팅에 성공하셨습니다!");
									p.setPoint(reward2 + p.getPoint());
									System.out.println(reward2 + " 포인트 획득! 현재 보유 포인트: " + p.getPoint());
									break;
								} else {
									System.out.println("아쉽게도 베팅에 실패하였습니다.");
									p.setPoint(p.getPoint() - bet2);
									System.out.println("현재 보유 포인트: " + p.getPoint());
									break;
								}
							} else {
								System.out.println("\n1 ~ 12는 1,\n13 ~ 24는 2,\n25 ~ 36은 3 을 입력해주세요.");
							}
						}
					}
					break;
				case 3:
					System.out.println("\n얼마를 베팅하시겠습니까?");
					int bet3 = sc.nextInt();
					if (bet3 == 0 || bet3 < 0) {
						System.out.println("올바르지 않은 베팅 금액입니다.");
						break;
					}
					int reward3 = bet3;
					if (p.getPoint() < bet3) {
						System.out.println("\n포인트가 부족합니다. 현재 보유 중이신 포인트는 " + p.getPoint() + " 포인트 입니다.");
						break;
					} else {
						System.out.println(
								"      0\n 1R  2B  3R\n 4B  5R  6B\n 7R  8B  9R\n10B 11B 12R\n13B 14R 15B\n16R 17B 18R\n19R 20B 21R\n22B 23R 24B\n25R 26B 27R\n28B 29B 30R\n31B 32R 33B\n34R 35B 36R");
						System.out.println("\n어디에 베팅하시겠습니까?\nBlack (B)는 1, Red (R)은 2를 입력해주세요.");
					}
					while (flag) {
						if (p.getPoint() >= bet3) {
							int guess = sc.nextInt();
							if (guess < 1 || guess > 2) {
								System.out.println("\nBlack (B)는 1, Red (R)은 2를 입력해주세요.\n");
							} else if (guess == 1) {
								System.out.println("\n베팅하신 색은... 검은색입니다.");
								if (x2 == 2 || x2 == 4 || x2 == 6 || x2 == 8 || x2 == 10 || x2 == 11 || x2 == 13
										|| x2 == 15 || x2 == 17 || x2 == 20 || x2 == 22 || x2 == 24 || x2 == 26
										|| x2 == 28 || x2 == 29 || x2 == 31 || x2 == 33 || x2 == 35) {
									System.out.println("당첨번호는... " + x2 + ", 검은색 번호입니다!");
									System.out.println("축하합니다! 베팅에 성공하셨습니다!");
									p.setPoint(reward3 + p.getPoint());
									System.out.println(reward3 + " 포인트 획득! 현재 보유 포인트: " + p.getPoint());
									break;
								} else {
									System.out.println("당첨번호는... " + x2 + ", 빨간색 번호입니다!");
									System.out.println("아쉽게도 베팅에 실패하였습니다.");
									p.setPoint(p.getPoint() - bet3);
									System.out.println("현재 보유 포인트: " + p.getPoint());
									break;
								}
							} else if (guess == 2) {
								System.out.println("\n베팅하신 색은... 빨간색입니다.");
								if (x2 == 1 || x2 == 3 || x2 == 5 || x2 == 7 || x2 == 9 || x2 == 12 || x2 == 14
										|| x2 == 16 || x2 == 18 || x2 == 19 || x2 == 21 || x2 == 23 || x2 == 25
										|| x2 == 27 || x2 == 30 || x2 == 32 || x2 == 34 || x2 == 36) {
									System.out.println("당첨번호는... " + x2 + ", 빨간색 번호입니다!");
									System.out.println("축하합니다! 베팅에 성공하셨습니다!");
									p.setPoint(reward3 + p.getPoint());
									System.out.println(reward3 + " 포인트 획득! 현재 보유 포인트: " + p.getPoint());
									break;
								} else {
									System.out.println("당첨번호는... " + x2 + ", 검은색 번호입니다!");
									System.out.println("아쉽게도 베팅에 실패하였습니다.");
									p.setPoint(p.getPoint() - bet3);
									System.out.println("현재 보유 포인트: " + p.getPoint());
									break;
								}
							} else {
								System.out.println("\nBlack (B)는 1, Red (R)은 2를 입력해주세요.");
							}
						}
					}
					break;
				case 4:
					System.out.println("\n얼마를 베팅하시겠습니까?");
					int bet4 = sc.nextInt();
					if (bet4 == 0 || bet4 < 0) {
						System.out.println("올바르지 않은 베팅 금액입니다.");
						break;
					}
					int reward4 = bet4;
					if (p.getPoint() < bet4) {
						System.out.println("\n포인트가 부족합니다. 현재 보유 중이신 포인트는 " + p.getPoint() + " 포인트 입니다.");
						break;
					} else {
						System.out.println(
								"      0\n 1R  2B  3R\n 4B  5R  6B\n 7R  8B  9R\n10B 11B 12R\n13B 14R 15B\n16R 17B 18R\n19R 20B 21R\n22B 23R 24B\n25R 26B 27R\n28B 29B 30R\n31B 32R 33B\n34R 35B 36R");
						System.out.println("\n어디에 베팅하시겠습니까?\n홀수는 1, 짝수는 2를 입력해주세요.");
					}
					while (flag) {
						if (p.getPoint() >= bet4) {
							int guess = sc.nextInt();
							if (guess < 1 || guess > 2) {
								System.out.println("\n홀수는 1, 짝수는 2를 입력해주세요.\n");
							} else if (guess == 1) {
								System.out.println("\n베팅하신 번호는... 홀수 번호입니다.");
								if (x2 % 2 != 0) {
									System.out.println("당첨번호는... " + x2 + ", 홀수 번호입니다!");
									System.out.println("축하합니다! 베팅에 성공하셨습니다!");
									p.setPoint(reward4 + p.getPoint());
									System.out.println(reward4 + " 포인트 획득! 현재 보유 포인트: " + p.getPoint());
									break;
								} else {
									System.out.println("당첨번호는... " + x2 + ", 짝수 번호입니다!");
									System.out.println("아쉽게도 베팅에 실패하였습니다.");
									p.setPoint(p.getPoint() - bet4);
									System.out.println("현재 보유 포인트: " + p.getPoint());
									break;
								}
							} else if (guess == 2) {
								System.out.println("\n베팅하신 번호는... 짝수 번호입니다.");
								if (x2 % 2 == 0) {
									System.out.println("당첨번호는... " + x2 + ", 짝수 번호입니다!");
									System.out.println("축하합니다! 베팅에 성공하셨습니다!");
									p.setPoint(reward4 + p.getPoint());
									System.out.println(reward4 + " 포인트 획득! 현재 보유 포인트: " + p.getPoint());
									break;
								} else {
									System.out.println("당첨번호는... " + x2 + ", 홀수 번호입니다!");
									System.out.println("아쉽게도 베팅에 실패하였습니다.");
									p.setPoint(p.getPoint() - bet4);
									System.out.println("현재 보유 포인트: " + p.getPoint());
									break;
								}
							} else {
								System.out.println("\n홀수는 1, 짝수는 2를 입력해주세요.");
							}
						}
					}
					break;
				case 5:
					System.out.println("\n얼마를 베팅하시겠습니까?");
					int bet5 = sc.nextInt();
					if (bet5 == 0 || bet5 < 0) {
						System.out.println("올바르지 않은 베팅 금액입니다.");
						break;
					}
					int reward5 = bet5;
					if (p.getPoint() < bet5) {
						System.out.println("\n포인트가 부족합니다. 현재 보유 중이신 포인트는 " + p.getPoint() + " 포인트 입니다.");
						break;
					} else {
						System.out.println(
								"      0\n 1R  2B  3R\n 4B  5R  6B\n 7R  8B  9R\n10B 11B 12R\n13B 14R 15B\n16R 17B 18R\n19R 20B 21R\n22B 23R 24B\n25R 26B 27R\n28B 29B 30R\n31B 32R 33B\n34R 35B 36R");
						System.out.println("\n어디에 베팅하시겠습니까?\n1 ~ 18은 1, 19 ~ 36은 2를 입력해주세요.");
					}
					while (flag) {
						if (p.getPoint() >= bet5) {
							int guess = sc.nextInt();
							if (guess < 1 || guess > 2) {
								System.out.println("\n1 ~ 18은 1, 19 ~ 36은 2를 입력해주세요.\n");
							} else if (guess == 1) {
								System.out.println("\n베팅하신 번호는... 1 ~ 18 입니다.");
								System.out.println("당첨번호는... " + x2 + " 입니다!");
								if (x2 >= 1 && x2 <= 18) {
									System.out.println("축하합니다! 베팅에 성공하셨습니다!");
									p.setPoint(reward5 + p.getPoint());
									System.out.println(reward5 + " 포인트 획득! 현재 보유 포인트: " + p.getPoint());
									break;
								} else {
									System.out.println("아쉽게도 베팅에 실패하였습니다.");
									p.setPoint(p.getPoint() - bet5);
									System.out.println("현재 보유 포인트: " + p.getPoint());
									break;
								}
							} else if (guess == 2) {
								System.out.println("\n베팅하신 번호는... 19 ~ 36 입니다.");
								System.out.println("당첨번호는... " + x2 + " 입니다!");
								if (x2 >= 19 && x2 <= 36) {
									System.out.println("축하합니다! 베팅에 성공하셨습니다!");
									p.setPoint(reward5 + p.getPoint());
									System.out.println(reward5 + " 포인트 획득! 현재 보유 포인트: " + p.getPoint());
									break;
								} else {
									System.out.println("아쉽게도 베팅에 실패하였습니다.");
									p.setPoint(p.getPoint() - bet5);
									System.out.println("현재 보유 포인트: " + p.getPoint());
									break;
								}
							} else {
								System.out.println("\n1 ~ 18은 1, 19 ~ 36은 2를 입력해주세요.");
							}
						}
					}
					break;
				}
				break;
			case 3:
				flag = false;
				break;
			}
		}
	}

	public void run_rh(Scanner sc) {
		hp = new HoldumPlayImpl();
		ai = new Player("aiPlayer",300);
		System.out.println("\n=============================== 레인보우 홀덤 ===============================");
		System.out.println("\n사용할 플레이어를 선택해주세요:");
		service.showAllPlayer();
		int num = 0;
		Player p = null;
		if (service.checkPlayerList() == 0) {
			return;
		} else {
			System.out.print("\n플레이어 번호로 선택: \n");
			num = sc.nextInt();
			if (service.getByNum(num) == null) {
				System.out.println("플레이어 번호를 확인하세요.");
				return;
			} else {
				p = service.getByNum(num);
			}
		}

		System.out.println("============================================");
		System.out.println("Rainbow Holdum 게임을 시작합니다.");
		System.out.println("============================================");

		// 카드 분배
		System.out.println("============================================");
		System.out.println("카드 분배");
		hp.draw(hp.getDeck(), p, ai);
		System.out.println("============================================");

		// 받은 카드 확인
		System.out.println("============================================");
		System.out.println("카드를 확인하세요");
		for (int c : p.getCards()) {
			System.out.print(c + " ");
		}
		System.out.println("\n");
		System.out.println("============================================");

		// 카드 1장 오픈
		System.out.println("============================================");
		hp.openCard(sc, p); // 플레이어
		hp.openCard(ai); // ai
		hp.openCard(); // dealer
		System.out.println("============================================");

		// 첫 번째 배팅
		System.out.println("============================================");
		hp.aiFirBetting(); // 초기 배팅 금액 10
		hp.betting(sc, p);
		System.out.println("============================================");

		// 두 번째 카드 오픈
		System.out.println("============================================");
		hp.openCard(sc, p); // 플레이어
		hp.openCard(ai); // ai
		hp.openCard(); // dealer
		System.out.println("============================================");

		// 두 번째 배팅
		System.out.println("============================================");
		hp.aiBetting(ai);
		hp.betting(sc, p);
		System.out.println("============================================");

		// 세 번째 카드 오픈
		System.out.println("============================================");
		hp.openCard(sc, p); // 플레이어
		hp.openCard(ai); // ai
		hp.openCard(); // dealer
		System.out.println("============================================");

		// 마지막 배팅
		System.out.println("============================================");
		hp.aiBetting(ai);
		hp.betting(sc, p);
		System.out.println("============================================");

		// 마지막 딜러 카드 오픈
		System.out.println("============================================");
		hp.openCard(); // dealer
		System.out.println("============================================");

		// 카드 합계 계산 및 출력
		System.out.println("============================================");
		System.out.println("카드 합계");
		System.out.println("Player의 합계 : " + hp.checkSum(p));
		System.out.println("aiPlayer의 합계 : " + hp.checkSum(ai));
		System.out.println("============================================");

		// Rainbow 여부 확인
		System.out.println("============================================");
		System.out.println("Rainbow?");
		System.out.println("Player : " + hp.checkRainbow(p));
		System.out.println("aiPlayer : " + hp.checkRainbow(ai));
		System.out.println("============================================");

		// 결과
		System.out.println("============================================");
		hp.result(hp, p, ai);
		System.out.println("============================================");

	}

	public void run_hm(Scanner sc) {
		System.out.println("\n=============================== 행맨  ===============================");
		System.out.println("\n사용할 플레이어를 선택해주세요:");
		service.showAllPlayer();
		int num = 0;
		Player p = null;
		if (service.checkPlayerList() == 0) {
			return;
		} else {
			System.out.print("\n플레이어 번호로 선택: \n");
			num = sc.nextInt();
			if (service.getByNum(num) == null) {
				System.out.println("플레이어 번호를 확인하세요.");
				return;
			} else {
				p = service.getByNum(num);
			}
		}
		hmService.playGame(p);
	}
}

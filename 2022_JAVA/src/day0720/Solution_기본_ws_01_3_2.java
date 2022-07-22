package day0720;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution_기본_ws_01_3_2 {

	static int count;
	static int win;
	static int lose;

	public static void main(String[] args) {

		// 3.가위바위보 게임
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int select = 9;
		while (select != 0) {
			System.out.println("===================");
			System.out.println("가위바위보 게임을 시작합니다. 아래 보기 중 하나를 고르세요.");
			System.out.println("1. 5판 3승");
			System.out.println("2. 3판 2승");
			System.out.println("3. 1판 1승");
			System.out.println("0. 종료");
			System.out.print("번호를 입력하세요.");
			try {
				select = Integer.parseInt(br.readLine());
				count = 0;
				switch (select) {
				case 0:
					break;
				case 1:
					while (count < 5 && win < 3) {
						win = 0;
						lose = 0;
						game();
					}
					finalMsgPrinter();
					break;
				case 2:
					while (count < 3 && win < 2) {
						win = 0;
						lose = 0;
						game();
					}
					finalMsgPrinter();
					break;
				case 3:
					win = 0;
					lose = 0;
					game();
					finalMsgPrinter();
					break;
				default:
					System.out.println("잘못 입력하셨습니다.");
					break;
				}
			} catch (NumberFormatException | IOException e) {
				System.out.println("입력하신 값이 유효한 수가 아닙니다.");
				break;
			}
		}
	}
	
	public static void finalMsgPrinter() {
		if (win > lose)
			System.out.println("###축하합니다. 승리했습니다!!!");
		else if (win < lose) 
			System.out.println("###컴퓨터 승!!!");
		else
			System.out.println("###비겼습니다...");
	}

	public static boolean game() throws NumberFormatException, IOException {

		// 찌 > 보 : 1 > 3
		// 보 > 묵 : 3 > 2
		// 묵 > 찌 : 2 > 1

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("가위바위보 중 하나 입력:");
		String input = br.readLine();
		int computerV = (int) (Math.random() * 3) + 1;
		int inputN = 0;
		if (input.equals("묵") || input.equals("바위") || input.equals("주먹")) {
			inputN = 2;
		} else if (input.equals("찌") || input.equals("가위")) {
			inputN = 1;
		} else if (input.equals("빠") || input.equals("보") || input.equals("보자기")) {
			inputN = 3;
		} else {
			System.out.println("가위, 바위, 보 중 하나를 입력해주세요.");
			return false;
		}

		if (inputN == computerV) {
			System.out.println("비겼습니다!!!");
		} else if (inputN == 1) { // 사람이 가위
			if (computerV == 3) {
				System.out.println("이겼습니다!!!");
				win++;
			} else {
				System.out.println("졌습니다!!!");
				lose++;
			}
		} else if (inputN == 2) { // 사람이 바위
			if (computerV == 3) {
				System.out.println("졌습니다!!!");
				lose++;
			}
			else {
				System.out.println("이겼습니다!!!");
				win++;
			}
		} else {
			if (computerV == 1) {
				System.out.println("졌습니다!!!");
				lose++;
			}
			else {
				System.out.println("이겼습니다!!!");
				win++;
			}
		}
		count++;
		return true;
	}
}

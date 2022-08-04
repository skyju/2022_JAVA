package day0804;

import java.util.Arrays;
import java.util.Scanner;

public class Ex_DiceTest {

	static int N, totalCnt;
	static int[] numbers;
	static boolean[] visit;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		N = sc.nextInt(); // 던지는 주사위 수
		int mode = sc.nextInt(); // 던지기 모드

		totalCnt = 0;
		numbers = new int[N];

		switch (mode) {
		case 1:
			dice1(0);
			break;
		case 2:
			visit = new boolean[7]; // 1~6 주사위 눈 선택여부
			dice2(0);
			break;
		case 3:
			dice3(0, 1);
			break;
		case 4:
			dice4(0, 1);
			break;
		default:
			break;
		}

		System.out.println("총 경우의 수 : " + totalCnt);

		sc.close();
	}

	// 주사위 던지기1 : 중복 순열
	private static void dice1(int cnt) {
		if (cnt == N) {
			totalCnt++;
			System.out.println(Arrays.toString(numbers));
			return;
		}

		// 가능한 모든 수 시도
		for (int i = 1; i <= 6; i++) {
			// 수의 중복선택이 가능하므로 중복체크 필요없음!
			numbers[cnt] = i; // 뽑은 주사위 눈이 i
			dice1(cnt + 1); // 다음 주사위 던지러 가기
		}
	}

	// 주사위 던지기2 : 순열
	private static void dice2(int cnt) {
		if (cnt == N) {
			totalCnt++;
			System.out.println(Arrays.toString(numbers));
			return;
		}

		// 가능한 모든 수 시도(1~6)
		for (int i = 1; i <= 6; i++) {
			// 중복 체크 필요
			if (visit[i]) continue;
			numbers[cnt] = i; // 뽑은 주사위 눈이 i
			visit[i] = true;
			dice2(cnt + 1); // 다음 주사위 던지러 가기
			visit[i] = false;
		}
	}

	// 주사위 던지기3 : 중복 조합
	private static void dice3(int cnt, int start) {
		if (cnt == N) {
			totalCnt++;
			System.out.println(Arrays.toString(numbers));
			return;
		}
		
		for (int i = start; i <= 6; i++) {
			numbers[cnt] = i;
			dice3(cnt + 1, i);
		}
	}

	// 주사위 던지기4 : 조합
	private static void dice4(int cnt, int start) {
		if (cnt == N) {
			totalCnt++;
			System.out.println(Arrays.toString(numbers));
			return;
		}
		
		for (int i = start; i <= 6; i++) {
			numbers[cnt] = i;
			dice4(cnt + 1, i + 1);
		}
	}

}

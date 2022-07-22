package day0720;

import java.util.Scanner;

public class Solution_구구단출력 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		System.out.print("숫자를 입력하세요 : ");
		int num = sc.nextInt();
		// 입력한 숫자 검사
		// 0을 입력받으면 반복 종료
		while (num != 0) {
			// 1부터 9까지 곱해서 출력
			for (int i = 1; i <= 9; i++) {
				System.out.printf("%d * %d = %d\n", num, i, num * i);
			}
			System.out.print("다음 숫자 입력 : ");
			num = sc.nextInt();
		}
		sc.close();
		System.out.println("프로그램 종료");
	}

}

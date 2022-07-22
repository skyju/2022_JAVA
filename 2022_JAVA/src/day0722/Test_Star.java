package day0722;

public class Test_Star {
	public static void main(String[] args) {

		int N = 5;

		// 1.
		System.out.println("---1번 문제---");
		for (int i = 0; i < N; i++) {
			for (int j = 0; j <= i; j++)
				System.out.print("*");
			System.out.println();
		}

		// 2.
		System.out.println("---2번 문제---");
		for (int i = N; i > 0; i--) {
			for (int j = 0; j < i; j++)
				System.out.print("*");
			System.out.println();
		}

		// 2-1.
		System.out.println("---2-1번 문제---");
		for (int i = 0; i < N; i++) {
			for (int j = N - 1; j > i; j--)
				System.out.print(" ");
			for (int j = 0; j <= i; j++)
				System.out.print("*");
			System.out.println();
		}

		// 3. 마름모찍기
		System.out.println("---3번 문제---");
		N = 13;
		for (int i = 0; i < N / 2 + 1; i++) {
			for (int j = (N / 2) - 1; j >= i; j--)
				System.out.print(" ");
			for (int j = 0; j < (i * 2) + 1; j++)
				System.out.print("*");
			System.out.println();
		}
		for (int i = 0; i < N / 2; i++) {
			for (int j = i; j < (i * 2) + 1; j++)
				System.out.print(" ");
			for (int j = N - 2; j > (i * 2); j--)
				System.out.print("*");
			System.out.println();
		}

		// 선생님 풀이
		System.out.println("---선생님 풀이 1---");
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < -i + 3; j++)
				System.out.print(" ");
			for (int j = 0; j < 2 * i + 1; j++)
				System.out.print("*");
			System.out.println();
		}
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < i + 1; j++)
				System.out.print(" ");
			for (int j = 0; j < -2 * i + 5; j++)
				System.out.print("*");
			System.out.println();
		}

		System.out.println("---선생님 풀이 2---");
		for (int i = 0; i < 7; i++) {
			int j = i;
			
		}
	}
}

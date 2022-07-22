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

		// 4. reverse 마름모
		System.out.println("---4번 문제---");
		for (int i = 0; i < N; i++) {
			int j = i;
			if (j > N / 2) // 아래쪽을 위해서
				j = -i + (N - 1);
			for (int k = 0; k < -j + (N / 2); k++)
				System.out.print("*");
			for (int k = 0; k < 2 * j + 1; k++)
				System.out.print(" ");
			for (int k = 0; k < -j + (N / 2); k++)
				System.out.print("*");
			System.out.println();
		}

		// 5. 모래시계
		System.out.println("---5번 문제---");
		for (int i = 0; i < N; i++) {
			int j = i;
			if (j > N / 2)
				j = -i + N - 1; // 7일때는 4번째 줄부터 j = 2...
			for (int k = 0; k < j; k++)
				System.out.print(" ");
			for (int k = 0; k < N - (j * 2); k++) // 7일때 4일때부터
				System.out.print("*");
			System.out.println();
		}

		// 마름모 선생님 풀이
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
			if (i >= 4)
				j = -i + 6;
			for (int k = 0; k < -j + 3; k++)
				System.out.print(" ");
			for (int k = 0; k < 2 * j + 1; k++)
				System.out.print("*");
			System.out.println();
		}
	}
}

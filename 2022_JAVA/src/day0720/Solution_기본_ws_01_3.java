package day0720;

public class Solution_기본_ws_01_3 {

	public static void main(String[] args) {

		// 1.
		int N = 5;
		int num = 1;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < i; j++)
				System.out.print("   ");
			for (int j = N - i; j > 0; j--) {
				if (num <= 9)
					System.out.print(" " + num);
				else
					System.out.print(num);
				if (j != 1)
					System.out.print(" ");
				num++;
			}
			System.out.println();
		}

		// 2.
		int cnt = 1;
		for (int i = 0; i < N / 2; i++) {
			for (int j = 0; j < i; j++) {
				System.out.print("   ");
			}
			for (int j = N - i; j > i; j--) {
				if (cnt <= 9)
					System.out.print("  " + cnt);
				else
					System.out.print(" " + cnt);
				++cnt;
			}
			System.out.println();
		}
		{
			for (int i = 0; i < N / 2; i++)
				System.out.print("   ");
			if (cnt <= 9)
				System.out.println(" " + cnt++);
			else
				System.out.println(cnt++);
		}
		for (int i = 0; i < N / 2; i++) {
			for (int j = i + 1; j < N / 2; j++) {
				System.out.print("   ");
			}
			for (int j = 0; j <= (2 * (i + 1)); j++) {
				if (cnt <= 9)
					System.out.print("  " + cnt);
				else
					System.out.print(" " + cnt);
				++cnt;
			}
			System.out.println();
		}
	}

}

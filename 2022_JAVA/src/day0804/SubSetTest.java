package day0804;

import java.util.Scanner;

// n개의 수를 입력받고 가능한 모든 부분집합 생성
public class SubSetTest {
	static int N, totalCnt;
	static int[] input;
	static boolean[] visit;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		totalCnt = 0;

		input = new int[N];
		visit = new boolean[N];

		for (int i = 0; i < N; i++)
			input[i] = sc.nextInt();

		subset(0);
		System.out.println("총 경우의 수 : " + totalCnt);
		
		sc.close();
	}

	private static void subset(int i) { // i : index, 부분집합에 고려해야할 대상 인덱스
		if (i == N) {
			totalCnt++;
			for (int j = 0; j < input.length; j++)
				System.out.print(visit[j] ? input[j] + " " : "  ");
			System.out.println();
			return;
		}
		// 원소 선택
		visit[i] = true;
		subset(i + 1);

		// 원소 미선택
		visit[i] = false;
		subset(i + 1);
	}
}

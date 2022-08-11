package day0811;

import java.util.Arrays;

public class BitMaskingPermutation {

	static int N;
	static int[] numbers;
	static int[] input;
	static int totalCnt;

	public static void main(String[] args) {

		N = 4;
		numbers = new int[N];
		input = new int[N];
		for (int i = 1; i <= 4; i++)
			input[i - 1] = i;
		
		perm(0, 0);
		System.out.println("총 갯수 : " + totalCnt);
	}
	
	// cnt : 직전까지 뽑은 순열에 포함된 수의 개수, cnt + 1 번째에 해당하는 순열에 포함될 수를 뽑기
	// flag : 선택된 수들의 상태를 비트로 표현하고 있는 비트열(정수)
	private static void perm(int cnt, int flag) {
		if (cnt == N) {
			totalCnt++;
			System.out.println(Arrays.toString(numbers));
			return;
		}

		for (int i = 0; i < N; i++) {
			if ((flag & 1 << i) != 0) continue; // 찾아간 i번째 비트가 이미 사용중이면
			numbers[cnt] = input[i];
			perm(cnt + 1, flag | 1 << i);
		}
	}
}

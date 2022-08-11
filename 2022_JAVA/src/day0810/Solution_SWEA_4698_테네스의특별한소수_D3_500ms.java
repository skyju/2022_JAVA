package day0810;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_SWEA_4698_테네스의특별한소수_D3_500ms {

	static String D;
	static int A, B;
	static int ans;
	static int MAX = 1000000;
	static boolean[] primeMemo;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());

		// 에라토스테네스의 체
		primeMemo = new boolean[MAX + 1];
		Arrays.fill(primeMemo, true);
		primeMemo[0] = primeMemo[1] = false;
		int sqrt = (int) Math.sqrt(MAX);
		for (int i = 2; i < sqrt; i++) { //소수의 배수는 모두 소수가 아니다.
			for (int j = i * 2; j <= MAX; j += i) primeMemo[j] = false;
		}

		for (int tc = 1; tc <= T; tc++) {
			sb.append("#").append(tc).append(" ");

			// input & initialize
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			D = st.nextToken();
			A = Integer.parseInt(st.nextToken());
			B = Integer.parseInt(st.nextToken());
			ans = 0;
			for (int i = A; i <= B; i++)
                if (primeMemo[i] && String.valueOf(i).contains(D)) ans++;
			sb.append(ans).append("\n");
		}
		System.out.println(sb.toString());
	}
}
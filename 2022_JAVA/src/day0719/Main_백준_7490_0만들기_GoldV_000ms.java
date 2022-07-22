package day0719;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_백준_7490_0만들기_GoldV_000ms {

	static int N;

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		for (int t = 0; t < tc; t++) {
			N = Integer.parseInt(br.readLine());
			// + , -, 이어붙이기 ... dfs
			dfs(1, 1, 0, 1, "1");
			System.out.println();
		}
	}

	public static void dfs(int idx, int num, int sum, int sign, String ans) {
		if (idx == N) {
			sum += num * sign;
			if (sum == 0)
				System.out.println(ans);
			return;
		}

		// 아스키 코드 고려하여 " ", "+", "-" 순으로 dfs
		dfs(idx + 1, num * 10 + (idx + 1), sum, sign, ans + " " + (idx + 1));
		dfs(idx + 1, idx + 1, sum + (num * sign), 1, ans + "+" + (idx + 1));
		dfs(idx + 1, idx + 1, sum + (num * sign), -1, ans + "-" + (idx + 1));

	}

}

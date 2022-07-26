package day0726;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution_SWEA_1986지그재그숫자_D2_108ms {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(br.readLine());
			
			
			int ans = 0;
			for (int i = 1; i <= N; i++) {
				if (i % 2 == 0) {
					ans -= i;
				} else {
					ans += i;
				}
			}
			System.out.printf("#%d %d\n", tc, ans);
		}
	}
}

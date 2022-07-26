package day0726;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution_SWEA_1945간단한소인수분해_D2_109ms {

	static int[] root = { 2, 3, 5, 7, 11 };

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {

			int N = Integer.parseInt(br.readLine());
			int[] ans = new int[root.length];
			for (int i = 0; i < root.length; i++) {
				int cnt = 0;
				while (N % root[i] == 0) {
					 cnt++;
					 N /= root[i];
				}
				ans[i] = cnt;
			}
			
			System.out.printf("#%d ", tc);
			for (int i = 0; i < ans.length; i++) {
				if (i != ans.length - 1)
					System.out.print(ans[i] + " ");
				else
					System.out.println(ans[i]);
			}
		}
	}
}
